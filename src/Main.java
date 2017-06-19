import databaseConnection.DatabaseConnection;
import employes.Collaborateur;
import employes.Commercial;
import employes.Medecin;
import employes.Scientifique;
import evenements.Congres;
import evenements.Evenement;
import evenements.Soiree;
import unite.Unite;

import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        System.out.println("Que souhaitez vous effectuer comme action : \n" +
                "1 - Enregistrer un collaborateur,\n" +
                "2 - Modifier un collaborateur,\n" +
                "3 - Supprimer un collaborateur,\n" +
                "4 - Afficher les coordonnées d'un collaborateur,\n" +
                "5 - Calculer le salaire par catégorie de collaborateur,\n" +
                "6 - Lister les collaborateurs par catégorie et par région,\n" +
                "7 - Quitter le programme\n\n" +
                "C'est à vous !");

        int response = scanner.nextInt();

        DatabaseConnection dbConnection = new DatabaseConnection();

        switch(response){
            case 1:
                System.out.println("Voulez vous enregistrer :\n" +
                                    "1 - Un médecin\n" +
                                    "2 - Un scientifique\n" +
                                    "3 - Un commercial?\n");

                int choice = scanner.nextInt();

                System.out.println("Nom : ");
                scanner.nextLine();
                String nom = scanner.nextLine();

                System.out.println("Prenom : ");
                String prenom = scanner.nextLine();

                System.out.println("Email : ");
                String email = scanner.nextLine();

                System.out.println("Telephone : ");
                String telephone = scanner.nextLine();

                System.out.println("Code projet : ");
                int codeProjet = scanner.nextInt();

                System.out.println("Date d'embauche : ");
                scanner.nextLine();
                String dateEmbauche = scanner.nextLine();

                System.out.println("Ville : ");
                String ville = scanner.nextLine();

                if(choice == 1){
                    System.out.println("Salaire :");
                    Double salaire = scanner.nextDouble();

                    System.out.println("Prime : ");
                    Double prime = scanner.nextDouble();

                    System.out.println("Participe t il a un essai clinique?O/N");
                    scanner.nextLine();
                    String yesOrNot = scanner.nextLine();

                    boolean essaiClinique = false;
                    String debutEssaiClinque = null;
                    String finEssaiClinque = null;

                    if(yesOrNot.equals("O")){
                        essaiClinique = true;
                        if (essaiClinique) {
                            System.out.println("Indiquez la date du début de l'essai clinique");
                            debutEssaiClinque = scanner.nextLine();

                            System.out.println("Et la date de fin :");
                            finEssaiClinque = scanner.nextLine();
                        }
                    }else{
                        essaiClinique = false;
                    }

                    Collaborateur collaborateur = new Medecin(
                            nom, prenom, email, telephone,
                            codeProjet, dateEmbauche, ville,
                            prime, essaiClinique, debutEssaiClinque, finEssaiClinque
                    );
                    collaborateur.setSalaire(salaire);
                    dbConnection.insert(collaborateur);

                    System.out.println("Le médecin partitipe t il a un congrès?O/N");
                    String yesOrNotC = scanner.nextLine();

                    if(yesOrNotC.equals("O")){

                        System.out.println("Adresse de l'evènement :");
                        String adresse = scanner.nextLine();

                        System.out.println("Nom de la molécule testée :");
                        String moleculeTestee = scanner.nextLine();

                        System.out.println("Date de début du congrès");
                        String dateDebutCongres = scanner.nextLine();

                        System.out.println("Date de fin de congrès");
                        String dateFinCongres = scanner.nextLine();

                                Evenement evenement = new Congres(adresse, moleculeTestee,
                                dateDebutCongres, dateFinCongres);

                        dbConnection.insert(evenement);

                        dbConnection.insertMedecinEvenement(collaborateur, evenement);
                    }

                }else if(choice == 2){
                    System.out.println("Salaire : ");
                    Double salaire = scanner.nextDouble();

                    if(salaire < 4000.0 || salaire > 5000.0)
                        System.out.println("Le salaire d'un scientifique ne peut pas être inférieur a 4000€ ni supérieur à 5000€");
                    else {

                        System.out.println("Prime : ");
                        Double prime = scanner.nextDouble();


                        System.out.println("Le Scientifique est il responsable d'une unité?O/N");
                        scanner.nextLine();
                        String yesOrNot = scanner.nextLine();

                        boolean responsable = false;

                        if (yesOrNot.equals("O")) {
                            responsable = true;
                        } else {
                            responsable = false;
                        }

                        Collaborateur collaborateur = new Scientifique(
                                nom, prenom, email, telephone,
                                codeProjet, dateEmbauche, ville,
                                prime, responsable
                        );
                        collaborateur.setSalaire(salaire);
                        dbConnection.insert(collaborateur);


                        System.out.println("Le scientifique est il affecté à une unité?O/N");
                        String yesOrNotU = scanner.nextLine();

                        if (yesOrNotU.equals("O")) {
                            System.out.println("Renseignez le nom de l'unité :");
                            String nomUnite = scanner.nextLine();

                            System.out.println("N° de rue :");
                            String numRue = scanner.nextLine();

                            System.out.println("Nom de la rue :");
                            String nomRue = scanner.nextLine();

                            System.out.println("Code Postal :");
                            int cp = scanner.nextInt();

                            System.out.println("Ville :");
                            scanner.nextLine();
                            String villeU = scanner.nextLine();

                            System.out.println("Date de la prise de la prise de responsabilité du scientifique (0 si le scientifique n'est pas responsable de l'unité):");
                            String dateResponsabiliteSC = scanner.nextLine();

                            Unite unite = new Unite(
                                    nomUnite, numRue, nomRue, cp,
                                    villeU, dateResponsabiliteSC
                            );
                            dbConnection.insert(unite);
                            dbConnection.insertScUnite(collaborateur, unite);
                        }
                    }

                }else if(choice == 3){
                    System.out.println("Salaire :");
                    Double salaire = scanner.nextDouble();

                    System.out.println("Note de frais (0 si le commercial n'a pas participé à une soirée) :");
                    Double noteDeFrais = scanner.nextDouble();

                    boolean remboursement = false;

                    if(!noteDeFrais.equals(0.0)) {
                        System.out.println("Le remboursement a t il été effectué?O/N");
                        scanner.nextLine();
                        String yesOrNot = scanner.nextLine();

                        if (yesOrNot.equals("O")) {
                            remboursement = true;
                        } else {
                            remboursement = false;
                        }
                    }else{
                        remboursement = false;
                    }
                    Collaborateur collaborateur = new Commercial(
                            nom, prenom, email, telephone,
                            codeProjet, dateEmbauche, ville,
                            noteDeFrais, remboursement
                    );

                    collaborateur.setSalaire(salaire);
                    dbConnection.insert(collaborateur);

                    if(!noteDeFrais.equals(0.0)){
                        System.out.println("Le commercial participe t il a une soirée?O/N");
                        String yesOrNotCom = scanner.nextLine();

                        if(yesOrNotCom.equals("O")) {

                            System.out.println("Adresse de l'evènement :");
                            String adresse = scanner.nextLine();

                            System.out.println("Nom de la molécule testée :");
                            String moleculeTestee = scanner.nextLine();

                            System.out.println("Indiquez la date de la soirée : ");
                            String dateSoiree = scanner.nextLine();

                            System.out.println("Heure de début de soirée");
                            String debutSoiree = scanner.nextLine();

                            System.out.println("Heure de fin de soirée");
                            String finSoiree = scanner.nextLine();

                            Evenement evenement = new Soiree(adresse, moleculeTestee, dateSoiree,
                                    debutSoiree, finSoiree);

                            dbConnection.insert(evenement);

                            dbConnection.insertCommercialEvenement(collaborateur, evenement);
                        }

                    }
                }
                break;

            case 2:
                System.out.println("Quel collaborateur souhaitez vous modifier?:\n" +
                        "1 - Un médecin\n" +
                        "2 - Un scientifique\n" +
                        "3 - Un commercial\n");

                int choiceUpdate = scanner.nextInt();

                System.out.println("Saisissez le numero d'identification du collaborateur à modifier :");
                int nIdentification = scanner.nextInt();

                System.out.println("Nouveau nom :");
                scanner.nextLine();
                String newName = scanner.nextLine();

                System.out.println("Nouveau prénom :");
                String newSurname = scanner.nextLine();

                System.out.println("Nouvel email :");
                String newMail = scanner.nextLine();

                System.out.println("Nouveau numero de téléphone :");
                String newPhone = scanner.nextLine();

                System.out.println("Nouveau code projet :");
                int newCodeProjet = scanner.nextInt();

                System.out.println("Correction de la date d'embauche :");
                scanner.nextLine();
                String newDate = scanner.nextLine();

                System.out.println("Nouvelle ville : ");
                String newVille = scanner.nextLine();

                if(choiceUpdate == 1){
                    System.out.println("Nouveau salaire : ");
                    Double newSalaire = scanner.nextDouble();

                    System.out.println("Nouvelle prime : ");
                    Double newPrime = scanner.nextDouble();

                    System.out.println("Participe t il a un essai clinique ?O/N");
                    scanner.nextLine();
                    String yesOrNot = scanner.nextLine();

                    boolean newEssaiClinique = false;
                    String newDebutEssai = null;
                    String newFinEssai = null;

                    if(yesOrNot.equals("O")){
                        newEssaiClinique = true;
                        if(newEssaiClinique){
                            System.out.println("Nouvelle date essai clinique :");
                            newDebutEssai = scanner.nextLine();

                            System.out.println("Nouvelle date fin essai clinique :");
                            newFinEssai = scanner.nextLine();
                        }
                    }else{
                        newEssaiClinique = false;
                    }

                    Collaborateur collaborateur = new Medecin(
                            newName, newSurname, newMail, newPhone, newCodeProjet,
                            newDate, newVille, newPrime,
                            newEssaiClinique, newDebutEssai, newFinEssai
                    );

                    collaborateur.setNumeroIdentification(nIdentification);
                    collaborateur.setSalaire(newSalaire);
                    dbConnection.update(collaborateur);

                }else if(choiceUpdate == 2){
                    System.out.println("Nouveau salaire : ");
                    Double newSalaire = scanner.nextDouble();

                    System.out.println("Nouvelle prime : ");
                    Double newPrime = scanner.nextDouble();

                    System.out.println("Le scientifique est il responsable d'une unite ?O/N");
                    scanner.nextLine();
                    String yesOrNot = scanner.nextLine();

                    boolean responsable = false;

                    if (yesOrNot.equals("O")){
                        responsable = true;
                    }else{
                        responsable = false;
                    }

                    Collaborateur collaborateur = new Scientifique(
                            newName, newSurname, newMail, newPhone,
                            newCodeProjet, newDate, newVille,
                            newPrime, responsable
                    );

                    collaborateur.setNumeroIdentification(nIdentification);
                    collaborateur.setSalaire(newSalaire);

                    dbConnection.update(collaborateur);

                }else if(choiceUpdate == 3){
                    System.out.println("Nouveau salaire : ");
                    Double newSalaire = scanner.nextDouble();

                    System.out.println("Nouvelle note de frais (0 si le commercial ne participe pas a une soirée) :");
                    Double newNoteFrais = scanner.nextDouble();

                    boolean remboursement = false;

                    if(!newNoteFrais.equals(0.0)){
                        System.out.println("Le remboursement a t il déjà ete effectué?O/N");
                        scanner.nextLine();
                        String yesOrNot = scanner.nextLine();

                        if(yesOrNot.equals("O")){
                            remboursement = true;
                        }else{
                            remboursement = false;
                        }
                    }else{
                        remboursement = false;
                    }
                    Collaborateur collaborateur = new Commercial(
                            newName, newSurname, newMail, newPhone,
                            newCodeProjet, newDate, newVille,
                            newNoteFrais, remboursement
                    );

                    collaborateur.setNumeroIdentification(nIdentification);
                    collaborateur.setSalaire(newSalaire);
                    dbConnection.update(collaborateur);

                }
                break;

            case 3:
                System.out.println("Quel collaborateur voulez vous supprimer?\n" +
                        "1 - Un médecin\n" +
                        "2 - Un scientifique\n" +
                        "3 - Un commercial");

                int choiceDelete = scanner.nextInt();


                if (choiceDelete == 1) {
                    System.out.println("Veuillez saisir le numero d'identification du collaborateur à supprimer");
                    int numeroIdentification = scanner.nextInt();

                    dbConnection.deleteMedecinEvenement(numeroIdentification);
                    dbConnection.deleteMedecin(numeroIdentification);
                    dbConnection.deleteCollaborateur(numeroIdentification);

                } else if (choiceDelete == 2) {
                    System.out.println("Veuillez saisir le numero d'identification du collaborateur à supprimer");
                    int numeroIdentification = scanner.nextInt();

                    dbConnection.deleteScUnite(numeroIdentification);
                    dbConnection.deleteScientifique(numeroIdentification);
                    dbConnection.deleteCollaborateur(numeroIdentification);

                } else if (choiceDelete == 3) {
                    System.out.println("Veuillez saisir le numero d'identification du collaborateur à supprimer");
                    int numeroIdentification = scanner.nextInt();

                    dbConnection.deleteComEvenement(numeroIdentification);
                    dbConnection.deleteCommercial(numeroIdentification);
                    dbConnection.deleteCollaborateur(numeroIdentification);
                }else{
                    System.out.println("Ce collaborateur n'existe pas");
                }
            break;

            case 4:
                System.out.println("Saisissez le numero d'identification du collaborateur à afficher : ");

                int numIdentification = scanner.nextInt();

                List<Collaborateur> collaborateurs = dbConnection.findCollaborateur(numIdentification);

                for (Collaborateur collaborateur : collaborateurs) {
                    System.out.println(collaborateur);
                }
                break;

            case 5:
                    System.out.println("Saisissez le numero d'identification du collaborateur :");

                    int numeroId = scanner.nextInt();

                    List<Collaborateur> collab = dbConnection.findCollaborateur(numeroId);

                    for(Collaborateur collaborateur : collab){
                        System.out.println(collaborateur.getComputedSalaire());
                    }

                    System.out.println("Souhaitez vous enregistrer le nouveau salaire calculé pour ce collaborateur?O/N");
                    scanner.nextLine();
                    String register = scanner.nextLine();

                    if(register.equals("O")){
                        dbConnection.update(collab.get(0));
                    }
        }

    }
}