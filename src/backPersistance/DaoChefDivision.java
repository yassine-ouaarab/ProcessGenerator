package backPersistance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import backMetier.ChefDivision;
import backMetier.Etat;

public class DaoChefDivision {

	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstm;
	

	public DaoChefDivision() {
		super();
		cnx = Connexion.getConnexion();
	}
/*
	public ArrayList<ChefDivision> listDocumentProcs() {
		ArrayList<ChefDivision> list = new ArrayList<ChefDivision>();
		ChefDivision ChefDivision;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM ChefDivision ;");
			rs = pstm.executeQuery();
			while (rs.next()) {
				ChefDivision = new ChefDivision();
				ChefDivision.setId(rs.getInt(1));
				ChefDivision.setNom(rs.getString(2));
				ChefDivision.setDesc(rs.getString(3));
				ChefDivision.setId_proc(rs.getInt(4));
				list.add(ChefDivision);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ArrayList<ChefDivision> listDocumentProc(int id) {
		ArrayList<ChefDivision> list = new ArrayList<ChefDivision>();
		ChefDivision ChefDivision;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM document_proc WHERE id_proc=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			while (rs.next()) {
				ChefDivision = new Document_proc();
				ChefDivision.setId(rs.getInt(1));
				ChefDivision.setNom(rs.getString(2));
				ChefDivision.setDesc(rs.getString(3));
				doc.setId_proc(rs.getInt(4));
				list.add(doc);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
*/
	public ArrayList<ChefDivision> listChefDivisions() {
		ArrayList<ChefDivision> list = new ArrayList<ChefDivision>();
		ChefDivision ChefDivision;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM ChefDivision");
			rs = pstm.executeQuery();
			while (rs.next()) {
				ChefDivision = new ChefDivision();
				ChefDivision.setId_chefDivision(rs.getInt(1));
				ChefDivision.setNom_chefDivision(rs.getString(2));
				ChefDivision.setPrenom_chefDivision(rs.getString(3));;
				ChefDivision.setPassword_chefDivision(rs.getString(4));
				ChefDivision.setMail_chefDivision(rs.getString(5));
				ChefDivision.setTel_chefDivision(rs.getString(6));

				if(rs.getString(7).equals("ACTIVE"))
				{
					ChefDivision.setEtat_chefDivision(Etat.ACTIVE);
				}
				else if(rs.getString(7).equals("ARCHIVE"))
				{
					ChefDivision.setEtat_chefDivision(Etat.ARCHIVE);	
				}
				
				list.add(ChefDivision);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public ChefDivision getChefDivision(int id) {
		ChefDivision ChefDivision = null;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM ChefDivision WHERE id_chefDivision=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				ChefDivision = new ChefDivision();
				ChefDivision.setId_chefDivision(rs.getInt(1));
				ChefDivision.setNom_chefDivision(rs.getString(2));
				ChefDivision.setPrenom_chefDivision(rs.getString(3));;
				ChefDivision.setPassword_chefDivision(rs.getString(4));
				ChefDivision.setMail_chefDivision(rs.getString(5));
				ChefDivision.setTel_chefDivision(rs.getString(6));
				
				if(rs.getString(7).equals("ACTIVE"))
				{
					ChefDivision.setEtat_chefDivision(Etat.ACTIVE);
				}
				else if(rs.getString(7).equals("ARCHIVE"))
				{
					ChefDivision.setEtat_chefDivision(Etat.ARCHIVE);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return ChefDivision;
	}

	public boolean addChefDivision(ChefDivision ChefDivision) {
		try {
			pstm = cnx.prepareStatement("insert into ChefDivision values (?,?,?,?,?,?,?)");
			pstm.setInt(1, ChefDivision.getId_chefDivision());
			pstm.setString(2, ChefDivision.getNom_chefDivision());
			pstm.setString(3, ChefDivision.getPrenom_chefDivision());
			pstm.setString(4, ChefDivision.getPassword_chefDivision());
			pstm.setString(5, ChefDivision.getMail_chefDivision());
			pstm.setString(6, ChefDivision.getTel_chefDivision());
			if(ChefDivision.getEtat_chefDivision().name().equals("ACTIVE"))
			{
				pstm.setString(7, "ACTIVE");
			}
			else if(ChefDivision.getEtat_chefDivision().name().equals("ARCHIVE"))
			{
				pstm.setString(7, "ARCHIVE");
			}
			
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateChefDivision(ChefDivision ChefDivision) {
		try {
			pstm = cnx.prepareStatement("update ChefDivision set nom_chefDivision=?, prenom_chefDivision=?, password_chefDivision=? , mail_chefDivision=?, tel_chefDivision=?, etat_chefDivision=?" + "where id_chefDivision=?");
			pstm.setString(1, ChefDivision.getNom_chefDivision());
			pstm.setString(2, ChefDivision.getPrenom_chefDivision());
			pstm.setString(3, ChefDivision.getPassword_chefDivision());
			pstm.setString(4, ChefDivision.getMail_chefDivision());
			pstm.setString(5, ChefDivision.getTel_chefDivision());
			if(ChefDivision.getEtat_chefDivision().name().equals("ACTIVE"))
			{
				pstm.setString(6, "ACTIVE");
			}
			else if(ChefDivision.getEtat_chefDivision().name().equals("ARCHIVE"))
			{
				pstm.setString(6, "ARCHIVE");
			}
			pstm.setInt(7, ChefDivision.getId_chefDivision());
			
	        
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteChefDivision(ChefDivision ChefDivision) {
		try {
			pstm = cnx.prepareStatement("delete from ChefDivision where id_ChefDivision=?");
			pstm.setInt(1, ChefDivision.getId_chefDivision());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
