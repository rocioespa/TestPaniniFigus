package ar.edu.unlam.pb2;

import java.util.*;

public abstract class Usuario {
	
	private Integer idUsuario;
	

	public Usuario(Integer idUsuario) {
		super();
		this.idUsuario = idUsuario;
		
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	
	public abstract void agregarFigurita(Figurita figuritaDelMundial) throws NoSePudoAgregarException;
	public abstract void sacarFigurita(Figurita figuritaDelMundial);

	@Override
	public int hashCode() {
		return Objects.hash(idUsuario);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(idUsuario, other.idUsuario);
	}
	
	
	

}
