import java.awt.*;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.event.*;
import java.util.LinkedList;

public class FenetreAcceuil_gestionEmploye extends JFrame implements ActionListener{
    JButton Employes, Temps, Salaire, CloseBTN;
    JPanel Conteneur;
    private Fenetre_effectifEmploye F1;
    private Fenetre_gestionTemps F2;
    private Fenetre_gestionSalaire F3;

    public FenetreAcceuil_gestionEmploye(){

        setTitle("Gestionnaire du personnel");
        setSize(800, 600);
        setLocation(300, 80);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Employes = new JButton("Employes de la bibliotheque");
        Employes.setBounds(295, 220, 200, 50);
        Employes.addActionListener(this);

        Temps = new JButton("Temps des employés");
        Temps.setBounds(295, 300, 200, 50);
        Temps.addActionListener(this);

        Salaire = new JButton("Salaire des employés");
        Salaire.setBounds(295, 380, 200, 50);
        Salaire.addActionListener(this);

        CloseBTN = new JButton("Fermer la fenêtre");
        CloseBTN.setBounds(295, 460, 200, 50);
        CloseBTN.addActionListener(this);

        Conteneur = new JPanel();
        Conteneur.setLayout(null);
        Conteneur.setBounds(0, 0, 795, 600);
        Conteneur.add(Employes);
        Conteneur.add(Temps);
        Conteneur.add(Salaire);
        Conteneur.add(CloseBTN);
        add(Conteneur);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent i){
    
        if(i.getSource() == Employes){
            Fenetre_effectifEmploye maFenetre_effectifEmploye = new Fenetre_effectifEmploye();
        }
    
        if(i.getSource() == Temps){
            Fenetre_gestionTemps maFenetre_gestionTemps = new Fenetre_gestionTemps();
        }

        if(i.getSource() == Salaire){
            Fenetre_gestionSalaire maFenetre_gestionSalaire = new Fenetre_gestionSalaire();
        }

        if(i.getSource() == CloseBTN){
            setVisible(false);
        }
    
    }
}