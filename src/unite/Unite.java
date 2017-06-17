package unite;

public class Unite{
	
	private String 		nomUnite;
	private String 		numeroRue;
	private String 		nomRue;
	private int 		codePostal;
	private String 		ville;
	private String 		dateResponsabilite;
	
	public Unite(
			String nomUnite, 
			String numeroRue, 
			String nomRue, 
			int codePostal, 
			String ville,
			String dateResponsabilite){
		
		this.nomUnite = nomUnite;
		this.numeroRue = numeroRue;
		this.nomRue = nomRue;
		this.codePostal = codePostal;
		this.ville = ville;
		this.dateResponsabilite = dateResponsabilite;
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

	public String getVille() {
		return ville;
	}

	public void setVille(String ville) {
		this.ville = ville;
	}

	public String getDateResponsabilite() {
		return dateResponsabilite;
	}

	public void setDateResponsabilite(String dateResponsabilite) {
		this.dateResponsabilite = dateResponsabilite;
	}

	@Override
	public String toString() {
		return "Unite : "
				+ "nom de l'unit� = " + nomUnite 
				+ ", numero de rue = " + numeroRue 
				+ ", nom de rue = " + nomRue + 
				", code postal = " + codePostal 
				+ ", ville = " + ville
				+ ", date responsabilités = " + dateResponsabilite;
	}
	
}
