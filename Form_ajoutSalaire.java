import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;

public class Form_ajoutSalaire extends JFrame implements ActionListener{

    private JPanel Conteneur;
    private JLabel nomLabel, prenomLabel, salaireLabel, datePaiementLabel;
    private JComboBox<Employes> employesComboBox;
    private JComboBox<Double> salaires;
    private JTextField  salaireTextField, datePaiementTextField;
    private JDateChooser datePaiementChooser;
    private JButton enregistrerButton;
    private Connection conn;

    public Form_ajoutSalaire(){
        setTitle("Mettre à jour les salaires");
        setSize(600, 300);
        setLocation(300, 80);

        Conteneur = new JPanel();
        Conteneur.setLayout(new GridLayout(5, 2, 10, 10));
        nomLabel = new JLabel("Employé(e) :");

        Conteneur.add(nomLabel);
        employesComboBox = new JComboBox<>();
        Conteneur.add(employesComboBox);


        salaireLabel = new JLabel("Salaire :");
        Conteneur.add(salaireLabel);

        salaires = new JComboBox<>(new Double[]{1700.00, 1800.00, 2500.00});
        salaires.addActionListener(this);
        Conteneur.add(salaires);

        datePaiementLabel = new JLabel("Date de paiement :");
        Conteneur.add(datePaiementLabel);
        datePaiementChooser = new JDateChooser();
        Conteneur.add(datePaiementChooser);
        enregistrerButton = new JButton("Enregistrer");
        enregistrerButton.addActionListener(this);
        Conteneur.add(new JLabel());
        Conteneur.add(enregistrerButton);
        add(Conteneur);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
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
        if(e.getSource() == enregistrerButton){
           
            Employes employes =  (Employes) employesComboBox.getSelectedItem();

            String Nom_employe = employes.getNom();
            //String Prenom_employe = employes.getPrenom();
            
            Double salaire = (Double) salaires.getSelectedItem();
            Date datePaiement = datePaiementChooser.getDate();
            int EmployeID = 0;

            try{
                Connection connexion = ConnexionBD.getConnection();
                
                String selectEmployeID = "SELECT id_employe_bibliotheque " + 
                "FROM employe_bibliotheque " + 
                "WHERE nom_employe_bibliotheque = '" + Nom_employe + "';";
                //" AND prenom_employe_bibliotheque = '" + Prenom_employe + "';";

                Statement stmt = connexion.createStatement();
                ResultSet res = stmt.executeQuery(selectEmployeID);
                //PreparedStatement selectEmployeIDStmt = connexion.prepareStatement(selectEmployeID);
                while (res.next()){
                    res.getInt(1);
                    EmployeID = res.getInt(1);
                }
               // ResultSet EmployeIDResult = selectEmployeIDStmt.executeQuery();

               String insertSalaireQuery = "INSERT INTO employes_salaires (id_employe_bibliotheque, salaire, date_paiement) VALUES (?, ?, ?)";
               PreparedStatement insertSalaireQueryStmt = connexion.prepareStatement(insertSalaireQuery);
               insertSalaireQueryStmt.setInt(1, EmployeID);
               insertSalaireQueryStmt.setDouble(2, salaire);
               insertSalaireQueryStmt.setDate(3, null);

               insertSalaireQueryStmt.executeUpdate();

                

            } catch(SQLException ex){
                System.out.println("Le connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
            }
        }
    }
}