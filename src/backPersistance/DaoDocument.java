package backPersistance;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import backMetier.ChefDivision;
import backMetier.Document;
import backMetier.Employe;
import backMetier.Etat;

public class DaoDocument {


	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstm;
	

	public DaoDocument() {
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
	public ArrayList<Document> listDocuments() {
		ArrayList<Document> list = new ArrayList<Document>();
		Document document;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM document");
			rs = pstm.executeQuery();
			while (rs.next()) {
				document = new Document();
				document.setId_document(rs.getInt(1));
				document.setNom_document(rs.getString(2));
				document.setDescription_document(rs.getString(3));;
				document.setId_demande(rs.getInt(4));
				if(rs.getString(5).equals("ACTIVE"))
				{
					document.setEtat_document(Etat.ACTIVE);
				}
				else if(rs.getString(5).equals("ARCHIVE"))
				{
					document.setEtat_document(Etat.ARCHIVE);	
				}
				list.add(document);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Document getDocument(int id) {
		Document Document = null;
		try {
			pstm = cnx.prepareStatement("SELECT * FROM Document WHERE id_document=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				Document = new Document();
				Document.setId_document(rs.getInt(1));
				Document.setNom_document(rs.getString(2));
				Document.setDescription_document(rs.getString(3));;
				Document.setId_demande(rs.getInt(4));
				if(rs.getString(5).equals("ACTIVE"))
				{
					Document.setEtat_document(Etat.ACTIVE);
				}
				else if(rs.getString(5).equals("ARCHIVE"))
				{
					Document.setEtat_document(Etat.ARCHIVE);	
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Document;
	}
	
	public boolean addDocument(Document document) {
		try {
			pstm = cnx.prepareStatement("insert into document values (?,?,?,?,?)");
			pstm.setInt(1, document.getId_document());
			pstm.setString(2, document.getNom_document());
			pstm.setString(3, document.getDescription_document());
			pstm.setInt(4, document.getId_demande());
			if(document.getEtat_document().name().equals("ACTIVE"))
			{
				pstm.setString(5, "ACTIVE");
			}
			else if(document.getEtat_document().name().equals("ARCHIVE"))
			{
				pstm.setString(5, "ARCHIVE");
			}
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateDocument(Document document) {
		try {
			pstm = cnx.prepareStatement("update document set nom_document=?, description_document=?, id_demande=? , etat_document=?" + "where id_document=?");
			pstm.setString(1, document.getNom_document());
			pstm.setString(2, document.getDescription_document());
			pstm.setInt(3, document.getId_demande());
			if(document.getEtat_document().name().equals("ACTIVE"))
			{
				pstm.setString(4, "ACTIVE");
			}
			else if(document.getEtat_document().name().equals("ARCHIVE"))
			{
				pstm.setString(4, "ARCHIVE");
			}
			pstm.setInt(5, document.getId_document());
			
			
	        
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteDocument(Document document) {
		try {
			pstm = cnx.prepareStatement("delete from document where id_document=?");
			pstm.setInt(1, document.getId_document());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

}
