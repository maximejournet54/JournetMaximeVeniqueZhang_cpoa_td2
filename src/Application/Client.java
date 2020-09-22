package Application;

import java.sql.*;

public class Client {
    public static void add(int id_client, String nom, String prenom, String mdp, int num, String voie, int cp, String ville, String pays){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="INSERT INTO Client VALUES("+id_client+",'"+nom+"','"+prenom+"','"+mdp+"','"+num+"','"+voie+"','"+cp+"','"+ville+"','"+pays+"')";
            requete.executeUpdate(query);
            System.out.println("Produit ajoute");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }            
    }

    public static void delete(int id_client){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="delete from Client where id_client="+id_client;
            requete.executeUpdate(query);
            System.out.println("client supprime");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }          
    }

    public static void update(int id_client){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="update from Client where id_client="+id_client;
            requete.executeUpdate(query);
            System.out.println("client mis a jour");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }  
    }
    public static void AfficherClient() {
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select * from Client");
            while (res.next()) {
                String id = res.getString("id_client");
                String nom = res.getString("nom");
                String prenom = res.getString("prenom");
                System.out.println(id);
                System.out.println(nom);
                System.out.println(prenom);
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
    

