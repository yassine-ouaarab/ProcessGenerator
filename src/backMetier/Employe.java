package backMetier;

public class Employe {

	private int id_employe;
	private String nom_employe;
	private String prenom_employe;
	private String password_employe;
	private String mail_employe;
	private String tel_employe;
	private Etat etat_employe;

	public Employe() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public Employe(int id_employe) {
		super();
		this.id_employe = id_employe;
	}


	public Employe(int id_employe, String nom_employe, String prenom_employe, String password_employe,
			String mail_employe, String tel_employe) {
		super();
		this.id_employe = id_employe;
		this.nom_employe = nom_employe;
		this.prenom_employe = prenom_employe;
		this.password_employe = password_employe;
		this.mail_employe = mail_employe;
		this.tel_employe = tel_employe;
	}
	
	public Employe(int id_employe, String nom_employe, String prenom_employe, String password_employe,
			String mail_employe, String tel_employe ,Etat etat_employe) {
		super();
		this.id_employe = id_employe;
		this.nom_employe = nom_employe;
		this.prenom_employe = prenom_employe;
		this.password_employe = password_employe;
		this.mail_employe = mail_employe;
		this.tel_employe = tel_employe;
		this.etat_employe = etat_employe;
	}

	public int getId_employe() {
		return id_employe;
	}

	public void setId_employe(int id_employe) {
		this.id_employe = id_employe;
	}

	public String getNom_employe() {
		return nom_employe;
	}

	public void setNom_employe(String nom_employe) {
		this.nom_employe = nom_employe;
	}

	public String getPrenom_employe() {
		return prenom_employe;
	}

	public void setPrenom_employe(String prenom_employe) {
		this.prenom_employe = prenom_employe;
	}

	public String getPassword_employe() {
		return password_employe;
	}

	public void setPassword_employe(String password_employe) {
		this.password_employe = password_employe;
	}

	public String getMail_employe() {
		return mail_employe;
	}

	public void setMail_employe(String mail_employe) {
		this.mail_employe = mail_employe;
	}

	public String getTel_employe() {
		return tel_employe;
	}

	public void setTel_employe(String tel_employe) {
		this.tel_employe = tel_employe;
	}



	public Etat getEtat_employe() {
		return etat_employe;
	}



	public void setEtat_employe(Etat etat_employe) {
		this.etat_employe = etat_employe;
	}


}
