package backMetier;

public class Document {

	private int id_document;
	private String nom_document;
	private String description_document;
	private int id_demande;
	private Etat etat_document;
	/**
	 * 
	 */
	public Document() {
		super();
	}
	/**
	 * @param id_document
	 */
	public Document(int id_document) {
		super();
		this.id_document = id_document;
	}
	/**
	 * @param id_document
	 * @param nom_document
	 * @param description_processus
	 * @param id_demande
	 */
	public Document(int id_document, String nom_document, String description_document, int id_demande) {
		super();
		this.id_document = id_document;
		this.nom_document = nom_document;
		this.description_document = description_document;
		this.id_demande = id_demande;
	}
	
	
	/**
	 * @param id_document
	 * @param nom_document
	 * @param description_processus
	 * @param id_demande
	 * @param etat_document
	 */
	public Document(int id_document, String nom_document, String description_document, int id_demande,
			Etat etat_document) {
		super();
		this.id_document = id_document;
		this.nom_document = nom_document;
		this.description_document = description_document;
		this.id_demande = id_demande;
		this.etat_document = etat_document;
	}
	public int getId_document() {
		return id_document;
	}
	public void setId_document(int id_document) {
		this.id_document = id_document;
	}
	public String getNom_document() {
		return nom_document;
	}
	public void setNom_document(String nom_document) {
		this.nom_document = nom_document;
	}
	public String getDescription_document() {
		return description_document;
	}
	public void setDescription_document(String description_document) {
		this.description_document = description_document;
	}
	public int getId_demande() {
		return id_demande;
	}
	public void setId_demande(int id_demande) {
		this.id_demande = id_demande;
	}
	public Etat getEtat_document() {
		return etat_document;
	}
	public void setEtat_document(Etat etat_document) {
		this.etat_document = etat_document;
	}
	
	
}
