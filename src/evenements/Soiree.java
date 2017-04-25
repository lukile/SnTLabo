package evenements;

import java.sql.Date;
import java.sql.Time;

public class Soiree extends Evenement{
	private Time 	heureDebutSoiree;
	private Time	heureFinSoiree;
	
	public Soiree(){}
	
	public Soiree(int numeroIdentification,
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
			Time heureDebutSoiree,
			Time heureFinSoiree){
		
		super(numeroIdentification, nom, prenom,
				email, telephone, codeProjet, dateEmbauche,
				ville, salaire, prime, essaiClinique, 
				debutEssaiClinique, finEssaiClinique, moleculeTestee);
		
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
	
	
}
