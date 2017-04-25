package employes;

import java.sql.Date;

public class Commercial extends Collaborateur{
	private Double 		salaire;
	private Double 		noteDeFrais;
	private boolean 	remboursement;
	
	public Commercial(){}
	
	public Commercial(int numeroIdentification,
			String nom, 
			String prenom, 
			String email,
			String telephone,
			int codeProjet,
			Date dateEmbauche, 
			String[] ville, 
			Double salaire, 
			Double noteDeFrais, 
			boolean remboursement){
		
		super(numeroIdentification, nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);
		
		this.salaire = salaire;
		this.noteDeFrais = noteDeFrais;
		this.remboursement = remboursement;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
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
				+ ", salaire = " + salaire 
				+ ", note de frais=" + noteDeFrais 
				+ ", remboursement=" + remboursement;
	}
	
	
}
