package backMetier;

public class ChefDivision {

	private int id_chefDivision;
	private String nom_chefDivision;
	private String prenom_chefDivision;
	private String password_chefDivision;
	private String mail_chefDivision;
	private String tel_chefDivision;
	private Etat etat_chefDivision;
	
	public ChefDivision() {
		// TODO Auto-generated constructor stub
		super();
	}
	
	/**
	 * @param id_chefDivision
	 */
	public ChefDivision(int id_chefDivision) {
		super();
		this.id_chefDivision = id_chefDivision;
	}

	public ChefDivision(int id_chefDivision, String nom_chefDivision, String prenom_chefDivision, String password_chefDivision,
			String mail_chefDivision, String tel_chefDivision) {
		super();
		this.id_chefDivision = id_chefDivision;
		this.nom_chefDivision = nom_chefDivision;
		this.prenom_chefDivision = prenom_chefDivision;
		this.mail_chefDivision = mail_chefDivision;
		this.password_chefDivision = password_chefDivision;
		this.tel_chefDivision = tel_chefDivision;
	}

	public ChefDivision(int id_chefDivision, String nom_chefDivision, String prenom_chefDivision, String password_chefDivision,
			String mail_chefDivision, String tel_chefDivision, Etat etat_chefDivision) {
		super();
		this.id_chefDivision = id_chefDivision;
		this.nom_chefDivision = nom_chefDivision;
		this.prenom_chefDivision = prenom_chefDivision;
		this.mail_chefDivision = mail_chefDivision;
		this.password_chefDivision = password_chefDivision;
		this.tel_chefDivision = tel_chefDivision;
		this.etat_chefDivision = etat_chefDivision;
	}

	public int getId_chefDivision() {
		return id_chefDivision;
	}
	public void setId_chefDivision(int id_chefDivision) {
		this.id_chefDivision = id_chefDivision;
	}
	public String getNom_chefDivision() {
		return nom_chefDivision;
	}
	public void setNom_chefDivision(String nom_chefDivision) {
		this.nom_chefDivision = nom_chefDivision;
	}
	public String getPrenom_chefDivision() {
		return prenom_chefDivision;
	}
	public void setPrenom_chefDivision(String prenom_chefDivision) {
		this.prenom_chefDivision = prenom_chefDivision;
	}
	public String getMail_chefDivision() {
		return mail_chefDivision;
	}
	public void setMail_chefDivision(String mail_chefDivision) {
		this.mail_chefDivision = mail_chefDivision;
	}
	public String getPassword_chefDivision() {
		return password_chefDivision;
	}
	public void setPassword_chefDivision(String password_chefDivision) {
		this.password_chefDivision = password_chefDivision;
	}
	public String getTel_chefDivision() {
		return tel_chefDivision;
	}
	public void setTel_chefDivision(String tel_chefDivision) {
		this.tel_chefDivision = tel_chefDivision;
	}

	public Etat getEtat_chefDivision() {
		return etat_chefDivision;
	}

	public void setEtat_chefDivision(Etat etat_chefDivision) {
		this.etat_chefDivision = etat_chefDivision;
	}




}
