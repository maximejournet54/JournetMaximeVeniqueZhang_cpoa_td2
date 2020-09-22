package Application;

import java.sql.*;

public class MYSQLClientDAO {
    public String getNom(int id_client){
        //mettre requete sql
        String nom=null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select nom from client where id_client="+id_client;
            ResultSet res=requete.executeQuery(query);
            visuel= res.getString("nom");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
        return nom;
    }
    public String getPrenom(int id_client){
        //mettre requete sql
        String prenom=null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select prenom from client where id_client="+id_client;
            ResultSet res=requete.executeQuery(query);
            visuel= res.getString("prenom");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
        return prenom;
    }


    public String getAdress(int id_client){
        //mettre requete sql
        String adresse=null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select num,voie,cp,ville,pays from client where id_client="+id_client;
            ResultSet res=requete.executeQuery(query);
            adresse= res.getString("num")+res.getString("voie")+
            res.getString("cp")+
            res.getString("ville")+res.getString("pays");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
        return adresse;
    }
}
    

