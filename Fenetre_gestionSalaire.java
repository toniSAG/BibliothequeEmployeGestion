import com.toedter.calendar.JDateChooser;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.util.*;
import java.sql.*;

public class Fenetre_gestionSalaire extends JFrame implements ActionListener{
    JButton FormBTN, CloseBTN;
    JPanel ConteneurA, ConteneurB;
    private Form_ajoutSalaire F1;

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

        CloseBTN = new JButton("Fermer la fenêtre");
        CloseBTN.addActionListener(this);
        ConteneurA.add(CloseBTN);


        


        getContentPane().add(ConteneurA, BorderLayout.NORTH);
        getContentPane().add(ConteneurB, BorderLayout.CENTER);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == FormBTN){
            Form_ajoutSalaire myForm_ajoutSalaire = new Form_ajoutSalaire();
        }

        if(e.getSource() == CloseBTN){
            setVisible(false);
        }
    }
}