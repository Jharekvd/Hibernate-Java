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
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}

	private static void agregarPelicula(Session session, Scanner sc) {
		try {

			System.out.println("Introduce el titulo de la nueva pelicula");
			sc.nextLine();
			String titulo = sc.nextLine();
			System.out.println("Introduce el añio de la pelicula " + titulo);
			String anio = sc.next();
			System.out.println("Introduce el genero de la pelicula " + titulo);
			sc.nextLine();
			String genero = sc.nextLine();
			System.out.println("Introduce el director");
			String nombreDirector = sc.nextLine();
			
			session.beginTransaction();
			// Añadir director
			Director director = new Director();
			director.setNombreDirector(nombreDirector);
			// Guardar el director
			session.persist(director);

			Pelicula pelicula = new Pelicula();
			pelicula.setTitulo(titulo);
			pelicula.setAnio(anio);
			pelicula.setGenero(genero);
			// Añadir el director a la pelicula
			pelicula.setDirector(director);
            // Agregar actores
            System.out.println("Introduce los nombres de los actores separados por ';':");
            String[] nombresActores = sc.nextLine().split(";");
            for (String nombreActor : nombresActores) {
                nombreActor = nombreActor.trim();
                if (!nombreActor.isEmpty()) {
                    Actor actor = new Actor();
                    actor.setNombreActor(nombreActor);
                    session.persist(actor);
                    pelicula.getListaActores().add(actor);
                }
            }
			// pelicula.setListaActores(pelicula.getListaActores());
			session.persist(pelicula);
			session.getTransaction().commit();
			System.out.println("Se añadio la pelicula");
		} catch (Exception e) {
			System.err.println("No se puso insetar los valores");
			e.printStackTrace();
			if (session.getTransaction() != null) {
				session.getTransaction().rollback();
			}
		}

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Session session= null;
		try {
			session = HibernateUtil.getSession();
			if (session.isOpen()) {
				System.out.println("Se pudo conectar a la base de datos");
				crudPeliculas(session);
			}
		} catch (Exception e) {
			// TODO: handle exception
			System.err.println("Fallo en el incio de session");
		} finally {
            if (session != null && session.isOpen()) {
                session.close();
                System.out.println("La sesión de Hibernate se cerró correctamente.");
            }
        }
	}

}