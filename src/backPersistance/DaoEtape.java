package backPersistance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import backMetier.Employe;
import backMetier.Etape;

public class DaoEtape {

	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstm;
	

	public DaoEtape() {
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
	public ArrayList<Etape> listEtapes() {
		ArrayList<Etape> list = new ArrayList<Etape>();
		Etape etape;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM etape");
			rs = pstm.executeQuery();
			while (rs.next()) {
				etape = new Etape();
				etape.setId_etape(rs.getInt(1));
				etape.setNom_etape(rs.getString(2));
				etape.setDescription_etape(rs.getString(3));;
				etape.setRapport_etape(rs.getString(4));
				etape.setEmploye_etape(rs.getInt(5));
				etape.setProcessus_etape(rs.getInt(6));
				list.add(etape);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Etape getEtape(int id) {
		Etape etape = null;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM etape WHERE id_etape=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				etape = new Etape();
				etape.setId_etape(rs.getInt(1));
				etape.setNom_etape(rs.getString(2));
				etape.setDescription_etape(rs.getString(3));;
				etape.setRapport_etape(rs.getString(4));
				etape.setEmploye_etape(rs.getInt(5));
				etape.setProcessus_etape(rs.getInt(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return etape;
	}
	
	public boolean addEtape(Etape etape) {
		try {
			pstm = cnx.prepareStatement("insert into etape values (?,?,?,?,?,?)");
			pstm.setInt(1, etape.getId_etape());
			pstm.setString(2, etape.getNom_etape());
			pstm.setString(3, etape.getDescription_etape());
			pstm.setString(4, etape.getRapport_etape());
			pstm.setInt(5, etape.getEmploye_etape());
			pstm.setInt(6, etape.getProcessus_etape());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateEtape(Etape etape) {
		try {
			pstm = cnx.prepareStatement("update etape set nom_etape=?, description_etape=?, rapport_etape=? , id_employe=?, id_processus=?" + "where id_etape=?");
			pstm.setString(1, etape.getNom_etape());
			pstm.setString(2, etape.getDescription_etape());
			pstm.setString(3, etape.getRapport_etape());
			pstm.setInt(4, etape.getEmploye_etape());
			pstm.setInt(5, etape.getProcessus_etape());
			pstm.setInt(6, etape.getId_etape());
			
	        
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean affecterEtape(Etape etape) {
		try {
			pstm = cnx.prepareStatement("update etape set id_employe=? where id_etape=?");
			pstm.setInt(1, etape.getEmploye_etape());
			pstm.setInt(2, etape.getId_etape());
			
	        
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteEtape(Etape etape) {
		try {
			pstm = cnx.prepareStatement("delete from etape where id_etape=?");
			pstm.setInt(1, etape.getId_etape());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
