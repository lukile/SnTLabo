package databaseConnection;

import employes.Collaborateur;
import employes.Commercial;
import employes.Medecin;
import employes.Scientifique;

import java.sql.*;

public class DatabaseConnection {

    private Connection connection;

    public boolean insert(Collaborateur collaborateur) {
        initConnection();

        try {
            String insert = "INSERT INTO collaborateur(nom, prenom, email, telephone, codeProjet, dateEmbauche, ville) " +
                    "VALUES (?,?,?,?,?,?,?);";

            PreparedStatement statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, collaborateur.getNom());
            statement.setString(2, collaborateur.getPrenom());
            statement.setString(3, collaborateur.getEmail());
            statement.setString(4, collaborateur.getTelephone());
            statement.setInt(5, collaborateur.getCodeProjet());
            statement.setString(6, collaborateur.getDateEmbauche());
            statement.setString(7, collaborateur.getVille());

            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int collaborateurId;
            if (generatedKeys.next()) {
                collaborateurId = generatedKeys.getInt(1);
                collaborateur.setNumeroIdentification(collaborateurId);
            }

            if (collaborateur instanceof Medecin) {
                this.insert((Medecin) collaborateur);
            }else if(collaborateur instanceof Scientifique){
                this.insert((Scientifique) collaborateur);
            } else if (collaborateur instanceof Commercial) {
                this.insert((Commercial) collaborateur);
            }
        } catch (SQLException e) {
            unchecked(() -> connection.rollback());

            e.printStackTrace();
            return false;
        } finally {
            unchecked(() -> connection.close());
        }
        return true;
    }

    private void unchecked(WrapSqlFunction function) {
        try {
            function.run();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private void initConnection() {
        String url = "jdbc:mysql://localhost:3306/sntlabo";
        String login = "root";
        String pwd = "";

        try {
            Class.forName("com.mysql.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, login, pwd);

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private boolean insert(Medecin medecin) {
        try {

            String insert = "INSERT INTO medecin(nIdentification, salaire, prime, essaiClinique, debutEssaiClinique, finEssaiClinique)" +
                    "VALUES(?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setInt(1, medecin.getNumeroIdentification());
            statement.setDouble(2, medecin.getSalaire());
            statement.setDouble(3, medecin.getPrime());
            statement.setBoolean(4, medecin.isEssaiClinique());
            statement.setString(5, medecin.getDebutEssaiClinique());
            statement.setString(6, medecin.getFinEssaiClinique());

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean insert(Scientifique scientifique){
        try{
            String insert = "INSERT INTO scientifique(nIdentification, salaire, prime, responsable)" +
                    "VALUES(?, ?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setInt(1, scientifique.getNumeroIdentification());
            statement.setDouble(2, scientifique.getSalaire());
            statement.setDouble(3, scientifique.getPrime());
            statement.setBoolean(4, scientifique.isResponsable());

            return statement.execute();

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }


    private boolean insert(Commercial commercial) {
        try {

            String insert = "INSERT INTO commercial(nIdentification, salaire, noteDeFrais, remboursement)" +
                    "VALUES(?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setInt(1, commercial.getNumeroIdentification());
            statement.setDouble(2, commercial.getSalaire());
            statement.setDouble(3, commercial.getNoteDeFrais());
            statement.setBoolean(4, commercial.isRemboursement());

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}
