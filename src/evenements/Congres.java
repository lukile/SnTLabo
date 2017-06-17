package evenements;

import java.sql.Date;

public class Congres extends Evenement{
	private String 	dateDebutCongres;
	private String 	dateFinCongres;
	
	public Congres(String adresse, String moleculeTestee, String dateDebutCongres, String dateFinCongres){

		super (id, adresse, moleculeTestee);

		this.dateDebutCongres = dateDebutCongres;
		this.dateFinCongres = dateFinCongres;
	}
	
	public String getDateDebutCongres() {
		return dateDebutCongres;
	}

	public void setDateDebutCongres(String dateDebutCongres) {
		this.dateDebutCongres = dateDebutCongres;
	}

	public String getDateFinCongres() {
		return dateFinCongres;
	}

	public void setDateFinCongres(String dateFinCongres) {
		this.dateFinCongres = dateFinCongres;
	}

	@Override
	public String toString() {
		return "Congres : "
				+ super.toString()
				+ ", date du d�but de congr�s = " + dateDebutCongres 
				+ ", date de fin de congr�s = " + dateFinCongres;
	}
	
}
