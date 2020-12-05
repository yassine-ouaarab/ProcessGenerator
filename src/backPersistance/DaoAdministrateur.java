package backPersistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import backMetier.Administrateur;


public class DaoAdministrateur {
	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstm;

	public DaoAdministrateur() {
		super();
		cnx = Connexion.getConnexion();
	}

	public ArrayList<Administrateur> listAdmins() {
		ArrayList<Administrateur> list = new ArrayList<Administrateur>();
		Administrateur admin;
		try {
			pstm = cnx.prepareStatement("select * from admin");
			rs = pstm.executeQuery();
			while (rs.next()) {
				admin = new Administrateur();
				admin.setId_admin(rs.getInt(1));
				admin.setNom_admin(rs.getString(2));
				admin.setPrenom_admin(rs.getString(3));
				admin.setMail_admin(rs.getString(4));
				admin.setPassword_admin(rs.getString(5));
				admin.setTel_admin(rs.getString(6));
				list.add(admin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}

	public Administrateur getAdmin(int id) {
		Administrateur admin = new Administrateur();
		try {
			pstm = cnx.prepareStatement("select * from admin where id_admin=?;");
			pstm.setInt(1, id);
			rs = pstm.executeQuery();
			if (rs.next()) {
				admin = new Administrateur();
				admin.setId_admin(rs.getInt(1));
				admin.setNom_admin(rs.getString(2));
				admin.setPrenom_admin(rs.getString(3));
				admin.setMail_admin(rs.getString(4));
				admin.setPassword_admin(rs.getString(5));
				admin.setTel_admin(rs.getString(6));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return admin;
	}

	public boolean addAdmin(Administrateur admin) {
		try {
			pstm = cnx.prepareStatement(
					"insert into admin(id_admin,nom_admin,prenom_admin,mail_admin,"
					+ "password_admin,tel_admin) " + "values (?,?,?,?,?,?)");
			pstm.setInt(1, admin.getId_admin());
			pstm.setString(2, admin.getNom_admin());
			pstm.setString(3, admin.getPrenom_admin());
			pstm.setString(4, admin.getMail_admin());
			pstm.setString(5, admin.getPassword_admin());
			pstm.setString(6, admin.getTel_admin());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean updateAdmin(Administrateur admin) {
		try {
			pstm = cnx.prepareStatement("update admin set nom_admin=?, prenom_admin=?,"
					+ " mail_admin=?, password_admin=?, tel_admin=? where id_admin=?");
			pstm.setString(1, admin.getNom_admin());
			pstm.setString(2, admin.getPrenom_admin());
			pstm.setString(3, admin.getMail_admin());
			pstm.setString(4, admin.getPassword_admin());
			pstm.setString(5, admin.getTel_admin());
			pstm.setInt(6, admin.getId_admin());
			return pstm.executeUpdate() > 0;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public boolean deleteAdmin(Administrateur admin) {
		try {
			pstm = cnx.prepareStatement("delete from admin where id_admin=?");
			pstm.setInt(1, admin.getId_admin());
			pstm.executeUpdate();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
