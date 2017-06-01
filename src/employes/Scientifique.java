package employes;
import java.sql.Date;
import java.util.LinkedList;
import java.util.List;

public class Scientifique extends Collaborateur{
	public List<Scientifique> ListeScientifiques = new LinkedList<Scientifique>();

	private int 		id;
	private Double 		salaire;
	private Double 		prime;
	private boolean 	responsable;
	
	public Scientifique(
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
			boolean responsable, 
			boolean essaiClinique){
		
		super(numeroIdentification, nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);
		
		this.id = id;
		this.prime = prime;
		this.responsable = responsable;		
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

	public boolean isResponsable() {
		return responsable;
	}

	public void setResponsable(boolean responsable) {
		this.responsable = responsable;
	}

	@Override
	public String toString() {
		return "Scientifique : "
				+ super.toString()
				+ ", salaire =" + salaire 
				+ ", prime =" + prime 
				+ ", responsable =" + responsable;
	}	
}
