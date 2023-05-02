import java.sql.*;

public class ConnexionBD{
    private static final String URL = "jdbc:mysql://localhost:3306/bibliotheque_bd_ul";
    private static final String USER = "root";
    private static final String PASSWORD = "";


    private static Connection connexion;

    public static Connection getConnection() throws SQLException{
        if(connexion == null || connexion.isClosed()){
            connexion = DriverManager.getConnection(URL, USER, PASSWORD);
        }

        return connexion;
    }

    public static void fermerConnexion() throws SQLException{
        if(connexion != null && !connexion.isClosed()){
            connexion.close();
        }
    }
}