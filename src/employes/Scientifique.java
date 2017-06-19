package employes;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Locale;

public class Scientifique extends Collaborateur{

	private Double 		prime;
	private boolean 	responsable;
	
	public Scientifique(
			String nom,
			String prenom, 
			String email,
			String telephone,
			int codeProjet,
			String dateEmbauche,
			String ville,
			Double prime,
			boolean responsable){
		
		super(nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);

		this.prime = prime;
		this.responsable = responsable;		
	}

	public Scientifique(Collaborateur collaborateur,
			Double prime,
			boolean responsable){

		this(collaborateur.getNom(), collaborateur.getPrenom(),
				collaborateur.getEmail(), collaborateur.getTelephone(),
				collaborateur.getCodeProjet(), collaborateur.getDateEmbauche(),
				collaborateur.getVille(), prime, responsable);

		this.setNumeroIdentification(collaborateur.getNumeroIdentification());
	}

	@Override
	public Double getComputedSalaire() {

		String dateEmbauche = getDateEmbauche();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = formatter.withLocale(Locale.FRANCE);
		LocalDate dateEmb = LocalDate.parse(dateEmbauche, formatter);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String current = dtf.format(now);
		LocalDate currentDate = LocalDate.parse(current, formatter);

		LocalDate date1 = dateEmb.plusYears(1);
		LocalDate date2 = dateEmb.plusYears(2);
		LocalDate date3 = dateEmb.plusYears(3);
		LocalDate date4 = dateEmb.plusYears(4);
		LocalDate date5 = dateEmb.plusYears(5);
		LocalDate date6 = dateEmb.plusYears(6);

		if(date6.compareTo(currentDate) <= 0){
			this.salaire = 10000.0;
		}else if(date4.compareTo(currentDate) < 0){
			this.salaire += 4000;
		}else if(date3.compareTo(currentDate) < 0){
			this.salaire += 3000;
		}else if(date2.compareTo(currentDate) < 0){
			this.salaire += 2000;
		}else if(date1.compareTo(currentDate) < 0){
			this.salaire += 1000;
		}else if(date5.compareTo(currentDate) < 0){
			this.salaire += 5000;
		}

		return salaire;
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
				+ ", salaire =" + getComputedSalaire()
				+ ", prime =" + prime 
				+ ", responsable =" + responsable;
	}	
}
