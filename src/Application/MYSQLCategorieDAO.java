package Application;

import java.sql.*;

public class MYSQLCategorieDAO implements dao{
    public String getTitre(int id_categorie){
        //mettre requete sql
        String titre=null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select titre from categorie where id_categorie="+id_categorie;
            ResultSet res=requete.executeQuery(query);
                titre= res.getString("titre");      
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }      
        return titre;     
    }
    public String getVisuel(int id_categorie){
        //mettre requete sql
        String visuel=null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select visuel from categorie where id_categorie="+id_categorie;
            ResultSet res=requete.executeQuery(query);
            visuel= res.getString("titre");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
        return visuel;
    }
}


