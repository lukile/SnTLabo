package databaseConnection;

import java.sql.*;

public class DatabaseConnection {

    private Connection getConnection() {
        String url = "jdbc:mysql://localhost:3306/sntlabo";
        String login = "root";
        String pwd = "";
        Connection connexion = null;
       // Statement statement = null;

        try {
            Class.forName("com.mysql.jdbc.Driver");
            connexion = DriverManager.getConnection(url, login, pwd);
            //statement = connexion.createStatement();

        } catch (SQLException e) {
            e.printStackTrace();

        } catch (ClassNotFoundException e) {

            e.printStackTrace();
        } /*finally {
            try {
                // Etape 6 : libérer ressources de la mémoire proprement
                connexion.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }*/

        return connexion;
    }


    public boolean insert(int numeroIdentification,
                          String nom,
                          String prenom,
                          String email,
                          String telephone,
                          int codeProjet,
                          String dateEmbauche,
                          String ville) {

        Connection connection = getConnection();

        try {
            Statement statement = connection.createStatement();

            String insert = "INSERT INTO collaborateur VALUES ("+
                    numeroIdentification + ","+
                    nom + "," +
                    prenom + ","+
                    email + "," +
                    telephone + "," +
                    codeProjet + "," +
                    dateEmbauche +"," +
                    ville + ");";

            statement.execute(insert);
            System.out.println("L'insertion s'est bien passée");

            /*ResultSet result = statement.executeQuery("SELECT * FROM collaborateur;");

            while(result.next()){
                int numero = result.getInt("numeroIdentification");
                String name = result.getString("nom");
                String surname = result.getString("prenom");
                String mail = result.getString("email");
                String phone = result.getString("telephone");
                int code = result.getInt("codeProjet");
                String date = result.getString("dateEmbauche");
                String country = result.getString("ville");

                System.out.println(numero);
                System.out.println(name);
                System.out.println(surname);
                System.out.println(mail);
                System.out.println(phone);
                System.out.println(code);
                System.out.println(date);
                System.out.println(country);
            }*/
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}

