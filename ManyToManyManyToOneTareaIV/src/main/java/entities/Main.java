package entities;

import java.util.Scanner;

import org.hibernate.Session;

public class Main {
	private static void crudPeliculas(Session session) {
		Scanner sc = new Scanner(System.in);
		int op = 2;
		try {
			do {
				System.out.println("1)Agregar pelicula (Pelicula,Director,actores)");
				System.out.println("2)Salir");
				op = Integer.parseInt(sc.next());
				switch (op) {
				case 1:
					agregarPelicula(session, sc);
					break;
				case 2:
					System.out.println("Saliste del programa.............");
					break;
				default:
					System.out.println("No hay valores asignados");
					break;
				}
			} while (op != 2);
		} catch (Exception e) {
			System.err.println("Fallo en el crud " + e.getMessage());
			throw new ExceptionInInitializerError(e);
		} finally {
			sc.close();
		}
	}

	private static void agregarPelicula(Session session, Scanner sc) {
		try {
			String titulo,anio,genero,nombreDirector;
			System.out.println("Introduce el titulo de la nueva pelicula");
			sc.nextLine();
			titulo = sc.nextLine();
			System.out.println("Introduce el añio de la pelicula "+titulo);
			anio = sc.next();
			System.out.println("Introduce el genero de la pelicula "+titulo);
			sc.nextLine();
			genero = sc.nextLine();
			
			session.beginTransaction();
			Pelicula pelicula = new Pelicula();
			pelicula.setTitulo(titulo);
			pelicula.setAnio(anio);
			pelicula.setGenero(genero);
			//Añadir director
			Director director = new Director();
			System.out.println("Introduce el director");
			nombreDirector=sc.nextLine();
			director.setNombreDirector(nombreDirector);
			//Guardar el director
			session.persist	(director);
			//Añadir el director a la pelicula
			pelicula.setDirector(director);
			//Ahora lista de actores
			System.out.println("Ingrese a actores separados por(;)");
			String[]nombreDeActores = sc.nextLine().split(";");
			for (String nombreActor : nombreDeActores) {
				Actor actor = new Actor();
				actor.setNombreActor(nombreActor.trim());
				session.persist(actor);
				pelicula.getListaActores().add(actor);
			}
			//pelicula.setListaActores(pelicula.getListaActores());
			session.persist(pelicula);		
			session.getTransaction().commit();
			System.out.println("Se añadio la pelicula");
		}catch (Exception e) {
			System.err.println("No se puso insetar los valores");
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Session session = HibernateUtil.getSession();
			if (session.isOpen()) {
				System.out.println("Se pudo conectar a la base de datos");
				crudPeliculas(session);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Fallo en el incio de session");
		}
	}

}
