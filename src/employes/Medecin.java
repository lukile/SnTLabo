package employes;

public class Medecin extends Collaborateur{

	private Double 				prime;
	private boolean 			essaiClinique;
	private String 				debutEssaiClinique;
	private String 				finEssaiClinique;

	public Medecin(
			String nom,
			String prenom,
			String email,
			String telephone,
			int codeProjet,
			String dateEmbauche,
			String ville,
			Double prime,
			boolean essaiClinique,
			String debutEssaiClinique,
			String finEssaiClinique){

		super(nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);

		this.prime = prime;
		this.essaiClinique = essaiClinique;
		this.debutEssaiClinique = debutEssaiClinique;
		this.finEssaiClinique = finEssaiClinique;
	}

	public Medecin(Collaborateur collaborateur,
				   Double prime,
				   boolean essaiClinique,
				   String debutEssaiClinique,
				   String finEssaiClinique){

		this(collaborateur.getNom(), collaborateur.getPrenom(), collaborateur.getEmail(),
				collaborateur.getTelephone(), collaborateur.getCodeProjet(), collaborateur.getDateEmbauche(),
				collaborateur.getVille(), prime, essaiClinique, debutEssaiClinique, finEssaiClinique);

		this.setNumeroIdentification(collaborateur.getNumeroIdentification());
	}

	public Double getPrime() {
		return prime;
	}

	public void setPrime(Double prime) {
		this.prime = prime;
	}

	public boolean isEssaiClinique() {
		return essaiClinique;
	}

	public void setEssaiClinique(boolean essaiClinique) {
		this.essaiClinique = essaiClinique;
	}

	public String getDebutEssaiClinique() {
		return debutEssaiClinique;
	}

	public void setDebutEssaiClinique(String debutEssaiClinique) {
		this.debutEssaiClinique = debutEssaiClinique;
	}

	public String getFinEssaiClinique() {
		return finEssaiClinique;
	}

	public void setFinEssaiClinique(String finEssaiClinique) {
		this.finEssaiClinique = finEssaiClinique;
	}

	@Override
	public String toString() {
		return "Medecin : "
				+ super.toString()
				+ ", salaire =" + salaire
				+ ", prime =" + prime
				+ ", essai Clinique =" + essaiClinique
				+ ", date du d�but Essai Clinique = " + debutEssaiClinique
				+ ", date de fin Essai Clinique =" + finEssaiClinique;
	}



}
