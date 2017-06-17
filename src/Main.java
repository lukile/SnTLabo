import databaseConnection.DatabaseConnection;
import employes.Collaborateur;
import employes.Commercial;
import employes.Medecin;
import employes.Scientifique;
import unite.Unite;

import javax.sound.midi.Soundbank;
import java.sql.Connection;
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

//                    Collaborateur collaborateur = new Medecin(
//                            nom, prenom, email, telephone,
//                            codeProjet, dateEmbauche, ville, salaire,
//                            prime, essaiClinique, debutEssaiClinque, finEssaiClinque
//                    );
//                    dbConnection.insert(collaborateur);

                }else if(choice == 2){
                    System.out.println("Salaire : ");
                    Double salaire = scanner.nextDouble();

                    System.out.println("Prime : ");
                    Double prime = scanner.nextDouble();


                    System.out.println("Le Scientifique est il responsable d'une unité?O/N");
                    scanner.nextLine();
                    String yesOrNot = scanner.nextLine();

                    boolean responsable = false;

                    if(yesOrNot.equals("O")){
                        responsable = true;
                    }else{
                        responsable = false;
                    }

                    Collaborateur collaborateur = new Scientifique(
                            nom, prenom, email, telephone,
                            codeProjet, dateEmbauche, ville, salaire,
                            prime, responsable
                    );
                    dbConnection.insert(collaborateur);


                    System.out.println("Le scientifique est il affecté à une unité?O/N");
                    String yesOrNotU = scanner.nextLine();

                    if(yesOrNotU.equals("O")){
                        System.out.println("Renseignez le nom de l'unité :");
                        String nomUnite = scanner.nextLine();
//                        String nomUnite = "Unite centrale";

                        System.out.println("N° de rue :");
                        String numRue = scanner.nextLine();
//                        String numRue = "3bis";

                        System.out.println("Nom de la rue :");
                        String nomRue = scanner.nextLine();
//                        String nomRue = "rue de la Girouette";

                        System.out.println("Code Postal :");
                        int cp = scanner.nextInt();
//                        int cp = 74321;

                        System.out.println("Ville :");
                        scanner.nextLine();
                        String villeU = scanner.nextLine();
//                        String villeU = "Rouen";

                        System.out.println("Date de la prise de la prise de responsabilité du scientifique (0 si le scientifique n'est pas responsable de l'unité):");
                        String dateResponsabiliteSC = scanner.nextLine();

//                        String dateResponsabiliteSC = "12/07/2012";

                        Unite unite = new Unite(
                                nomUnite, numRue, nomRue, cp,
                                villeU, dateResponsabiliteSC
                        );
                        dbConnection.insert(unite, collaborateur);
                    }



                }else if(choice == 3){
                    System.out.println("Salaire :");
                    Double salaire = scanner.nextDouble();

                    System.out.println("Note de frais :");
                    Double noteDeFrais = scanner.nextDouble();

                    System.out.println("Le remboursement a t il été effectué?O/N");
                    scanner.nextLine();
                    String yesOrNot = scanner.nextLine();

                    boolean remboursement = false;

                    if(yesOrNot.equals("O")){
                        remboursement = true;
                    }else{
                        remboursement = false;
                    }
                    Collaborateur collaborateur = new Commercial(
                            nom, prenom, email, telephone,
                            codeProjet, dateEmbauche, ville, salaire,
                            noteDeFrais, remboursement
                    );

                    dbConnection.insert(collaborateur);
                }




        }
    }
}