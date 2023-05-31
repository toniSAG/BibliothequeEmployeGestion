import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.LinkedList;
import java.sql.*;

public class Form_updateEmploye extends JFrame implements ActionListener{
    JPanel Conteneur;
    JLabel lMessage, employe/*lNom, lPrenom*/;
    JTextField txtPrenom, txtNom;
    private JComboBox<Employes> employesComboBox;
    private JComboBox<String> listeFonction;
    JButton SaveBTN, CloseBTN;

    public Form_updateEmploye(){
        setTitle("Mise à jour des status");
        setSize(600, 300);
        setLocation(300, 80);
       // setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         Conteneur = new JPanel();
        Conteneur.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

     /*   Conteneur = new JPanel();
        Conteneur.setLayout(new GridLayout(5, 2, 10, 10));*/

        lMessage = new JLabel("Définisser un nouveau statut");
        Conteneur.add(lMessage);
       /* lNom = new JLabel("Nom :");
        Conteneur.add(lNom);
        txtNom = new JTextField(10);
        Conteneur.add(txtNom);
        lPrenom = new JLabel("Prénom :");
        Conteneur.add(lPrenom);
        txtPrenom = new JTextField(10);
        Conteneur.add(txtPrenom);*/

        employe = new JLabel("Employé(e)");
        Conteneur.add(employe);
        employesComboBox = new JComboBox<>();
        Conteneur.add(employesComboBox);


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

        try{

            Connection connexion = ConnexionBD.getConnection();
            PreparedStatement statement = connexion.prepareStatement("SELECT nom_employe_bibliotheque, prenom_employe_bibliotheque FROM employe_bibliotheque");
            ResultSet result = statement.executeQuery();

        while (result.next()){
            Employes employe = new Employes(result.getString("nom_employe_bibliotheque"), result.getString("prenom_employe_bibliotheque"));
            employesComboBox.addItem(employe);
        }

        
        } catch(SQLException ex){
            System.out.println("La connexion à la base de donnée à échouée");
            System.out.println("Erreur : " + ex.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == SaveBTN){
           /* String Nom = txtNom.getText();
            String Prenom = txtPrenom.getText();*/

            Employes employes = (Employes) employesComboBox.getSelectedItem();
            String Nom_employe = employes.getNom();
        
            String Fonction = (String) listeFonction.getSelectedItem();

            try{
                Connection connexion = ConnexionBD.getConnection();

                

                String SelectFunctionID = "SELECT id_fonction_employe FROM fonction_employe_bibliotheque WHERE libelle_fonction_employe =?";
                PreparedStatement selectFunctionIDStmt = connexion.prepareStatement(SelectFunctionID);
                selectFunctionIDStmt.setString(1, Fonction);
                ResultSet functionIDResult = selectFunctionIDStmt.executeQuery();
                int functionID = 0;

                if(functionIDResult.next()){
                    functionID = functionIDResult.getInt("id_fonction_employe");
                }

                String QueryUpdateEmploye = "UPDATE employe_bibliotheque SET id_fonction_employe = ? WHERE nom_employe_bibliotheque = '"+ Nom_employe +"' ;";
                PreparedStatement UpdateEmployeStmt = connexion.prepareStatement(QueryUpdateEmploye);
                UpdateEmployeStmt.setInt(1, functionID);
              /*  UpdateEmployeStmt.setString(2, Nom);
                UpdateEmployeStmt.setString(3, Prenom);*/
                

                int rowsAffected = UpdateEmployeStmt.executeUpdate();
                if(rowsAffected > 0){
                    JOptionPane.showMessageDialog(null, "Le statut " + Nom_employe + " à évolué");
                } else{
                    JOptionPane.showMessageDialog(null,"Cette personne n'est pas renseigné comme employe");
                }
                txtNom.setText("");
                txtPrenom.setText("");
                listeFonction.setSelectedItem("");
                


            }catch(SQLException ex){
                System.out.println("La connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
            }
        }

        if(e.getSource() == CloseBTN){
            setVisible(false);
        }
    }
}