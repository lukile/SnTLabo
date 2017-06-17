package databaseConnection;

import employes.Collaborateur;
import employes.Commercial;
import employes.Medecin;
import employes.Scientifique;
import evenements.Congres;
import evenements.Evenement;
import unite.Unite;

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

    public boolean insert(Unite unite, Collaborateur collaborateur){
        initConnection();

        try{
            String insert = "INSERT INTO unite(nomUnite, numeroRue, nomRue, codePostal, villeUnite, dateResponsabilite, nIdentificationSC)" +
                    "VALUES(?, ?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setString(1, unite.getNomUnite());
            statement.setString(2, unite.getNumeroRue());
            statement.setString(3, unite.getNomRue());
            statement.setInt(4, unite.getCodePostal());
            statement.setString(5, unite.getVille());
            statement.setString(6, unite.getDateResponsabilite());
            statement.setInt(7, collaborateur.getNumeroIdentification());

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean insert(Evenement evenement){
        initConnection();

        try{
            String insert = "INSERT INTO evenement(adresse, moleculeTestee)" +
                    "VALUES(?, ?);";
            PreparedStatement statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, evenement.getAdresse());
            statement.setString(2, evenement.getMoleculeTestee());

            statement.execute();

            ResultSet generetedKeys = statement.getGeneratedKeys();
            int evenementId;
            if(generetedKeys.next()){
                evenementId = generetedKeys.getInt(1);
                evenement.setId(evenementId);
            }

            if (evenement instanceof Congres){
                this.insert((Congres) evenement);
            }
        }catch(SQLException e){
            unchecked(() -> connection.rollback());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insert(Collaborateur collaborateur, Evenement evenement){
        initConnection();

        try{
            String insert = "INSERT INTO medecin_evenement(idMedecin, idEvenement)" +
                    "VALUES (?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setInt(1, collaborateur.getNumeroIdentification());
            statement.setInt(2, evenement.getId());

            return statement.execute();

        } catch (SQLException e) {
            unchecked(() -> connection.rollback());

            e.printStackTrace();
            return false;
        }
    }

    private boolean insert(Congres congres){
        try{
            String insert = "INSERT INTO congres(idEvenement, dateDebutCongres, dateFinCongres)" +
                    "VALUES(?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setInt(1, congres.getId());
            statement.setString(2, congres.getDateDebutCongres());
            statement.setString(3, congres.getDateFinCongres());

            return statement.execute();

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }
}
