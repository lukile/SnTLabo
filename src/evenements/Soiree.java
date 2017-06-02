package evenements;

import java.sql.Date;
import java.sql.Time;
import java.util.LinkedList;
import java.util.List;

public class Soiree extends Evenement{
	private Time 	heureDebutSoiree;
	private Time	heureFinSoiree;
	
	public Soiree(Date dateEvenement, Time heureDebutSoiree, Time heureFinSoiree){
		super(dateEvenement);
		List<Soiree> ListeSoirees = new LinkedList<Soiree>();
	
		this.heureDebutSoiree = heureDebutSoiree;
		this.heureFinSoiree = heureFinSoiree;
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
				+ ", heure de début de soiree = " + heureDebutSoiree 
				+ ", heure de fin de soiree = " + heureFinSoiree;
	}
	
	
}
