package employes;
import java.sql.Date;

public class Scientifique extends Collaborateur{
	private Double 		salaire;
	private Double 		prime;
	private boolean 	responsable;
	
	public Scientifique(){}
	
	public Scientifique(int numeroIdentification, 
			String nom, 
			String prenom, 
			String email,
			String telephone,
			int codeProjet,
			Date dateEmbauche, 
			String[] ville, 
			Double salaire, 
			Double prime, 
			boolean responsable, 
			boolean essaiClinique){
		
		super(numeroIdentification, nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);
		
		this.prime = prime;
		this.responsable = responsable;		
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Double getPrime() {
		return prime;
	}

	public void setPrime(Double prime) {
		this.prime = prime;
	}

	public boolean isResponsable() {
		return responsable;
	}

	public void setResponsable(boolean responsable) {
		this.responsable = responsable;
	}	
	
}
