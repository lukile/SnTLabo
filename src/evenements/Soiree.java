package evenements;

import java.sql.Date;
import java.sql.Time;

public class Soiree extends Evenement{
	private String 	dateSoiree;
	private String 	heureDebutSoiree;
	private String	heureFinSoiree;

	public Soiree(String adresse, String moleculeTestee, String dateSoiree, String heureDebutSoiree, String heureFinSoiree){
		super(id, adresse, moleculeTestee);
	
		this.dateSoiree = dateSoiree;
		this.heureDebutSoiree = heureDebutSoiree;
		this.heureFinSoiree = heureFinSoiree;
	}
	
	public String getDateSoiree() {
		return dateSoiree;
	}


	public void setDateSoiree(String dateSoiree) {
		this.dateSoiree = dateSoiree;
	}


	public String getHeureDebutSoiree() {
		return heureDebutSoiree;
	}

	public void setHeureDebutSoiree(String heureDebutSoiree) {
		this.heureDebutSoiree = heureDebutSoiree;
	}

	public String getHeureFinSoiree() {
		return heureFinSoiree;
	}

	public void setHeureFinSoiree(String heureFinSoiree) {
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
