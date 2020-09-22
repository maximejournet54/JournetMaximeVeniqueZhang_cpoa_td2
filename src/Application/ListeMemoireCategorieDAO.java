package Application;

import java.util.ArrayList;
import java.util.List;


public class ListeMemoireCategorieDAO implements MYSQLCategorieDAO {

	private static ListeMemoireCategorieDAO instance;

	private List<Categorie> donnees;


	public static ListeMemoireCategorieDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireCategorieDAO();
		}

		return instance;
	}

	private ListeMemoireCategorieDAO() {

		this.donnees = new ArrayList<Categorie>();
	}


	@Override
	public ArrayList<Categorie> findAll() {
		return (ArrayList<Categorie>) this.donnees;
	}
}

