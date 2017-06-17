package evenements;

public class Evenement {
	protected  static int		id;
	protected String	adresse;
	protected String	moleculeTestee;

	public Evenement(int id, String adresse, String moleculeTestee){

		this.id = id;
		this.adresse = adresse;
		this.moleculeTestee = moleculeTestee;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	
	public String getMoleculeTestee() {
		return moleculeTestee;
	}

	public void setMoleculeTestee(String moleculeTestee) {
		this.moleculeTestee = moleculeTestee;
	}

	@Override
	public String toString() {
		return "Evenement : " 
				+ " lieu �v�nement = " + adresse
				+ ", mol�cule test�e = " + moleculeTestee;
	}
	
}
