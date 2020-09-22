package Application;

import java.sql.*;

public class MYSQLProduitDAO {

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription(int id_produit) {
        String description =null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select description  from produit where id_produit="+id_produit;
            ResultSet res=requete.executeQuery(query); description = res.getString("description");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
        return description ;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getVisuel(int id_produit) {
        String visuel=null;
        try {
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select visuel from produit where id_produit="+id_produit;
            ResultSet res=requete.executeQuery(query);
            visuel= res.getString("visuel");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }
        return visuel;
    }


    public void setVisuel(String visuel) {
        this.visuel = visuel;
    }

    public double getTarif() {
        return tarif;
    }

    public void setTarif(double tarif) {
        this.tarif = tarif;
    }

    public int getId_categorie() {
        return id_categorie;
    }

    public void setId_categorie(int id_categorie) {
        this.id_categorie = id_categorie;
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

