package evenements;

import java.sql.Date;
import java.sql.Time;

public class Soiree extends Evenement{
	private Date 	dateSoiree;
	private Time 	heureDebutSoiree;
	private Time	heureFinSoiree;

	public Soiree(String adresse, String moleculeTestee, Date dateSoiree, Time heureDebutSoiree, Time heureFinSoiree){
		super(id, adresse, moleculeTestee);
	
		this.dateSoiree = dateSoiree;
		this.heureDebutSoiree = heureDebutSoiree;
		this.heureFinSoiree = heureFinSoiree;
	}
	
	public Date getDateSoiree() {
		return dateSoiree;
	}


	public void setDateSoiree(Date dateSoiree) {
		this.dateSoiree = dateSoiree;
	}


	public Time getHeureDebutSoiree() {
		return heureDebutSoiree;
	}

	public void setHeureDebutSoiree(Time heureDebutSoiree) {
		this.heureDebutSoiree = heureDebutSoiree;
	}

	public Time getHeureFinSoiree() {
		return heureFinSoiree;
	}

	public void setHeureFinSoiree(Time heureFinSoiree) {
		this.heureFinSoiree = heureFinSoiree;
	}

	@Override
	public String toString() {
		return "Soiree : "
				+ super.toString()
				+ ", heure de d�but de soiree = " + heureDebutSoiree 
				+ ", heure de fin de soiree = " + heureFinSoiree;
	}
	
	
}
