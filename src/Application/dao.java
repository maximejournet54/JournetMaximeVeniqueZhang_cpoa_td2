package Application;

public interface dao {
	public abstract static void create(Object T);
	
	public abstract static void delete(Object T);
	
	public abstract static void update(Object T);
	
	public abstract static void getById(int id);

	public abstract  static void afficher();


}
