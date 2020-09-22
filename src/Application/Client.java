import java.sql.*;

public class Client {
    String id_client,nom,prenom,identifiant,mdp,num,voie,cp,ville,pays;

    public Client(String id_client, String nom, String prenom, String identifiant, String mdp, String num, String voie, String cp, String ville, String pays) {
        this.id_client = id_client;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.mdp = mdp;
        this.num = num;
        this.voie = voie;
        this.cp = cp;
        this.ville = ville;
        this.pays = pays;
    }

    @Override
    public String toString() {
        return "Client{" +
                "id_client='" + id_client + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", identifiant='" + identifiant + '\'' +
                ", mdp='" + mdp + '\'' +
                ", num='" + num + '\'' +
                ", voie='" + voie + '\'' +
                ", cp='" + cp + '\'' +
                ", ville='" + ville + '\'' +
                ", pays='" + pays + '\'' +
                '}';
    }

    public static void create(Object T){
        try {
            Client c = (Client) T;
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="INSERT INTO Client VALUES("+c.id_client+","+c.nom+","+c.prenom+","+c.mdp+","+c.num+","+c.voie+","+c.cp+","+c.ville+","+c.pays+")";
            requete.executeUpdate(query);
            System.out.println("Client ajoute");
            System.out.println("Client ajoute");
        } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }            
    }

    public static void delete(Object T){
        try {
            Client c = (Client) T;
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="delete from Client where id_client="+c.id_client;
            requete.executeUpdate(query);
            System.out.println("client supprime");
            } catch(SQLException sqle){
            System.out.println("Probleme select:" +sqle.getMessage());
        }          
    }

    public static void update(Object T){
        try {
            Client c = (Client) T;
            Connection laConnexion = Connexion.creeConnexion();
            Statement requete= laConnexion.createStatement();
            String query="update from Client where id_client="+c.id_client;
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
                System.out.println(new Client(res.getString("id_client"), res.getString("nom"), res.getString("prenom"), res.getString("identifiant"), res.getString("mot_de_passe"), res.getString("adr_numero"), res.getString("adr_voie"), res.getString("adr_code_postal"), res.getString("adr_ville"), res.getString("adr_pays")));
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
    

