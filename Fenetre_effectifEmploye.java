import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Fenetre_effectifEmploye extends JFrame implements ActionListener{
    
    JButton FormBTN, CloseBTN, UpdateBTN, DeleteBTN;
    JLabel Suppress, lPrenom, lNom;
    JTextField txtNom, txtPrenom;
    private JTable tableauEmployes;
    private Form_ajoutEmploye F1;
    
    public Fenetre_effectifEmploye(){
        setTitle("Gestion des employés");
        setSize(800, 600);
        setLocation(300, 80);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel ConteneurA = new JPanel();
        ConteneurA.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));
       
        FormBTN = new JButton("Enregistrer \n des employes");
        FormBTN.addActionListener(this);
        ConteneurA.add(FormBTN);

        UpdateBTN = new JButton("Mettre à jour les statuts");
        UpdateBTN.addActionListener(this);
        ConteneurA.add(UpdateBTN);


        CloseBTN = new JButton("Fermer la fenetre");
        CloseBTN.addActionListener(this);
        ConteneurA.add(CloseBTN);

        try{
        
        String url = "jdbc:mysql://localhost:3306/bibliotheque_bd_ul";
        String user = "root";
        String password = "";
        Connection conn = DriverManager.getConnection(url, user, password);

        String queryEmploye = "SELECT employe_bibliotheque.prenom_employe_bibliotheque AS Prénom, employe_bibliotheque.nom_employe_bibliotheque AS Nom, fonction_employe_bibliotheque.libelle_fonction_employe AS Poste FROM employe_bibliotheque JOIN fonction_employe_bibliotheque ON fonction_employe_bibliotheque.id_fonction_employe = employe_bibliotheque.id_fonction_employe";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(queryEmploye);

        tableauEmployes = new JTable(buildTableModel(rs));

        JScrollPane scrollPane = new JScrollPane(tableauEmployes);
        
        JPanel ConteneurB = new JPanel();
        ConteneurB.setLayout(new BorderLayout());
        ConteneurB.add(scrollPane, BorderLayout.CENTER);

        getContentPane().add(ConteneurA, BorderLayout.NORTH);
        getContentPane().add(ConteneurB, BorderLayout.CENTER);


        conn.close();

        }catch(SQLException e){
            e.printStackTrace();
        }

        JPanel ConteneurC = new JPanel();
        ConteneurC.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));

        Suppress = new JLabel("Supprimer un(e) employé(é) :");
        ConteneurC.add(Suppress);
        lNom = new JLabel("Nom");
        ConteneurC.add(lNom);
        txtNom = new JTextField(10);
        ConteneurC.add(txtNom);
        lPrenom = new JLabel("Prénom");
        ConteneurC.add(lPrenom);
        txtPrenom = new JTextField(10);
        ConteneurC.add(txtPrenom);

        DeleteBTN = new JButton("Supprimer");
        DeleteBTN.addActionListener(this);
        ConteneurC.add(DeleteBTN);

        getContentPane().add(ConteneurC, BorderLayout.SOUTH);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == FormBTN){
            Form_ajoutEmploye myForm_ajoutEmploye = new Form_ajoutEmploye();
        }

        if(e.getSource() == UpdateBTN){
           // Form_updateEmploye myForm_updateEmploye = new Form_updateEmploye();
        }

        if(e.getSource() == CloseBTN){
            setVisible(false);
        }

        if(e.getSource() == DeleteBTN){
            String Nom = txtNom.getText();
            String Prenom = txtPrenom.getText();

            try{
                String url = "jdbc:mysql://localhost:3306/bibliotheque_bd_ul";
                String user = "root";
                String password = "";
                Connection conn = DriverManager.getConnection(url, user, password);



                String deleteEmploye = "DELETE FROM employe_bibliotheque WHERE nom_employe_bibliotheque = ? AND prenom_employe_bibliotheque = ?";
                PreparedStatement deleteEmployeStmt = conn.prepareStatement(deleteEmploye);

                deleteEmployeStmt.setString(1, Nom);
                deleteEmployeStmt.setString(2, Prenom);

                deleteEmployeStmt.executeUpdate();
                txtNom.setText("");
                txtPrenom.setText("");
                conn.close();

            }catch(SQLException ex){
                System.out.println("La connexion à la base de donnée à échouée");
                System.out.println("Erreur : " + ex.getMessage());
            }

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