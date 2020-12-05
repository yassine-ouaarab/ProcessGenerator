package backMetier;

public class Etape {


	private int id_etape;
	private String nom_etape;
	private String description_etape;
	private String rapport_etape;
	private int employe_etape;
	private int processus_etape;

	public Etape() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public Etape(int id_etape) {
		super();
		this.id_etape = id_etape;
	}



	public Etape(int id_etape, String nom_etape, String description_etape, String rapport_etape, int employe_etape,
			int processus_etape) {
		super();
		this.id_etape = id_etape;
		this.nom_etape = nom_etape;
		this.description_etape = description_etape;
		this.rapport_etape = rapport_etape;
		this.employe_etape = employe_etape;
		this.processus_etape = processus_etape;
	}


	public int getId_etape() {
		return id_etape;
	}
	
	public void setId_etape(int id_etape) {
		this.id_etape = id_etape;
	}

	public String getNom_etape() {
		return nom_etape;
	}

	public void setNom_etape(String nom_etape) {
		this.nom_etape = nom_etape;
	}

	public String getDescription_etape() {
		return description_etape;
	}

	public void setDescription_etape(String description_etape) {
		this.description_etape = description_etape;
	}

	public int getProcessus_etape() {
		return processus_etape;
	}

	public void setProcessus_etape(int processus_etape) {
		this.processus_etape = processus_etape;
	}

	public String getRapport_etape() {
		return rapport_etape;
	}

	public void setRapport_etape(String rapport_etape) {
		this.rapport_etape = rapport_etape;
	}

	public int getEmploye_etape() {
		return employe_etape;
	}

	public void setEmploye_etape(int employe_etape) {
		this.employe_etape = employe_etape;
	}


	
}
