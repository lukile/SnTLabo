package unite;

public class Unite{
	private String 		nomUnite;
	private String 		numeroRue;
	private String 		nomRue;
	private int 		codePostal;
	private String 		ville;
	
	public Unite(){}
	
	public Unite(
			String nomUnite, 
			String numeroRue, 
			String nomRue, 
			int codePostal, 
			String ville){
		
		this.nomUnite = nomUnite;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
	}

	public String getNomUnite() {
		return nomUnite;
	}

	public void setNomUnite(String nomUnite) {
		this.nomUnite = nomUnite;
	}

	public String getNumeroRue() {
		return numeroRue;
	}

	public void setNumeroRue(String numeroRue) {
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

	public String getville() {
		return ville;
	}

	public void setville(String ville) {
		this.ville = ville;
	}

	@Override
	public String toString() {
		return "Unite : "
				+ "nom de l'unité = " + nomUnite 
				+ ", numero de rue = " + numeroRue 
				+ ", nom de rue = " + nomRue + 
				", code postal = " + codePostal 
				+ ", ville = " + ville;
	}
	
}
