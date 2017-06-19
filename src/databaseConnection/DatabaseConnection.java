package databaseConnection;

import employes.Collaborateur;
import employes.Commercial;
import employes.Medecin;
import employes.Scientifique;
import evenements.Congres;
import evenements.Evenement;
import evenements.Soiree;
import unite.Unite;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

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
            if (this.connection == null || this.connection.isClosed()) {
                this.connection = DriverManager.getConnection(url, login, pwd);
            }
        } catch (SQLException e) {
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

    public boolean insert(Unite unite){
        initConnection();

        try{
            String insert = "INSERT INTO unite(nomUnite, numeroRue, nomRue, codePostal, villeUnite, dateResponsabilite)" +
                    "VALUES(?, ?, ?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert, Statement.RETURN_GENERATED_KEYS);

            statement.setString(1, unite.getNomUnite());
            statement.setString(2, unite.getNumeroRue());
            statement.setString(3, unite.getNomRue());
            statement.setInt(4, unite.getCodePostal());
            statement.setString(5, unite.getVille());
            statement.setString(6, unite.getDateResponsabilite());

            statement.execute();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            int uniteId;
            if(generatedKeys.next()){
                uniteId = generatedKeys.getInt(1);
                unite.setId(uniteId);
            }

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertScUnite(Collaborateur collaborateur, Unite unite){
        initConnection();

        try {

            String insertScUnite = "INSERT INTO scientifique_unite(idScientifique, idUnite) " +
                    "VALUES(?, ?);";

            PreparedStatement statement = connection.prepareStatement(insertScUnite);

            statement.setInt(1, collaborateur.getNumeroIdentification());
            statement.setInt(2, unite.getId());

            return statement.execute();

        }catch (SQLException e) {
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
            }else if(evenement instanceof Soiree){
                this.insert((Soiree) evenement);
            }

        }catch(SQLException e){
            unchecked(() -> connection.rollback());
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean insertMedecinEvenement(Collaborateur collaborateur, Evenement evenement){
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

    private boolean insert(Soiree soiree){
        try{
            String insert = "INSERT INTO soiree(idEvenement, dateSoiree, heureDebutSoiree, heureFinSoiree)" +
                    "VALUES(?, ?, ?, ?);";

            PreparedStatement statement = connection.prepareStatement(insert);

            statement.setInt(1, soiree.getId());
            statement.setString(2, soiree.getDateSoiree());
            statement.setString(3, soiree.getHeureDebutSoiree());
            statement.setString(4, soiree.getHeureFinSoiree());

            return statement.execute();

        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    public boolean insertCommercialEvenement(Collaborateur collaborateur, Evenement evenement){
        initConnection();

        try{
            String insert = "INSERT INTO commercial_evenement(idCommercial, idEvenement)" +
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

    public boolean update(Collaborateur collaborateur) {
        initConnection();

        try {
            String update = "UPDATE collaborateur " +
                    "SET nom = ?, prenom = ?, email = ?, telephone = ?, codeProjet = ?, dateEmbauche = ?, ville = ?" +
                    "WHERE numeroIdentification = ?";

            PreparedStatement statement = connection.prepareStatement(update);

            statement.setString(1, collaborateur.getNom());
            statement.setString(2, collaborateur.getTelephone());
            statement.setString(3, collaborateur.getEmail());
            statement.setString(4, collaborateur.getTelephone());
            statement.setInt(5, collaborateur.getCodeProjet());
            statement.setString(6, collaborateur.getDateEmbauche());
            statement.setString(7, collaborateur.getVille());
            statement.setInt(8, collaborateur.getNumeroIdentification());

            statement.execute();

            if(collaborateur instanceof Medecin){
                this.update((Medecin) collaborateur);
            }else if(collaborateur instanceof Scientifique){
                this.update((Scientifique) collaborateur);
            }else if(collaborateur instanceof Commercial){
                this.update((Commercial) collaborateur);
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

    private boolean update(Medecin medecin){
        try {
            String update = "UPDATE medecin " +
                    "SET salaire = ?, prime = ?, essaiClinique = ? , debutEssaiClinique = ?, " +
                    "finEssaiClinique = ? " +
                    "WHERE nIdentification = ?";

            PreparedStatement statement = connection.prepareStatement(update);

            statement.setDouble(1, medecin.getSalaire());
            statement.setDouble(2, medecin.getPrime());
            statement.setBoolean(3, medecin.isEssaiClinique());
            statement.setString(4, medecin.getDebutEssaiClinique());
            statement.setString(5, medecin.getFinEssaiClinique());
            statement.setInt(6, medecin.getNumeroIdentification());

            return statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean update(Scientifique scientifique){
        try{
            String update = "UPDATE scientifique " +
                    "SET salaire = ?, prime = ?, responsable = ? " +
                    "WHERE nIdentification = ?";

            PreparedStatement statement = connection.prepareStatement(update);

            statement.setDouble(1, scientifique.getSalaire());
            statement.setDouble(2, scientifique.getPrime());
            statement.setBoolean(3, scientifique.isResponsable());
            statement.setInt(4, scientifique.getNumeroIdentification());

            return statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean update(Commercial commercial){
        try{
            String update = "UPDATE commercial " +
                    "SET salaire = ?, noteDeFrais = ?, remboursement = ? " +
                    "WHERE nIdentification = ?";

            PreparedStatement statement = connection.prepareStatement(update);

            statement.setDouble(1, commercial.getSalaire());
            statement.setDouble(2, commercial.getNoteDeFrais());
            statement.setBoolean(3, commercial.isRemboursement());
            statement.setInt(4, commercial.getNumeroIdentification());

            return statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMedecinEvenement(int numeroIdentification) {
        initConnection();

        try {
            String delete = "DELETE FROM medecin_evenement " +
                    "WHERE idMedecin = ?;";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteMedecin(int numeroIdentification) {
        initConnection();

        try {
            String delete = "DELETE FROM medecin " +
                    "WHERE nIdentification = ?;";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCollaborateur(int numeroIdentification){
        initConnection();

        try{
            String delete = "DELETE FROM collaborateur " +
                    "WHERE numeroIdentification = ?";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return  statement.execute();

        } catch (SQLException e) {
            unchecked(() -> connection.rollback());

            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteScUnite(int numeroIdentification) {
        initConnection();

        try {
            String delete = "DELETE FROM scientifique_unite " +
                    "WHERE idScientifique = ?;";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteScientifique(int numeroIdentification){
        initConnection();

        try{
            String delete = "DELETE FROM scientifique " +
                    "WHERE nIdentification = ?;";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return statement.execute();

        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteComEvenement(int numeroIdentification){
        initConnection();

        try{
            String delete = "DELETE FROM commercial_evenement " +
                    "WHERE idCommercial = ?;";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean deleteCommercial(int numeroIdentification){
        initConnection();

        try{
            String delete = "DELETE FROM commercial " +
                    "WHERE nIdentification = ?;";

            PreparedStatement statement = connection.prepareStatement(delete);

            statement.setInt(1, numeroIdentification);

            return statement.execute();

        }catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public List<Collaborateur> findCollaborateur(int numeroIdentification) {
        List<Collaborateur> results = new ArrayList<>();
        initConnection();
        try {
            String request = "SELECT * FROM collaborateur " +
                    "WHERE numeroIdentification = ?;";

            PreparedStatement statement = connection.prepareStatement(request);

            statement.setInt(1, numeroIdentification);

            ResultSet result = statement.executeQuery();
            while(result.next()) {
                String nom = result.getString(2);
                String prenom = result.getString(3);
                String email = result.getString(4);
                String telephone = result.getString(5);
                int codeProjet = result.getInt(6);
                String dateEmbauche = result.getString(7);
                String ville = result.getString(8);

                Collaborateur collaborateur = new Collaborateur(nom, prenom, email,
                        telephone, codeProjet, dateEmbauche, ville);

                collaborateur.setNumeroIdentification(numeroIdentification);
                if (existsIn("medecin", collaborateur)) {
                    collaborateur = getMedecin(collaborateur);
                } else if (existsIn("commercial", collaborateur)) {
                    collaborateur = getCommercial(collaborateur);
                } else if (existsIn("scientifique", collaborateur)){
                    collaborateur = getScientifique(collaborateur);
                }

                results.add(collaborateur);
            }

            return results;

        } catch (SQLException e) {
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    private Collaborateur getCommercial(Collaborateur collaborateur) {
        initConnection();
        String request = "SELECT c.salaire as salaire, c.noteDeFrais as noteDeFrais, c.remboursement as remboursement " +
                "FROM commercial c " +
                "WHERE c.nIdentification = ?";

        PreparedStatement statement;

        try {
            statement = connection.prepareStatement(request);
            statement.setInt(1, collaborateur.getNumeroIdentification());

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Double salaire = result.getDouble("salaire");
                Double noteDeFrais = result.getDouble("noteDeFrais");
                boolean remboursement = result.getBoolean("remboursement");

                Commercial commercial = new Commercial(collaborateur, noteDeFrais, remboursement);
                commercial.setSalaire(salaire);
                return commercial;
            }
            return null;
        }catch (SQLException e) {
                e.printStackTrace();
                return null;
            }
    }

    private Medecin getMedecin(Collaborateur collaborateur) {
        initConnection();
        String request = "SELECT m.salaire as salaire, m.prime as prime, m.essaiClinique as essaiClinique, " +
                "m.debutEssaiClinique as debutEssaiClinique, m.finEssaiClinique as finEssaiClinique " +
                "FROM sntlabo.medecin m " +
                "WHERE m.nIdentification = ?";

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(request);
            statement.setInt(1, collaborateur.getNumeroIdentification());

            ResultSet result = statement.executeQuery();

            if (result.next()) {
                Double salaire = result.getDouble("salaire");
                Double prime = result.getDouble("prime");
                boolean essaiClinique = result.getBoolean("essaiClinique");
                String debutEssaiClinique = result.getString("debutEssaiClinique");
                String finEssaiClinique = result.getString("finEssaiClinique");

                Medecin medecin = new Medecin(collaborateur, prime, essaiClinique, debutEssaiClinique, finEssaiClinique);
                medecin.setSalaire(salaire);
                return medecin;
            }
            return null;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Scientifique getScientifique(Collaborateur collaborateur){
        initConnection();

        String request = "SELECT s.salaire as salaire, s.prime as prime, s.responsable as responsable " +
                "FROM scientifique s " +
                "WHERE s.nIdentification = ?";

        PreparedStatement statement;

        try{
            statement = connection.prepareStatement(request);
            statement.setInt(1, collaborateur.getNumeroIdentification());

            ResultSet result = statement.executeQuery();

            if(result.next()){

                Double salaire = result.getDouble("salaire");
                Double prime = result.getDouble("prime");
                boolean responsable = result.getBoolean("responsable");

                Scientifique scientifique = new Scientifique(collaborateur, prime, responsable);
                scientifique.setSalaire(salaire);
                return scientifique;
            }
            return null;

        }catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    private boolean existsIn(String tableName, Collaborateur collaborateur) {
        initConnection();
        String request = "SELECT count(*) as isKindOf FROM " + tableName + " m " +
                "WHERE nIdentification = ?";

        PreparedStatement statement;
        try {
            statement = connection.prepareStatement(request);
            statement.setInt(1, collaborateur.getNumeroIdentification());

            ResultSet result = statement.executeQuery();
            if (result.next()) {
                int isKindOf = result.getInt("isKindOf");

                return isKindOf > 0;
            }
            return false;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }




}
