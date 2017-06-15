import databaseConnection.DatabaseConnection;

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
                System.out.println("Numero d'identification : ");
                int numeroIdentification = scanner.nextInt();


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

                System.out.println("numero id : " + numeroIdentification + "\n "
                                + " nom : " + nom + "\n "
                                + " prenom : " + prenom + "\n"
                                + " mail : " + email + "\n"
                                + " tel :" + telephone + "\n"
                                + " code Projet : " + codeProjet + "\n"
                                + " date embauche : " + dateEmbauche + "\n"
                                + " ville : " + ville + ' ');

                dbConnection.insert(numeroIdentification,
                        nom,
                        prenom,
                        email,
                        telephone,
                        codeProjet,
                        dateEmbauche,
                        ville);
        }
	}
}
