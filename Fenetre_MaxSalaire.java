import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Fenetre_MaxSalaire extends JFrame implements ActionListener{

    JPanel Conteneur;
    JLabel titreTable;
    JButton closeBTN;
    private JTable tableauMaxSalaire;
    
    public Fenetre_MaxSalaire(){
        setTitle("Salaire maximal");
        setSize(800, 600);
        setLocation(300, 80);

        Conteneur = new JPanel();
        Conteneur.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));

        titreTable = new JLabel("Tableau des salaires maximales");
        Conteneur.add(titreTable);

        closeBTN = new JButton("Fermer la fenêtre");
        Conteneur.add(closeBTN);

        add(Conteneur);

        try {

            Connection connexion = ConnexionBD.getConnection();

            String queryMaxSalaire = "SELECT employe_bibliotheque.prenom_employe_bibliotheque AS Prenom, employe_bibliotheque.nom_employe_bibliotheque AS Nom, employes_salaires.salaire FROM employe_bibliotheque JOIN employes_salaires ON employe_bibliotheque.id_employe_bibliotheque = employes_salaires.id_employe_bibliotheque WHERE employes_salaires.salaire = (SELECT MAX(employes_salaires.salaire) FROM employes_salaires)";

           Statement stmt = connexion.createStatement();
           ResultSet rs = stmt.executeQuery(queryMaxSalaire);

           tableauMaxSalaire = new JTable(buildTableModel(rs));
    
            JScrollPane scrollPane = new JScrollPane(tableauMaxSalaire);
            add(scrollPane);
            
        } catch (Exception ex) {
            // TODO: handle exception
            System.out.println("La connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
        }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == closeBTN){
            setVisible(false);
        }
    }

    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();

        rs.last();
        int rowCount = rs.getRow();
        rs.beforeFirst();

        String[] collumnNames = new String[metaData.getColumnCount()];
        for(int i = 0; i < metaData.getColumnCount(); i++){
            collumnNames[i] = metaData.getColumnLabel(i + 1);
        }

        Object[][] data = new Object[rowCount][metaData.getColumnCount()];
        int row = 0;
        while (rs.next()){
            for(int i = 0; i < data[row].length; i++){
                data[row][i] = rs.getObject(i + 1);
            }
            row++;
        }
        return new DefaultTableModel(data, collumnNames);
    }
}
