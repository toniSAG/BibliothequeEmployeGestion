import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;
import java.text.SimpleDateFormat;

public class Fenetre_gestionSalaire extends JFrame implements ActionListener{
    JButton FormBTN, MaxSalaireBTN, CloseBTN;
    JPanel ConteneurA, ConteneurB;
    private JTable tableauSalaire;
    private Form_ajoutSalaire F1;
    private Fenetre_MaxSalaire F2;

    public Fenetre_gestionSalaire(){
        setTitle("Gestionnaire des salaires");
        setSize(800, 600);
        setLocation(300, 80);

        ConteneurA = new JPanel();
        ConteneurA.setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 15));

        ConteneurB = new JPanel();
        ConteneurB.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 15));

        FormBTN = new JButton("MAJ salaires");
        FormBTN.addActionListener(this);
        ConteneurA.add(FormBTN);

        MaxSalaireBTN = new JButton("Salaire maximal");
        MaxSalaireBTN.addActionListener(this);
        ConteneurA.add(MaxSalaireBTN);

        CloseBTN = new JButton("Fermer la fenêtre");
        CloseBTN.addActionListener(this);
        ConteneurA.add(CloseBTN);


        


        getContentPane().add(ConteneurA, BorderLayout.NORTH);
        getContentPane().add(ConteneurB, BorderLayout.CENTER);

        try{
            
        
            String url = "jdbc:mysql://localhost:3306/bibliotheque_bd_ul";
            String user = "root";
            String password = "";
            Connection conn = DriverManager.getConnection(url, user, password);
    
            String querySalaire = "SELECT employe_bibliotheque.nom_employe_bibliotheque AS Nom, employe_bibliotheque.prenom_employe_bibliotheque AS Prénom," +
            "employes_salaires.salaire, employes_salaires.date_paiement AS Date FROM employes_salaires " +
            "JOIN employe_bibliotheque ON employes_salaires.id_employe_bibliotheque = employe_bibliotheque.id_employe_bibliotheque " +
            "ORDER BY employe_bibliotheque.id_employe_bibliotheque ";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(querySalaire);
    
            tableauSalaire = new JTable(buildTableModel(rs));
    
            JScrollPane scrollPane = new JScrollPane(tableauSalaire);
            
            JPanel ConteneurB = new JPanel();
            ConteneurB.setLayout(new BorderLayout());
            ConteneurB.add(scrollPane, BorderLayout.CENTER);
    
            getContentPane().add(ConteneurA, BorderLayout.NORTH);
            getContentPane().add(ConteneurB, BorderLayout.CENTER);
    
    
            conn.close();
    
            }catch(SQLException e){
                e.printStackTrace();
            }

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == FormBTN){
            Form_ajoutSalaire myForm_ajoutSalaire = new Form_ajoutSalaire();
        }

        if(e.getSource() == MaxSalaireBTN){
            Fenetre_MaxSalaire myFenetre_MaxSalaire = new Fenetre_MaxSalaire();
        }

        if(e.getSource() == CloseBTN){
            setVisible(false);
        }
    }


    public static DefaultTableModel buildTableModel(ResultSet rs) throws SQLException{
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();

        String[] columnNames = new String[columnCount];
        int versementColumnIndex = -1;

        for(int i = 0; i < columnCount; i++){
            String columnName = metaData.getColumnLabel(i + 1);
            if(columnName.equalsIgnoreCase("Date")){
                versementColumnIndex = i;
            }
            columnNames[i] = columnName;
        }

        Object[][] data = null;
        if(rs.last()){
            int rowCount = rs.getRow();
            rs.beforeFirst();
            data = new Object[rowCount][columnCount];
            int row = 0;

            SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");

            while(rs.next()){
                for(int i = 0; i < columnCount; i++){

                    if(i == versementColumnIndex && versementColumnIndex != -1){
                        data[row][i] = dateFormat.format(rs.getTimestamp(i + 1));
                    }else{
                        data[row][i] = rs.getObject(i + 1);
                    }
                }

                row++;
            }
        }

        return new DefaultTableModel(data, columnNames);
    }

}