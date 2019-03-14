package eu.ensup.projetetudianttdd.metier;

public class Etudiant {
	
	private int id;
	private String nom;
	private String prenom;
	private String email;
	
	/**
	 * Constructeur par d�faut
	 */
	public Etudiant() {
		super();
	}

	/**
	 * Constructeur id, nom, prenom, email
	 * @param id
	 * @param nom
	 * @param prenom
	 * @param email
	 */
	public Etudiant(int id, String nom, String prenom, String email) {
		super();
		this.id = id;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	/** 
	 * Constructeur nom, prenom, email
	 * @param nom
	 * @param prenom
	 * @param email
	 */
	public Etudiant(String nom, String prenom, String email) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}

	
	@Override
	public String toString() {
		return "Etudiant [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
