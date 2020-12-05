package backPersistance;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import backMetier.Etape;
import backMetier.Etat;
import backMetier.Processus;


public class DaoProcessus {
	private Connection cnx;
	private ResultSet rs;
	private PreparedStatement pstm;
	
	public DaoProcessus() {
		// TODO Auto-generated constructor stub
		super();
		cnx = Connexion.getConnexion();
	}
		
		public ArrayList<Processus> listProcessus() {
			ArrayList<Processus> list = new ArrayList<Processus>();
			Processus proc;
			try {
				pstm = cnx.prepareStatement("SELECT * FROM processus");
				rs = pstm.executeQuery();
				while (rs.next()) {
					proc = new Processus();
					proc.setId_processus(rs.getInt(1));
					proc.setNom_processus(rs.getString(2));
					proc.setDescription_processus(rs.getString(3));
					if(rs.getString(4).equals("ACTIVE"))
					{
						proc.setEtat_processus(Etat.ACTIVE);
					}
					else if(rs.getString(4).equals("ARCHIVE"))
						{
							proc.setEtat_processus(Etat.ARCHIVE);	
						}
					proc.setId_chefDivision(rs.getInt(5));
					list.add(proc);
					}
			} catch (Exception e) {
				e.printStackTrace();
			}
			return list;
		}

		public Processus getProcessus(int id) {
			Processus proc = new Processus();
			try {
				pstm = cnx.prepareStatement("SELECT * FROM processus WHERE id_processus=?;");
				pstm.setInt(1, id);
				rs = pstm.executeQuery();
				if (rs.next()) {
					proc = new Processus();
					proc.setId_processus(rs.getInt(1));
					proc.setNom_processus(rs.getString(2));
					proc.setDescription_processus(rs.getString(3));
					if(rs.getString(4).equals("ACTIVE"))
					{
						proc.setEtat_processus(Etat.ACTIVE);
					}
					else if(rs.getString(4).equals("ARCHIVE"))
						{
							proc.setEtat_processus(Etat.ARCHIVE);	
						}
					}
					proc.setId_chefDivision(rs.getInt(5));
			} catch (Exception e) {
				e.printStackTrace();
			}
			return proc;
		}

		public boolean addProcessus(Processus proc) {
			try {
				pstm = cnx.prepareStatement("insert into processus values (?,?,?,?,?)");
				pstm.setInt(1, proc.getId_processus());
				pstm.setString(2, proc.getNom_processus());
				pstm.setString(3, proc.getDescription_processus());
				if(proc.getEtat_processus().name().equals("ACTIVE"))
				{
					pstm.setString(4, "ACTIVE");
				}
				else if(proc.getEtat_processus().name().equals("ARCHIVE"))
					{
						pstm.setString(4, "ARCHIVE");
					}
				pstm.setInt(5, proc.getId_chefDivision());

				return pstm.executeUpdate() > 0;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		public boolean updateProcessus(Processus proc) {
			try {
				pstm = cnx.prepareStatement("update processus set nom_processus=?, description_processus=?, etat_processus=?, id_chefDivision=? " + "where id_processus=?");
				pstm.setString(1, proc.getNom_processus());
				pstm.setString(2, proc.getNom_processus());
				if(proc.getEtat_processus().name().equals("ACTIVE"))
				{
					pstm.setString(3, "ACTIVE");
				}
				else if(proc.getEtat_processus().name().equals("ARCHIVE"))
				{
						pstm.setString(3, "ARCHIVE");
				}
				pstm.setInt(4, proc.getId_chefDivision());
				pstm.setInt(5, proc.getId_processus());
				return pstm.executeUpdate() > 0;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}

		public boolean affecterProcessus(Processus proc) {
			try {
				pstm = cnx.prepareStatement("update processus set id_chefDivision=? where id_processus=?");
				pstm.setInt(1, proc.getId_chefDivision());
				pstm.setInt(2, proc.getId_processus());
				
				return pstm.executeUpdate() > 0;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
		
		public boolean deleteProcessus(Processus proc) {
			try {
				pstm = cnx.prepareStatement("delete from `processus` where id_processus=?");
				pstm.setInt(1, proc.getId_processus());
				pstm.executeUpdate();

				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}


}
