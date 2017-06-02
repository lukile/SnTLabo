package evenements;

import java.sql.Date;

public class Evenement {
	protected Date		dateEvenement;

	public Evenement(Date dateEvenement){
		
		this.dateEvenement = dateEvenement;
	}

	
	public Date getDateEvenement() {
		return dateEvenement;
	}

	public void setDateEvenement(Date dateEvenement) {
		this.dateEvenement = dateEvenement;
	}

	@Override
	public String toString() {
		return "Evenement : " 
				+ ", date de l'évènement = " + dateEvenement;
	}
	
}
