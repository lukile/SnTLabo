package evenements;

public class Evenement {
	protected String	adresse;
	protected String	moleculeTestee;

	public Evenement(String adresse, String moleculeTestee){

		this.adresse = adresse;
		this.moleculeTestee = moleculeTestee;
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
				+ " lieu événement = " + adresse
				+ ", molécule testée = " + moleculeTestee;
	}
	
}
