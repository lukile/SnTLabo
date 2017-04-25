package evenements;

import java.sql.Date;

import employes.Medecin;

public class Evenement extends Medecin{
	private String 		moleculeTestee;

	public Evenement(){}
	
	public Evenement(int numeroIdentification, 
			String nom, 
			String prenom,
			String email,
			String telephone,
			int codeProjet,
			Date dateEmbauche,
			String[] ville,
			Double salaire,
			Double prime,
			boolean essaiClinique,
			Date debutEssaiClinique,
			Date finEssaiClinique,
			String moleculeTestee){
		
		super(numeroIdentification, nom, prenom,
				email, telephone, codeProjet,
				dateEmbauche, ville, salaire,
				prime, essaiClinique, debutEssaiClinique, finEssaiClinique);
		
		this.moleculeTestee = moleculeTestee;
	}

	public String getMoleculeTestee() {
		return moleculeTestee;
	}

	public void setMoleculeTestee(String moleculeTestee) {
		this.moleculeTestee = moleculeTestee;
	}
}
