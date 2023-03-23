//import com.mysql.jdbc.Connection;
import java.sql.*;

public class Conector_DataBase{
private String S;
private Connection conn;

public Conector_DataBase(){
    try{
        Class.forName("com.mysql.jdbc.Driver");
        System.out.println("Driver trouve...");
        conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/bibliotheque_bd_ul", "root", "");
        System.out.println("Connexion etablie...");
        System.out.println("");
    }catch(Exception e){
        System.out.println(e.getMessage());
        System.exit(0);
    }
}
}