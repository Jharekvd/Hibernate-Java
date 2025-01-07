package entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	private static SessionFactory sessionFactory;
	// Singleton que asegura que solo haya una instanacia de sessionFactory
	static {
		try {
			// Cargamos la condiguracion de hibernate
			Configuration configuration = new Configuration().configure();
			sessionFactory = configuration.buildSessionFactory();
		} catch (Exception e) {
			// Manejamos el error en caso de que de fallo durante la creacion de
			// sessionFactory
			System.err.println("Session Factory fallo en la creacion: " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	//Metodo para obtener una nueva session
	public static Session getSession() {
		return getSessionFactory().openSession();
	}
	//Metodo para cerrar la sesion
	public static void closeSession() {
		if(sessionFactory!=null) {
			sessionFactory.close();
		}
	}
}
