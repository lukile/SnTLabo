package employes;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Scanner;

public class Commercial extends Collaborateur{

	private Double 		noteDeFrais;
	private boolean 	remboursement;

	public Commercial(
			String nom,
			String prenom,
			String email,
			String telephone,
			int codeProjet,
			String dateEmbauche,
			String ville,
			Double noteDeFrais,
			boolean remboursement){

		super(nom, prenom, email, telephone, codeProjet, dateEmbauche, ville);

		this.noteDeFrais = noteDeFrais;
		this.remboursement = remboursement;
	}
		
	public Commercial(Collaborateur collaborateur,
			Double noteDeFrais,
			boolean remboursement){
		
		this(collaborateur.getNom(), collaborateur.getPrenom(),
				collaborateur.getEmail(), collaborateur.getTelephone(),
				collaborateur.getCodeProjet(), collaborateur.getDateEmbauche(),
				collaborateur.getVille(), noteDeFrais, remboursement);

		this.setNumeroIdentification(collaborateur.getNumeroIdentification());
	}

	@Override
	public Double getComputedSalaire() {

		Scanner scanner = new Scanner(System.in);

		System.out.println("Budget total alloué pour une soirée/congrès pour ce collaborateur :");
		Double budget = scanner.nextDouble();

		String dateEmbauche = getDateEmbauche();

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		formatter = formatter.withLocale(Locale.FRANCE);
		LocalDate dateEmb = LocalDate.parse(dateEmbauche, formatter);

		System.out.println(dateEmb);

		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDateTime now = LocalDateTime.now();
		String current = dtf.format(now);
		LocalDate currentDate = LocalDate.parse(current, formatter);

		System.out.println(currentDate);

		LocalDate date1 = dateEmb.plusYears(1);
		LocalDate date2 = dateEmb.plusYears(2);
		LocalDate date3 = dateEmb.plusYears(3);
		LocalDate date4 = dateEmb.plusYears(4);
		LocalDate date5 = dateEmb.plusYears(5);
		LocalDate date6 = dateEmb.plusYears(6);
		LocalDate date7 = dateEmb.plusYears(7);
		LocalDate date8 = dateEmb.plusYears(8);
		LocalDate date9 = dateEmb.plusYears(9);
		LocalDate date10 = dateEmb.plusYears(10);

		if(date10.compareTo(currentDate) < 0){
			this.salaire += (budget * 5.5) / 100;
		}else if(date9.compareTo(currentDate) < 0){
			this.salaire += (budget * 5) / 100;
		}else if(date8.compareTo(currentDate) < 0){
			this.salaire += (budget * 4.5) / 100;
		}else if(date7.compareTo(currentDate) < 0){
			this.salaire += (budget * 4) / 100;
		}else if(date6.compareTo(currentDate) < 0){
			this.salaire += (budget * 3.5) / 100;
		}else if(date5.compareTo(currentDate) < 0){
			this.salaire += (budget * 3) / 100;
		}else if(date4.compareTo(currentDate) < 0){
			this.salaire += (budget * 2.5) / 100;
		}else if(date3.compareTo(currentDate) < 0){
			this.salaire += (budget * 2) /100;
		}else if(date2.compareTo(currentDate) < 0){
			this.salaire += (budget * 1) / 100;
		}else if(date1.compareTo(currentDate) < 0){
			this.salaire += (budget * 0.5) / 100;
		}
		return salaire;
	}

	public Double getNoteDeFrais() {
		return noteDeFrais;
	}

	public void setNoteDeFrais(Double noteDeFrais) {
		this.noteDeFrais = noteDeFrais;
	}

	public boolean isRemboursement() {
		return remboursement;
	}

	public void setRemboursement(boolean remboursement) {
		this.remboursement = remboursement;
	}

	@Override
	public String toString() {
		return "Commercial : "
				+ super.toString()
				+ ", salaire = " + getComputedSalaire()
				+ ", note de frais=" + noteDeFrais 
				+ ", remboursement=" + remboursement;
	}
	
	
}
