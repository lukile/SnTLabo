package evenements;

import java.sql.Date;
import java.sql.Time;

public class Soiree extends Evenement{
	private int 	id;
	private Time 	heureDebutSoiree;
	private Time	heureFinSoiree;
	
	public Soiree(){}
	
	public Soiree(
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
			Date dateEvenement,
			Time heureDebutSoiree,
			Time heureFinSoiree){
		
		super(id, numeroIdentification, nom, prenom,
				email, telephone, codeProjet, dateEmbauche,
				ville, salaire, prime, essaiClinique, 
				debutEssaiClinique, finEssaiClinique, moleculeTestee, dateEvenement);
		
		this.id = id;
		this.heureDebutSoiree = heureDebutSoiree;
		this.heureFinSoiree = heureFinSoiree;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
