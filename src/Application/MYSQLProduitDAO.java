package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLProduitDAO implements DAO<Produit>{
    @Override
    public boolean create(Object T) {
        try {
            Produit.create(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Object T) {
        try {
            Produit.delete(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Object T) {
        try {
            Produit.update(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Produit getById(int id_produit) {
        try {
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select id_produit, nom, description, tarif, visuel, id_categorie from Produit where id_produit ="+id_produit);
            while (res.next()) {
                String id =res.getString("id_produit");
                String nom=res.getString("nom");
                String description=res.getString("description");
                String tarif=res.getString("tarif");
                String visuel=res.getString("visuel");
                String id_categorie=res.getString("id_categorie");

                return new Produit(id,nom,description,tarif, visuel,id_categorie);

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
        return null;
    }
    
}

