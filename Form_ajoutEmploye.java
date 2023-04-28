import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.sql.*;


public class Form_ajoutEmploye extends JFrame implements ActionListener{
    JLabel JlNom, JlPrenom, JlFonction;
    JTextField txtNom, txtPrenom, txtFonction; 
    JButton SaveBTN, ClearBTN;
    JPanel Conteneur;
    private JComboBox<String> listeFonction;

    public Form_ajoutEmploye(){
        setTitle("Formulaire d'ajout");
        setSize(600, 300);
        setLocation(300, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JlNom = new JLabel("Nom :");
        txtNom = new JTextField(10);
        JlPrenom = new JLabel("Prenom :");
        txtPrenom = new JTextField(10);
        JlFonction = new JLabel("Fonction :");


        listeFonction = new JComboBox<>(new String[]{"", "Directeur", "Responsable d'équipe", "Bibliothécaire", "Documentaliste"});
        listeFonction.addActionListener(this);

        SaveBTN = new JButton("Enregistrer :");
        SaveBTN.addActionListener(this);
        ClearBTN = new JButton("Annuler");
        ClearBTN.addActionListener(this);

        JPanel Conteneur = new JPanel();
        Conteneur.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        Conteneur.add(JlNom);
        Conteneur.add(txtNom);
        Conteneur.add(JlPrenom);
        Conteneur.add(txtPrenom);
        Conteneur.add(JlFonction);
        Conteneur.add(listeFonction);
        Conteneur.add(SaveBTN);
        Conteneur.add(ClearBTN);
        add(Conteneur);


        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if (e.getSource() == SaveBTN){
            String Nom = txtNom.getText();
            String Prenom = txtPrenom.getText();
            String Fonction = (String) listeFonction.getSelectedItem();

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
                listeFonction.setSelectedItem("");
                conn.close();
            }catch(SQLException ex){
                System.out.println("La connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
            }
        }

        if(e.getSource() == ClearBTN){
            setVisible(false);
        }
    }
}