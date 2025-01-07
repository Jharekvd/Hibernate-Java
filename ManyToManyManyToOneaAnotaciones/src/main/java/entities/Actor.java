package entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "actores")
public class Actor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ACTOR")
    private int idActor;

    @Column(name = "nombre_actor", nullable = true)
    private String nombreActor;

    // Relación bidireccional con Pelicula
    @ManyToMany(mappedBy = "listaActores")
    private Set<Pelicula> peliculas;
    
    public Actor() {
		super();
		this.peliculas = new HashSet<>();
	}

	public Actor(int idActor, String nombreActor, Set<Pelicula> peliculas) {
		super();
		this.idActor = idActor;
		this.nombreActor = nombreActor;
		this.peliculas = peliculas;
	}

	// Getters and setters
    public int getIdActor() {
        return idActor;
    }

    public void setIdActor(int idActor) {
        this.idActor = idActor;
    }

    public String getNombreActor() {
        return nombreActor;
    }

    public void setNombreActor(String nombreActor) {
        this.nombreActor = nombreActor;
    }

	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	@Override
	public String toString() {
		return "Actor idActor: " + idActor + ", nombreActor: " + nombreActor;
	}
    
}
