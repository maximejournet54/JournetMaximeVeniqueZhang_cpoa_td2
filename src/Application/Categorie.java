package Application;

import java.sql.*;

public class Categorie {
    
    public static void add(int id_client, String nom , String prenom){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="INSERT INTO Categorie VALUES("+id_client+",'"+nom+"', '"+prenom+"')";
            requete.executeUpdate(query);
            System.out.println("Ligne de categorie ajoutee");
        } catch(SQLException sqle){
            System.out.println("Pb select:" +sqle.getMessage());
        }
    }

    public static void delete(int id_categorie){
    	try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="delete from categorie where id_categorie="+id_categorie;
            requete.executeUpdate(query);
            System.out.println("categorie supprimee");
        	} catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
            }  
        }

    public static void update(int id_categorie){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="update from categorie";
            requete.executeUpdate(query);
            System.out.println("Ligne de categorie mise a jour");
        	} catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        	}  
    }
    public static void AfficherCategorie() {
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select id_categorie, titre, visuel from Categorie");
            while (res.next()) {
                String id = res.getString("id_categorie");
                String titre=res.getString("titre");
                String visuel=res.getString("visuel");
                System.out.println(id);
                System.out.println(titre);
                System.out.println(visuel);
                
            }


            if (res != null)
                res.close();
            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb dans select " + sqle.getMessage());
        }

    }

}


