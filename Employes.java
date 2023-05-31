public class Employes{
    protected String nom_employe_bibliotheque;
    protected String prenom_employe_bibliotheque;
  
    public Employes(String nom_employe_bibliotheque, String prenom_employe_bibliotheque){
        
        this.nom_employe_bibliotheque = nom_employe_bibliotheque;
        this.prenom_employe_bibliotheque = prenom_employe_bibliotheque;
        
    }

    public String getNom(){
        return nom_employe_bibliotheque;
    }

    public String getPrenom(){
        return prenom_employe_bibliotheque;
    }

    public String toString(){
        return nom_employe_bibliotheque + " " + prenom_employe_bibliotheque;
    }

}