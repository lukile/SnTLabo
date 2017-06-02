package employes;
import java.sql.Date;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Collaborateur {
	protected int 		numeroIdentification;
	protected String 	nom;
	protected String 	prenom;
	protected String 	email;
	protected String 	telephone;
	protected int 		codeProjet;
	protected Date 		dateEmbauche;
	protected List		ville = new LinkedList<String>();
	
	public Collaborateur(int numeroIdentification, String nom, String prenom, String email, String telephone, int codeProjet, Date dateEmbauche, List ville){
		ville.add("Strasbourg");
		ville.add("Grenoble");
		ville.add("Rennes");
		ville.add("Marseille");
		ville.add("Bordeaux");
		ville.add("Toulouse");
		this.numeroIdentification = numeroIdentification;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.codeProjet = codeProjet;
		this.dateEmbauche = dateEmbauche;
		this.ville = ville;
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

	public Date getDateEmbauche() {
		return dateEmbauche;
	}

	public void setDateEmbauche(Date dateEmbauche) {
		this.dateEmbauche = dateEmbauche;
	}

	public List<String> getVille() {
		return ville;
	}

	public void setVille(List ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Collaborateur : "
				+ " numero d'identification = " + numeroIdentification 
				+ ", nom = " + nom + 
				", prenom = " + prenom
				+ ", email = " + email + 
				", telephone = " + telephone + 
				", codeProjet = " + codeProjet 
				+ ", dateEmbauche = " + dateEmbauche 
				+ ", ville = " + ville.toString();
	}
}
