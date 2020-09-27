package main;

import java.util.Scanner;

import pojo.Categorie;
import pojo.Client;
import pojo.Commande;
import pojo.LigneCommande;
import pojo.Produit;

import java.util.Date;

import java.text.SimpleDateFormat;
import java.text.DateFormat;
import java.text.ParseException;

public class Main {
    public static void main(String[] args) throws ParseException {
    int id_categorie=0;
    int id_client=0;
    int id_produit=0;
    int id_commande=0;
    String date_commande=null;
    
    System.out.println("faites un choix: 1=Categorie, 2=Client, 3=Produit, 4=Commande, 5=LigneCommande");
    Scanner sc=new Scanner(System.in);
    sc.useDelimiter("");
    int i=sc.nextInt();
   
    if(i==1) {
        System.out.println("choisissez une action: 1= Ajouter, 2= Supprimer, 3= Mettre a jour");
       int choix=sc.nextInt();
        if (choix==1) {
            System.out.println("Saisir id_categorie, titre et visuel");
            id_categorie=sc.nextInt();
            String titre=sc.next();
            String visuel=sc.next();
            Categorie.create(id_categorie);
        }
        if (choix==2) {
            System.out.println("Saisir id_categorie");
            System.out.println("Saisir id_categorie");
            id_categorie=sc.nextInt();
            Categorie.delete(id_categorie);
        }
        if (choix==3) {
            System.out.println("Saisir id_categorie");
            id_categorie=sc.nextInt();
            Categorie.update(id_categorie);
        }
    }   
        
    else if(i==2) {
        System.out.println("choisissez une action: 1= Ajouter, 2= Supprimer, 3=Mettre a jour");
        int choix2=sc.nextInt();
        if(choix2==1){
            System.out.println("Saisir id_client, nom, prenom, identifiant, mdp, numero de rue, rue, cp, ville,pays");
            id_client=sc.nextInt();
            String nom=sc.next();
            String prenom=sc.next();
            Client.create(id_client);
        }
            
        if (choix2==2) {
            System.out.println("Saisir id_client");
            id_client=sc.nextInt();
            Client.delete(id_client);
        }
            
        if (choix2==3) {
            System.out.println("Saisir id_client");
            id_client=sc.nextInt();
            Client.update(id_client);
        }
    }
        
    else if(i==3) {
        System.out.println("choisissez une action: 1= Ajouter, 2= Supprimer, 3=Mettre a jour");
        int choix3=sc.nextInt();
        if(choix3==1){
            System.out.println("Saisir id_produit, nom, description, tarif, visuel, id_categorie");
            id_produit=sc.nextInt();
            String nom=sc.next();
            String prenom=sc.next();
            String description=sc.next();
            int tarif=sc.nextInt();
            String visuel=sc.next();
            int id_categorie2=sc.nextInt(); 
            Produit.create(id_produit);
        }
            
        if (choix3==2) {
            System.out.println("Saisir id_produit");
            id_produit=sc.nextInt();
            Client.delete(id_produit);
        }
            
        if (choix3==3) {
            System.out.println("Saisir id_client");
            id_produit=sc.nextInt();
            Client.update(id_produit);
        }               
    }

    else if(i==4) {
        System.out.println("choisissez une action: 1= Ajouter, 2= Supprimer, 3= Mettre a jour");
        int choix4=sc.nextInt();
        if (choix4==1) {
            System.out.println("Saisir id_commande, date en format JJ/MM/AAAA et id_client");
            id_commande=sc.nextInt();
            DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
            Date date = formatter.parse(date_commande); 
            String visuel=sc.next();
            Commande.create(id_categorie);
        }
        if (choix4==2) {
            System.out.println("Saisir id_commande");
            id_commande=sc.nextInt();
            Commande.delete(id_commande);
        }
        if (choix4==3) {
            System.out.println("Saisir id_commande");
            id_commande=sc.nextInt();
            Commande.update(id_commande);
        }
    }   
    
    else if(i==5) {
        System.out.println("choisissez une action: 1= Ajouter, 2= Supprimer, 3= Mettre a jour");
        int choix5=sc.nextInt();
        if (choix5==1) {
            System.out.println("Saisir id_commande, id_produit, quantite et tarif_unitaire");
            int id_commande2=sc.nextInt();
            int id_produit2=sc.nextInt();
            int qte=sc.nextInt();
            double tarif=sc.nextDouble();
            LigneCommande.create(id_commande);
        }
        if (choix5==2) {
            System.out.println("Saisir id_commande");
            id_commande=sc.nextInt();
            LigneCommande.delete(id_commande);
        }
        if (choix5==3) {
            System.out.println("Saisir id_commande");
            id_commande=sc.nextInt();
            LigneCommande.update(id_commande);
        }
    }  

}
}


