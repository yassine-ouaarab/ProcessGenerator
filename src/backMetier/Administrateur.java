package backMetier;

public class Administrateur {
	
	
	
	private int id_admin;
	private String nom_admin;
	private String prenom_admin;
	private String mail_admin;
	private String password_admin;
	private String tel_admin;
	
	
	
	public Administrateur() {
		super();
	
	}
	
	public Administrateur(int id_admin) {
		super();
		this.id_admin = id_admin;
	}


	public Administrateur(int id_admin, String nom_admin, String prenom_admin,
			String password_admin, String mail_admin, String tel_admin) {
		super();
		this.id_admin = id_admin;
		this.nom_admin = nom_admin;
		this.prenom_admin = prenom_admin;
		this.mail_admin = mail_admin;
		this.password_admin = password_admin;
		this.tel_admin = tel_admin;
	}


	public int getId_admin() {
		return id_admin;
	}


	public void setId_admin(int id_admin) {
		this.id_admin = id_admin;
	}


	public String getNom_admin() {
		return nom_admin;
	}


	public void setNom_admin(String nom_admin) {
		this.nom_admin = nom_admin;
	}


	public String getPrenom_admin() {
		return prenom_admin;
	}


	public void setPrenom_admin(String prenom_admin) {
		this.prenom_admin = prenom_admin;
	}


	public String getMail_admin() {
		return mail_admin;
	}


	public void setMail_admin(String mail_admin) {
		this.mail_admin = mail_admin;
	}


	public String getPassword_admin() {
		return password_admin;
	}


	public void setPassword_admin(String password_admin) {
		this.password_admin = password_admin;
	}


	public String getTel_admin() {
		return tel_admin;
	}


	public void setTel_admin(String tel_admin) {
		this.tel_admin = tel_admin;
	}
	
	
	
	
	
	

}

