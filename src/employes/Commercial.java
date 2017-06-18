package employes;

public class Commercial extends Collaborateur{

	private Double 		noteDeFrais;
	private boolean 	remboursement;

	public Commercial(
			String nom,
			String prenom,
			String email,
			String telephone,
			int codeProjet,
			String dateEmbauche,
			String ville,
			Double noteDeFrais,
			boolean remboursement){

		super(nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);

		this.noteDeFrais = noteDeFrais;
		this.remboursement = remboursement;
	}
		
	public Commercial(Collaborateur collaborateur,
			Double noteDeFrais,
			boolean remboursement){
		
		this(collaborateur.getNom(), collaborateur.getPrenom(),
				collaborateur.getEmail(), collaborateur.getTelephone(),
				collaborateur.getCodeProjet(), collaborateur.getDateEmbauche(),
				collaborateur.getVille(), noteDeFrais, remboursement);

		this.setNumeroIdentification(collaborateur.getNumeroIdentification());
	}

	@Override
	public Double getComputedSalaire() {
		return this.salaire + 1000;
	}

	public Double getNoteDeFrais() {
		return noteDeFrais;
	}

	public void setNoteDeFrais(Double noteDeFrais) {
		this.noteDeFrais = noteDeFrais;
	}

	public boolean isRemboursement() {
		return remboursement;
	}

	public void setRemboursement(boolean remboursement) {
		this.remboursement = remboursement;
	}

	@Override
	public String toString() {
		return "Commercial : "
				+ super.toString()
				+ ", salaire = " + getComputedSalaire()
				+ ", note de frais=" + noteDeFrais 
				+ ", remboursement=" + remboursement;
	}
	
	
}
