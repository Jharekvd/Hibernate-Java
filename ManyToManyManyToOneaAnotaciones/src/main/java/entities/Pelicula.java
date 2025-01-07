package entities;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "pelicula")
public class Pelicula implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPelicula")
	private int idPelicula;

	@Column(name = "titulo", nullable = false)
	private String titulo;

	@Column(name = "anio_Estreno", nullable = false)
	private String anio;

	@Column(name = "genero", nullable = false)
	private String genero;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "D_idDirector", referencedColumnName = "ID_DIRECTOR")
	private Director director;

	@ManyToMany(cascade = CascadeType.ALL) // Guarda automáticamente los actores
	@JoinTable(name = "pelicula_actores", joinColumns = @JoinColumn(name = "P_idPelicula"), inverseJoinColumns = @JoinColumn(name = "A_idActor"))
	private Set<Actor> listaActores;

	public Pelicula() {
		this.listaActores = new HashSet<>();
	}

	public Pelicula(int idPelicula, String titulo, String anio, String genero, Director director,
			Set<Actor> listaActores) {
		this.idPelicula = idPelicula;
		this.titulo = titulo;
		this.anio = anio;
		this.genero = genero;
		this.director = director;
		this.listaActores = listaActores;
	}

	public int getIdPelicula() {
		return idPelicula;
	}

	public void setIdPelicula(int idPelicula) {
		this.idPelicula = idPelicula;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getAnio() {
		return anio;
	}

	public void setAnio(String anio) {
		this.anio = anio;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Director getDirector() {
		return director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public Set<Actor> getListaActores() {
		return listaActores;
	}

	public void setListaActores(Set<Actor> listaActores) {
		this.listaActores = listaActores;
	}

	/*
	 * @Override public String toString() { return "Pelicula [idPelicula=" +
	 * idPelicula + ", titulo=" + titulo + ", anio=" + anio + ", genero=" + genero +
	 * ", director=" + director + ", listaActores=" + listaActores + "]"; }
	 */

	@Override
	public String toString() {
		return "Pelicula idPelicula: " + idPelicula + ", titulo: " + titulo + ", anio:" + anio + ", genero: " + genero
				+ ", director: " + (director != null ? director.getNombreDirector() : "sin director")
				+ ", listaActores.size: " + listaActores.size();
	}

}