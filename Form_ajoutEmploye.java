import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.LinkedList;
import java.sql.*;

public class Form_ajoutEmploye extends JFrame implements ActionListener{
    JLabel JlNom, JlPrenom, JlFonction;
    JTextField txtNom, txtPrenom, txtFonction;
    JButton SaveBTN, ClearBTN;
    JPanel Conteneur;

    public Form_ajoutEmploye(){
        setTitle("Formulaire d'ajout");
        setSize(800, 600);
        setLocation(300, 80);
        setLayout(new GridLayout(10, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JlNom = new JLabel("Nom :");
        txtNom = new JTextField(20);
        JlPrenom = new JLabel("Prenom :");
        txtPrenom = new JTextField(3);
        JlFonction = new JLabel("Fonction :");
        txtFonction = new JTextField(10);

        SaveBTN = new JButton("Enregistrer :");
        SaveBTN.addActionListener(this);
        ClearBTN = new JButton("Effacer");
        ClearBTN.addActionListener(this);

        Conteneur = new JPanel(/*new GridLayout(4, 2)*/);
        Conteneur.add(JlNom);
        Conteneur.add(txtNom);
        Conteneur.add(JlPrenom);
        Conteneur.add(txtPrenom);
        Conteneur.add(JlFonction);
        Conteneur.add(txtFonction);
        Conteneur.add(SaveBTN);
        add(Conteneur);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == SaveBTN){
            String Nom = txtNom.getText();
            String Prenom = txtPrenom.getText();
            String Fonction = txtFonction.getText();

            try{


                String url = "jdbc:mysql://localhost:3306/bibliotheque_bd_ul";
                String user = "root";
                String password = "";
                Connection conn = DriverManager.getConnection(url, user, password);

                

                String SelectFunctionID = "SELECT id_fonction_employe FROM fonction_employe_bibliotheque WHERE libelle_fonction_employe =?";
                PreparedStatement selectFunctionIDStmt = conn.prepareStatement(SelectFunctionID);
                selectFunctionIDStmt.setString(1, Fonction);
                ResultSet functionIDResult = selectFunctionIDStmt.executeQuery();
                int functionID = 0;
                if(functionIDResult.next()){
                    functionID = functionIDResult.getInt("id_fonction_employe");
                }

                String QueryEmploye = "INSERT INTO employe_bibliotheque (nom_employe_bibliotheque, prenom_employe_bibliotheque, id_fonction_employe) VALUES (?,?,?)";
                PreparedStatement QueryEmployeStmt = conn.prepareStatement(QueryEmploye);
                QueryEmployeStmt.setString(1, Nom);
                QueryEmployeStmt.setString(2, Prenom);
                QueryEmployeStmt.setInt(3, functionID);

                QueryEmployeStmt.executeUpdate();
                txtNom.setText("");
                txtPrenom.setText("");
                txtFonction.setText("");
                conn.close();
            }catch(SQLException ex){
                System.out.println("La connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
    }
} 