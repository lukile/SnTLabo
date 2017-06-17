package employes;

public class Scientifique extends Collaborateur{

	private Double 		salaire;
	private Double 		prime;
	private boolean 	responsable;
	
	public Scientifique(
			String nom,
			String prenom, 
			String email,
			String telephone,
			int codeProjet,
			String dateEmbauche,
			String ville,
			Double salaire,
			Double prime,
			boolean responsable){
		
		super(nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);

		this.salaire = salaire;
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

	@Override
	public String toString() {
		return "Scientifique : "
				+ super.toString()
				+ ", salaire =" + salaire 
				+ ", prime =" + prime 
				+ ", responsable =" + responsable;
	}	
}
