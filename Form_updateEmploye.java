/*import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.sql.*;

public class Form_updateEmploye extends JFrame implements ActionListener{
    JPanel Conteneur;
    JLabel lMessage, lNom, lPrenom;
    JTextField txtPrenom, txtNom;
    private JComboBox<String> listeFonction;
    JButton SaveBTN, CloseBTN;

    public Form_updateEmploye(){
        setTitle("Mise à jour des status");
        setSize(600, 300);
        setLocation(300, 80);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Conteneur = new JPanel();
        Conteneur.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        lMessage = new JLabel("Définisser un nouveau statut");
        Conteneur.add(lMessage);
        lNom = new JLabel("Nom :");
        Conteneur.add(lNom);
        txtNom = new JTextField(10);
        Conteneur.add(txtNom);
        lPrenom = new JLabel("Prénom :");
        Conteneur.add(lPrenom);
        txtPrenom = new JTextField(10);
        Conteneur.add(txtPrenom);


        listeFonction = new JComboBox<>(new String[]{"", "Directeur", "Responsable d'équipe", "Bibliothécaire", "Documentaliste"});
        listeFonction.addActionListener(this);
        Conteneur.add(listeFonction);

        SaveBTN = new JButton("Enregistrer");
        SaveBTN.addActionListener(this);
        Conteneur.add(SaveBTN);

        CloseBTN = new JButton("Fermer");
        CloseBTN.addActionListener(this);
        Conteneur.add(CloseBTN);

        getContentPane().add(Conteneur, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == SaveBTN){
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

                String QueryUpdateEmploye = "UPDATE employe_bibliotheque SET id_fonction_employe = ? WHERE nom_employe_bibliotheque = ? AND prenom_employe_bibliotheque = ?";
                PreparedStatement UpdateEmployeStmt = conn.prepareStatement(QueryUpdateEmploye);
                UpdateEmployeStmt.setInt(1, functionID);
                UpdateEmployeStmt.setString(2, Nom);
                UpdateEmployeStmt.setString(3, Prenom);
                

                int rowsAffected = UpdateEmployeStmt.executeUpdate();
                if(rowsAffected > 0){
                    JOptionPane.showMessageDialog(null, "Le statut de " + Prenom + Nom + " à évolué");
                } else{
                    JOptionPane.showMessageDialog(null,"Cette personne n'est pas renseigné comme employe");
                }
                txtNom.setText("");
                txtPrenom.setText("");
                listeFonction.setSelectedItem("");
                conn.close();


            }catch(SQLException ex){
                System.out.println("La connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
            }
        }

        if(e.getSource() == CloseBTN){
            setVisible(false);
        }
    }
}*/