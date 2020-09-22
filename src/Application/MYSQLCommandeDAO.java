package Application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class MYSQLCommandeDAO implements DAO<Commande>{

    @Override
    public boolean create(Object T) {
        try {
            Commande.create(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean delete(Object T) {
        try {
            Commande.delete(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public boolean update(Object T) {
        try {
            Commande.update(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Commande getById(int id_commande) {
        try {
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select id_commande, date_commande, id_client from Commande where id_commande ="+id_commande);
            while (res.next()) {
                String id =res.getString("id_commande");
                Date date= res.getDate("date_commande");
                String id_client=res.getString("id_client");

                return new Commande(id, date, id_client);
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
