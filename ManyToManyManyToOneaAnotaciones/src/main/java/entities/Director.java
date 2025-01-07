package entities;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "directores")
public class Director {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_DIRECTOR")
    private int idDirector;

    @Column(name = "nombre_director", nullable = false)
    private String nombreDirector;
    // Relación bidireccional con Pelicula
    @OneToMany(mappedBy = "director", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Pelicula> peliculas;
    
    public Director() {
		super();
		this.peliculas = new HashSet<>();
	}

	public Director(int idDirector, String nombreDirector, Set<Pelicula> peliculas) {
		super();
		this.idDirector = idDirector;
		this.nombreDirector = nombreDirector;
		this.peliculas = peliculas;
	}

	public Set<Pelicula> getPeliculas() {
		return peliculas;
	}

	public void setPeliculas(Set<Pelicula> peliculas) {
		this.peliculas = peliculas;
	}

	// Getters and setters
    public int getIdDirector() {
        return idDirector;
    }

    public void setIdDirector(int idDirector) {
        this.idDirector = idDirector;
    }

    public String getNombreDirector() {
        return nombreDirector;
    }

    public void setNombreDirector(String nombreDirector) {
        this.nombreDirector = nombreDirector;
    }

	@Override
	public String toString() {
		return "Director idDirector: " + idDirector + ", nombreDirector:" + nombreDirector;
	}

    
}