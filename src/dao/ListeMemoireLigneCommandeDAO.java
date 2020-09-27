package dao;

import java.util.ArrayList;
import java.util.List;

import pojo.LigneCommande;

public class ListeMemoireLigneCommandeDAO extends MYSQLLigneCommandeDAO{
    private static ListeMemoireLigneCommandeDAO instance;
	private List<LigneCommande> donnees;

	public static  ListeMemoireLigneCommandeDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireLigneCommandeDAO();
		}
		return instance;
	}

	private ListeMemoireLigneCommandeDAO() {
		this.donnees = new ArrayList<LigneCommande>();
		this.donnees.add(new LigneCommande(10, 3, 2, 5.3));
		this.donnees.add(new LigneCommande(11, 4, 6, 3.2));
	}

	public boolean create(LigneCommande objet) {
		objet.setId(3);
		// Ne fonctionne que si l'objet métier est bien fait...
		while (this.donnees.contains(objet)) {
			objet.setId(objet.getId() + 1);
		}
		boolean ok = this.donnees.add(objet);
		return ok;
	}

	public boolean update(LigneCommande objet) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'une ligne de commande inexistante");
		} else {
			this.donnees.set(idx, objet);
		}
		return true;
	}

	public boolean delete(LigneCommande objet) {
		LigneCommande supprime;
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(objet);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'une ligne de commande inexistante");
		} else {
			supprime = this.donnees.remove(idx);
		}
		return objet.equals(supprime);
	}

	public LigneCommande getById(int id) {
		// Ne fonctionne que si l'objet métier est bien fait...
		int idx = this.donnees.indexOf(new LigneCommande(id, 15, 3, 5.0));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucune ligne de commande ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	public ArrayList<LigneCommande> findAll() {
		return (ArrayList<LigneCommande>) this.donnees;
	} 
}
