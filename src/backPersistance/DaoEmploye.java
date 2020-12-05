package backPersistance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import backMetier.ChefDivision;
import backMetier.Employe;
import backMetier.Etat;

public class DaoEmploye {

	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstm;
	

	public DaoEmploye() {
		super();
		cnx = Connexion.getConnexion();
	}
/*
	public ArrayList<Employe> listDocumentProcs() {
		ArrayList<Employe> list = new ArrayList<Employe>();
		Employe employe;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM employe ;");
			rs = pstm.executeQuery();
			while (rs.next()) {
				employe = new Employe();
				employe.setId(rs.getInt(1));
				employe.setNom(rs.getString(2));
				employe.setDesc(rs.getString(3));
				employe.setId_proc(rs.getInt(4));
				list.add(employe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<Employe> listDocumentProc(int id) {
		ArrayList<Employe> list = new ArrayList<Employe>();
		Employe employe;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM document_proc WHERE id_proc=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				employe = new Document_proc();
				employe.setId(rs.getInt(1));
				employe.setNom(rs.getString(2));
				employe.setDesc(rs.getString(3));
				doc.setId_proc(rs.getInt(4));
				list.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
*/
	public ArrayList<Employe> listEmployes() {
		ArrayList<Employe> list = new ArrayList<Employe>();
		Employe employe;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM employe");
			rs = pstm.executeQuery();
			while (rs.next()) {
				employe = new Employe();
				employe.setId_employe(rs.getInt(1));
				employe.setNom_employe(rs.getString(2));
				employe.setPrenom_employe(rs.getString(3));;
				employe.setPassword_employe(rs.getString(4));
				employe.setMail_employe(rs.getString(5));
				employe.setTel_employe(rs.getString(6));
				if(rs.getString(7).equals("ACTIVE"))
				{
					employe.setEtat_employe(Etat.ACTIVE);
				}
				else if(rs.getString(7).equals("ARCHIVE"))
				{
					employe.setEtat_employe(Etat.ARCHIVE);	
				}
				list.add(employe);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Employe getEmploye(int id) {
		Employe Employe = null;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM Employe WHERE id_employe=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				Employe = new Employe();
				Employe.setId_employe(rs.getInt(1));
				Employe.setNom_employe(rs.getString(2));
				Employe.setPrenom_employe(rs.getString(3));;
				Employe.setPassword_employe(rs.getString(4));
				Employe.setMail_employe(rs.getString(5));
				Employe.setTel_employe(rs.getString(6));
				if(rs.getString(7).equals("ACTIVE"))
				{
					Employe.setEtat_employe(Etat.ACTIVE);
				}
				else if(rs.getString(7).equals("ARCHIVE"))
				{
					Employe.setEtat_employe(Etat.ARCHIVE);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Employe;
	}
	
	public boolean addEmploye(Employe employe) {
		try {
			pstm = cnx.prepareStatement("insert into employe values (?,?,?,?,?,?,?)");
			pstm.setInt(1, employe.getId_employe());
			pstm.setString(2, employe.getNom_employe());
			pstm.setString(3, employe.getPrenom_employe());
			pstm.setString(4, employe.getPassword_employe());
			pstm.setString(5, employe.getMail_employe());
			pstm.setString(6, employe.getTel_employe());
			if(employe.getEtat_employe().name().equals("ACTIVE"))
			{
				pstm.setString(7, "ACTIVE");
			}
			else if(employe.getEtat_employe().name().equals("ARCHIVE"))
			{
				pstm.setString(7, "ARCHIVE");
			}
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEmploye(Employe employe) {
		try {
			pstm = cnx.prepareStatement("update employe set nom_employe=?, prenom_employe=?, password_employe=? , mail_employe=?, tel_employe=? , etat_employe=?" + "where id_employe=?");
			pstm.setString(1, employe.getNom_employe());
			pstm.setString(2, employe.getPrenom_employe());
			pstm.setString(3, employe.getPassword_employe());
			pstm.setString(4, employe.getMail_employe());
			pstm.setString(5, employe.getTel_employe());
			if(employe.getEtat_employe().name().equals("ACTIVE"))
			{
				pstm.setString(6, "ACTIVE");
			}
			else if(employe.getEtat_employe().name().equals("ARCHIVE"))
			{
				pstm.setString(6, "ARCHIVE");
			}
			pstm.setInt(7, employe.getId_employe());
			
			
	        
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEmploye(Employe employe) {
		try {
			pstm = cnx.prepareStatement("delete from employe where id_employe=?");
			pstm.setInt(1, employe.getId_employe());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
