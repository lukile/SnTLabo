package evenements;

import java.sql.Date;

public class Congres extends Evenement{
	private Date 	dateDebutCongres;
	private Date 	dateFinCongres;
	
	public Congres(Date dateEvenement, Date dateDebutCongres, Date dateFinCongres){

		super(dateEvenement);
		
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
