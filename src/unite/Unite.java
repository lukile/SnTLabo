package unite;

public class Unite{
	private String 		nomUnite;
	private int 		numeroRue;
	private String 		nomRue;
	private int 		codePostal;
	private String 		region;
	
	public Unite(){}
	
	public Unite(String nomUnite, 
			int numeroRue, 
			String nomRue, 
			int codePostal, 
			String region){
		
		this.nomUnite = nomUnite;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.region = region;
	}

	public String getNomUnite() {
		return nomUnite;
	}

	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}

	public int getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(int numeroRue) {
		this.numeroRue = numeroRue;
	}

	public String getNomRue() {
		return nomRue;
	}

	public void setNomRue(String nomRue) {
		this.nomRue = nomRue;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	@Override
	public String toString() {
		return "Unite : "
				+ "nom de l'unité = " + nomUnite 
				+ ", numero de rue = " + numeroRue 
				+ ", nom de rue = " + nomRue + 
				", code postal = " + codePostal 
				+ ", region = " + region;
	}
	
}
