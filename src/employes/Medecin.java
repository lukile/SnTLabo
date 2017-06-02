package employes;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Medecin extends Collaborateur{
	public List<Medecin> ListeMedecins = new LinkedList<Medecin>();

	private Double 				salaire;
	private Double 				prime;
	private boolean 			essaiClinique;
	protected String 	 		moleculeTestee;
	private Date 				debutEssaiClinique;
	private Date 				finEssaiClinique;
	
	public Medecin(
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
			String moleculeTestee,
			Date debutEssaiClinique, 
			Date finEssaiClinique){
		
		super(numeroIdentification, nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);
		
		this.salaire = salaire;
		this.prime = prime;
		this.essaiClinique = essaiClinique;
		this.moleculeTestee = moleculeTestee;
		this.debutEssaiClinique = debutEssaiClinique;
		this.finEssaiClinique = finEssaiClinique;
	}

	public Double getSalaire() {
		return salaire;
	}

	public void setSalaire(Double salaire) {
		this.salaire = salaire;
	}

	public Double getPrime() {
		return prime;
	}

	public void setPrime(Double prime) {
		this.prime = prime;
	}

	public boolean isEssaiClinique() {
		return essaiClinique;
	}

	public void setEssaiClinique(boolean essaiClinique) {
		this.essaiClinique = essaiClinique;
	}

	public Date getDebutEssaiClinique() {
		return debutEssaiClinique;
	}

	public void setDebutEssaiClinique(Date debutEssaiClinique) {
		this.debutEssaiClinique = debutEssaiClinique;
	}

	public Date getFinEssaiClinique() {
		return finEssaiClinique;
	}

	public void setFinEssaiClinique(Date finEssaiClinique) {
		this.finEssaiClinique = finEssaiClinique;
	}
	
	public String getMoleculeTestee() {
		return moleculeTestee;
	}

	public void setMoleculeTestee(String moleculeTestee) {
		this.moleculeTestee = moleculeTestee;
	}

	@Override
	public String toString() {
		return "Medecin : "
				+ super.toString()
				+ ", salaire =" + salaire 
				+ ", prime =" + prime 
				+ ", essai Clinique =" + essaiClinique
				+ ", mol�cule test�e = " + moleculeTestee
				+ ", date du d�but Essai Clinique = " + debutEssaiClinique 
				+ ", date de fin Essai Clinique =" + finEssaiClinique;
	}
	
	
	
}
