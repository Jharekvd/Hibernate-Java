package entities;

import java.io.Serializable;

public class Director implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idDirector;
	private String nombreDirector;
	
	public Director() {
		super();
	}

	public Director(int idDirector, String nombreDirector) {
		super();
		this.idDirector = idDirector;
		this.nombreDirector = nombreDirector;
	}

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
		return "Director [idDirector=" + idDirector + ", nombreDirector=" + nombreDirector + "]";
	}
	
}
