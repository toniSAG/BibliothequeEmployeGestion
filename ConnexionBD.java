import java.sql.*;

public class ConnexionBD{
    private static final String HOST = "localhost";
    private static final String PORT = "3306";
    private static final String DATABASE = "bibliotheque_bd_ul";
    private static final String USER = "root";
    private static final String PASSWORD = "";
    private static Connection connexion;

    
    public static Connection getConnection() throws SQLException{
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("Driver trouve...");
            connexion = DriverManager.getConnection("jdbc:mysql://" + HOST + ":" + PORT + "/" + DATABASE, USER, PASSWORD);
            System.out.println("Connexion etablie...");
            System.out.println("");
        }catch(ClassNotFoundException e){
            System.out.println("erreur, Driver non trouvé");
            e.printStackTrace();
        }catch(SQLException e){
            System.out.println("Erreur, impossible de se connecter à la base de données !");
            e.printStackTrace();
        }

        return connexion;
    }

    public static void fermerConnexion() throws SQLException{
        if(connexion != null && !connexion.isClosed()){
            connexion.close();
        }
    }
}