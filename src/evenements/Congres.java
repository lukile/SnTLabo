package evenements;

import java.sql.Date;

public class Congres extends Evenement{
	private Date 	dateDebutCongres;
	private Date 	dateFinCongres;
	
	public Congres(){}
	
	public Congres(int numeroIdentification,
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
			Date dateEvenement,
			Date dateDebutCongres,
			Date dateFinCongres){
		
		super(numeroIdentification, nom, prenom,
				email, telephone, codeProjet, dateEmbauche,
				ville, salaire, prime, essaiClinique, debutEssaiClinique,
				finEssaiClinique, moleculeTestee, dateEvenement);
		
		this.dateDebutCongres = dateDebutCongres;
		this.dateFinCongres = dateFinCongres;
	}

	public Date getDateDebutCongres() {
		return dateDebutCongres;
	}

	public void setDateDebutCongres(Date dateDebutCongres) {
		this.dateDebutCongres = dateDebutCongres;
	}

	public Date getDateFinCongres() {
		return dateFinCongres;
	}

	public void setDateFinCongres(Date dateFinCongres) {
		this.dateFinCongres = dateFinCongres;
	}

	@Override
	public String toString() {
		return "Congres : "
				+ super.toString()
				+ ", date du début de congrès = " + dateDebutCongres 
				+ ", date de fin de congrès = " + dateFinCongres;
	}
	
}
