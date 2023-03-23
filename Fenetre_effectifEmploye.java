import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class Fenetre_effectifEmploye extends JFrame implements ActionListener{
    JLabel Jl;
    JButton FormBTN, CloseBTN;
    JPanel Conteneur1, Conteneur2;
    private Form_ajoutEmploye F1;
    
    public Fenetre_effectifEmploye(){
        setTitle("Gestion des employés");
        setSize(800, 600);
        setLocation(300, 80);
        setLayout(new GridLayout(10, 12));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        FormBTN = new JButton("Enregistrer \rdes employes");
        FormBTN.addActionListener(this);
        this.add(FormBTN);

        CloseBTN = new JButton("Fermer la fenetre");
        CloseBTN.addActionListener(this);
        this.add(CloseBTN);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e){
        if(e.getSource() == FormBTN){
            Form_ajoutEmploye myForm_ajoutEmploye = new Form_ajoutEmploye();
        }

        if(e.getSource() == CloseBTN){
            setVisible(false);
        }
    }
}