package entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class Pelicula implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idPelicula;
	private String titulo;
	private String anio;
	private String genero;
	private Director director;
	private Set<Actor> listaActores;
	
	
	public Pelicula() {
		super();
		this.listaActores = new HashSet<Actor>();
	}


	public Pelicula(int idPelicula, String titulo, String anio, String genero, Director director,
			Set<Actor> listaActores) {
		super();
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


	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	@Override
	public String toString() {
		return "Pelicula [idPelicula=" + idPelicula + ", titulo=" + titulo + ", anio=" + anio + ", genero=" + genero
				+ ", director=" + director + ", listaActores=" + listaActores + "]";
	}
	
}
