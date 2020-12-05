package backPersistance;
import java.sql.Connection;
import java.sql.DriverManager;

public class Connexion {

	public static Connection getConnexion() {
		Connection cnx = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			cnx = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetjavabd", "root", "");
			// System.out.println("ok");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("connexion echouee");
		}
		return cnx;
	}

}
