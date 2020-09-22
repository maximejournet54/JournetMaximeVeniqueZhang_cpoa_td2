package Application;
import java.beans.Expression;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MYSQLClientDAO implements DAO<Client>{

    @Override
    public boolean create(Object T) {
        try {
<<<<<<< HEAD
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select nom from client where id_client="+id_client;
            ResultSet res=requete.executeQuery(query);
            nom= res.getString("nom");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
=======
            Client.create(T);
            return true;

        }catch (Exception e){
            return false;
>>>>>>> 53fa57723edaf7a2be0cbe34bf4a7f6c1dd20f72
        }
    }

    @Override
    public boolean delete(Object T) {
        try {
<<<<<<< HEAD
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select prenom from client where id_client="+id_client;
            ResultSet res=requete.executeQuery(query);
            prenom= res.getString("prenom");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
=======
            Client.delete(T);
            return true;

        }catch (Exception e){
            return false;
>>>>>>> 53fa57723edaf7a2be0cbe34bf4a7f6c1dd20f72
        }
    }

    @Override
    public boolean update(Object T) {
        try {
            Client.update(T);
            return true;

        }catch (Exception e){
            return false;
        }
    }

    @Override
    public Client getById(int id_client) {
        try {
<<<<<<< HEAD
            Connection laConnexion = ConnexionMYSQL.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="select num,voie,cp,ville,pays from client where id_client="+id_client;
            ResultSet res=requete.executeQuery(query);
            adresse= res.getString("num")+res.getString("voie")+
            res.getString("cp")+
            res.getString("ville")+res.getString("pays");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
=======
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete = laConnexion.createStatement();
            ResultSet res = requete.executeQuery("select * from Client where id_client ="+id_client);
            while (res.next()) {
                String id =res.getString("id_client");
                String nom=res.getString("nom");
                String prenom=res.getString("prenom");
                String identifiant=res.getString("identifiant");
                String mdp=res.getString("mot_de_passe");
                String num=res.getString("adr_numero");
                String voie=res.getString("adr_voie");
                String cp=res.getString("adr_code_postal");
                String ville=res.getString("adr_ville");
                String pays=res.getString("adr_pays");
                return new Client(id,nom,prenom,identifiant,mdp,num,voie,cp,ville,pays);

            }


            if (res != null)
                res.close();
            if (requete != null)
                requete.close();
            if (laConnexion != null)
                laConnexion.close();

        } catch (SQLException sqle) {
            System.out.println("Pb dans select " + sqle.getMessage());
>>>>>>> 53fa57723edaf7a2be0cbe34bf4a7f6c1dd20f72
        }
        return null;
    }
}
