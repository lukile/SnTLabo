package employes;

public class Collaborateur {
	
	protected int 		numeroIdentification;
	protected String 	nom;
	protected String 	prenom;
	protected String 	email;
	protected String 	telephone;
	protected int 		codeProjet;
	protected String 	dateEmbauche;
	protected String	ville;
	protected Double 	salaire;
	
	
	public Collaborateur(String nom,
						 String prenom,
						 String email,
						 String telephone,
						 int codeProjet,
						 String dateEmbauche,
						 String ville){
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.codeProjet = codeProjet;
		this.dateEmbauche = dateEmbauche;
		this.ville = ville;
	}

	public Double getComputedSalaire() {
		return this.salaire;
	}

	public int getNumeroIdentification() {

		return numeroIdentification;
	}

	public void setNumeroIdentification(int numeroIdentification) {

		this.numeroIdentification = numeroIdentification;
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

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public int getCodeProjet() {
		return codeProjet;
	}

	public void setCodeProjet(int codeProjet) {
		this.codeProjet = codeProjet;
	}

	public String getDateEmbauche()
	{
		return dateEmbauche;
	}

	public void setDateEmbauche(String dateEmbauche) {

		this.dateEmbauche = dateEmbauche;
	}

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	@Override
	public String toString() {
		return "Collaborateur{" +
				"numeroIdentification=" + numeroIdentification +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", email='" + email + '\'' +
				", telephone='" + telephone + '\'' +
				", codeProjet=" + codeProjet +
				", dateEmbauche='" + dateEmbauche + '\'' +
				", ville='" + ville + '\'' +
				'}';
	}
}
