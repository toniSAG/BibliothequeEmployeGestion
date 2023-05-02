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
        nomLabel = new JLabel("Nom :");
        Conteneur.add(nomLabel);
        employesComboBox = new JComboBox<>();
        Conteneur.add(employesComboBox);
        prenomLabel = new JLabel("Prénom :");
        Conteneur.add(prenomLabel);
        Conteneur.add(new JLabel());
        salaireLabel = new JLabel("Salaire :");
        Conteneur.add(salaireLabel);
        salaireTextField = new JTextField();
        Conteneur.add(salaireTextField);
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

        PreparedStatement statement = conn.prepareStatement("Select nom_employe_bibliotheque FROM employe_bibliotheque");
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
        /*if(e.getSource() == enregistrerButton){
            String Nom
        }*/
    }
}