package entities;

import java.io.Serializable;

public class Actor implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int idActor;
	private String nombreActor;

	public Actor() {
		super();
	}

	public Actor(int idActor, String nombreActor) {
		super();
		this.idActor = idActor;
		this.nombreActor = nombreActor;
	}

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

	@Override
	public String toString() {
		return "Actor [idActor=" + idActor + ", nombreActor=" + nombreActor + "]";
	}

}
