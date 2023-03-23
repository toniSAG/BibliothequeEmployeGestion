import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.LinkedList;

public class Fenetre_gestionSalaire extends JFrame{
    JButton CloseBTN;
    JPanel Conteneur;

    public Fenetre_gestionSalaire(){
        setTitle("Gestionnaire des salaires");
        setSize(800, 600);
        setLocation(300, 80);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setVisible(true);
    }
} 