package Application;

import java.sql.*;

public class Produit {
    private String id_produit;
    private String nom;
    private String description;
    private String tarif;
    private String visuel;
    private String id_categorie;
 
    public Produit(String id_produit, String nom, String description, String tarif, String visuel, String id_categorie) {
		this.id_produit = id_produit;
		this.nom = nom;
		this.description = description;
		this.tarif = tarif;
		this.visuel = visuel;
		this.id_categorie = id_categorie;
	}

	public static void create(Object T){
        try {
            Produit p=(Produit) T;
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="INSERT INTO Produit VALUES("+p.id_produit+","+p.nom+", "+p.description+","+p.tarif+","+p.visuel+", "+p.id_categorie+")";
            requete.executeUpdate(query);
            System.out.println("Produit ajoute");
        } catch(SQLException sqle){
            System.out.println("Pb select:" +sqle.getMessage());
        }
    }

    public static void delete(Object T){
        try {
            Produit p=(Produit) T;
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="delete from produit where id_produit="+p.id_produit;
            requete.executeUpdate(query);
            System.out.println("produit supprime");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
    }

    public static void update(Object T){
        try {
            Produit p=(Produit) T;
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="update from produit where id_produit="+p.id_produit;
            requete.executeUpdate(query);
            System.out.println("produit mis a jour");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
    }

    public static void AfficherProduit() {
        try {
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select * from Produit");
            while (res.next()) {
                String id = res.getString("id_produit");
                String nom = res.getString("nom");
                String description = res.getString("description");
                String tarif = res.getString("tarif");
                String visuel = res.getString("visuel");
                String id_categorie = res.getString("id_categorie");
                
                System.out.println(id);
                System.out.println(nom);
                System.out.println(description);
                System.out.println(tarif);
                System.out.println(visuel);
                System.out.println(id_categorie);

                System.out.println(new Produit( res.getString("id_produit"),
                res.getString("nom"),res.getString("description"),res.getString("tarif"),res.getString("visuel"),res.getString("id_categorie")));
                

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

