package employes;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Medecin extends Collaborateur{
	public List<Medecin> ListeMedecins = new LinkedList<Medecin>();

	protected int 		id;
	private Double 				salaire;
	private Double 				prime;
	private boolean 			essaiClinique;
	private Date 				debutEssaiClinique;
	private Date 				finEssaiClinique;
		
	public Medecin(
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
			Date finEssaiClinique){
		
		super(numeroIdentification, nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);
		
		this.id = id;
		this.salaire = salaire;
		this.prime = prime;
		this.essaiClinique = essaiClinique;
		this.debutEssaiClinique = debutEssaiClinique;
		this.finEssaiClinique = finEssaiClinique;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "Medecin : "
				+ super.toString()
				+ ", salaire =" + salaire + 
				", prime =" + prime + 
				", essai Clinique =" + essaiClinique
				+ ", date du début Essai Clinique = " + debutEssaiClinique 
				+ ", date de fin Essai Clinique =" + finEssaiClinique;
	}
	
	
	
}
