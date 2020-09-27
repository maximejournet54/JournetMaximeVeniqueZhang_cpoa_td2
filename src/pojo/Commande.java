package Application;

import java.util.Date;
import java.sql.*;

public class Commande {
    int id_commande,id_client;
    Date date_commande;
	public Commande(int id_commande, Date date_commande, int id_client) {
		this.id_commande = id_commande;
		this.id_client = id_client;
		this.date_commande = date_commande;
    }

    public void setId(int id_commande) {
        this.id_commande = id_commande;
	}

	public int getId() {
		return id_commande;
	}
    
	@Override
	public String toString() {
		return "Commande [id_commande=" + id_commande + ", id_client=" + id_client + ", date_commande=" + date_commande
				+ "]";
	}
    
    public static void create(Object T){
        try {
            Commande c = (Commande) T;
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="INSERT INTO Commande VALUES("+c.id_commande+","+c.date_commande+","+c.id_client+")";
            requete.executeUpdate(query);
            System.out.println("Commande ajoutee");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }            
    }

    public static void delete(Object T){
        try {
            Commande c = (Commande) T;
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="delete from Commande where id_commande="+c.id_commande;
            requete.executeUpdate(query);
            System.out.println("commande supprimee");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }          
    }

    public static void update(Object T){
        try {
            Commande c = (Commande) T;
            Connection laConnexion=ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="update from Commande where id_commande="+c.id_commande;
            requete.executeUpdate(query);
            System.out.println("commande mis a jour");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }  
    }

    public static void AfficherCommande() {
        try {
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select * from Commande");
            while (res.next()) {
                System.out.println(new Commande(res.getInt("id_commande"), res.getDate("date_commande"), res.getInt("id_client")));
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