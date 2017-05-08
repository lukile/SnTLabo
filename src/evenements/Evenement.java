package evenements;

import java.sql.Date;

import employes.Medecin;

public class Evenement extends Medecin{
	protected int 		id;
	protected String 	moleculeTestee;
	protected Date		dateEvenement;

	public Evenement(){}
	
	public Evenement(
			int id,
			int numeroIdentification, 
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
			String moleculeTestee,
			Date dateEvenement){
		
		super(id, numeroIdentification, nom, prenom,
				email, telephone, codeProjet,
				dateEmbauche, ville, salaire,
				prime, essaiClinique, debutEssaiClinique, finEssaiClinique);
		
		this.moleculeTestee = moleculeTestee;
		this.dateEvenement = dateEvenement;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMoleculeTestee() {
		return moleculeTestee;
	}

	public void setMoleculeTestee(String moleculeTestee) {
		this.moleculeTestee = moleculeTestee;
	}

	public Date getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	@Override
	public String toString() {
		return "Evenement : Médecin affecté -> " 
				+ super.toString() 
				+ ", moleculeTestee = " + moleculeTestee
				+ ", date de l'évènement = " + dateEvenement;
	}
	
}
