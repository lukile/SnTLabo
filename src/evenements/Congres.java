package evenements;

import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Congres extends Evenement{
	public List<Congres> ListeCongres = new LinkedList<Congres>();

	private int 	id;
	private Date 	dateDebutCongres;
	private Date 	dateFinCongres;
	
	public Congres(
			int id,
			int numeroIdentification,
			String nom,
			String prenom,
			String email, 
			String telephone,
			int codeProjet,
			Date dateEmbauche,
			String ville,
			Double salaire,
			Double prime,
			boolean essaiClinique,
			Date debutEssaiClinique,
			Date finEssaiClinique,
			String moleculeTestee,
			Date dateEvenement,
			Date dateDebutCongres,
			Date dateFinCongres){
		
		super(id, numeroIdentification, nom, prenom,
				email, telephone, codeProjet, dateEmbauche,
				ville, salaire, prime, essaiClinique, debutEssaiClinique,
				finEssaiClinique, moleculeTestee, dateEvenement);
		
		this.id = id;
		this.dateDebutCongres = dateDebutCongres;
		this.dateFinCongres = dateFinCongres;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
