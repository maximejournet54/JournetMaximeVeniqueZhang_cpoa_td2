package Application;

import java.sql.*;

public class Produit {
    public static void add(int id_produit, String nom, String description, double tarif, String visuel, int id_categorie){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="INSERT INTO produit VALUES("+id_produit+",'"+nom+"','"+description+"','"+tarif+"', '"+visuel+"', '"+id_categorie+"')";
            requete.executeUpdate(query);
            System.out.println("Produit ajoute");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
    }

    public static void delete(int id_produit){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="delete from produit where id_produit="+id_produit;
            requete.executeUpdate(query);
            System.out.println("produit supprime");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
            }  
    }

    public static void update(int id_produit){
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="update from produit where id_produit="+id_produit;
            requete.executeUpdate(query);
            System.out.println("produit mis a jour");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }  
    }

    public static void AfficherProduit() {
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select id_produit, id_produit from Produit");
            while (res.next()) {
                String nom = res.getString("id_produit");
                System.out.println(nom);
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

