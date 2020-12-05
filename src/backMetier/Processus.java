package backMetier;

public class Processus {

	private int id_processus;
	private String nom_processus;
	private String description_processus;
	private Etat etat_processus;
	private int id_chefDivision;
	public Processus() {
		// TODO Auto-generated constructor stub
		super();
	}
	public Processus(int id_processus) {
	super();
		this.id_processus = id_processus;
	}
	public Processus(int id_processus, String nom_processus, String description_processus,int chefDivision) {
		super();
		this.id_processus = id_processus;
		this.nom_processus = nom_processus;
		this.description_processus = description_processus;
		this.id_chefDivision = chefDivision;
	}
	public Processus(int id_processus, String nom_processus, String description_processus,
			Etat etat_processus, int chefDivision) {
		super();
		this.id_processus = id_processus;
		this.nom_processus = nom_processus;
		this.description_processus = description_processus;
		this.etat_processus = etat_processus;
		this.id_chefDivision = chefDivision;
	}
	public Processus(int id_processus, String nom_processus,
			Etat etat_processus, int chefDivision) {
		super();
		this.id_processus = id_processus;
		this.nom_processus = nom_processus;
		this.etat_processus = etat_processus;
		this.id_chefDivision = chefDivision;
	}
	public Processus(String nom_processus,
			Etat etat_processus, int chefDivision) {
		super();
		this.nom_processus = nom_processus;
		this.etat_processus = etat_processus;
		this.id_chefDivision = chefDivision;
	}
	public Processus(String nom_processus, int chefDivision) {
		super();
		this.nom_processus = nom_processus;
		this.id_chefDivision = chefDivision;
	}
	public Processus(String nom_processus,
			Etat etat_processus) {
		super();
		this.nom_processus = nom_processus;
		this.etat_processus = etat_processus;
	}
	public int getId_processus() {
		return id_processus;
	}
	public void setId_processus(int id_processus) {
		this.id_processus = id_processus;
	}
	public String getNom_processus() {
		return nom_processus;
	}
	public void setNom_processus(String nom_processus) {
		this.nom_processus = nom_processus;
	}
	public String getDescription_processus() {
		return description_processus;
	}
	public void setDescription_processus(String description_processus) {
		this.description_processus = description_processus;
	}
	public Etat getEtat_processus() {
		return etat_processus;
	}
	public void setEtat_processus(Etat etat_processus) {
		this.etat_processus = etat_processus;
	}
	public int getId_chefDivision() {
		return id_chefDivision;
	}
	public void setId_chefDivision(int id_chefDivision) {
		this.id_chefDivision = id_chefDivision;
	}

}
