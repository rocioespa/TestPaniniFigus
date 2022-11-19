package ar.edu.unlam.pb2;

import java.util.*;

public class Sistema {

	private Set<Usuario> usuarios;

	public Sistema() {
		super();
		this.usuarios = new HashSet<>();
	}

	public void agregarUsuario(Usuario u) throws Exception {
		if (usuarios.contains(u)) {

			throw new Exception();
		}
		this.usuarios.add(u);

	}

	public Set<Usuario> getUsuarios() {
		return usuarios;
	}

	public void setUsuarios(Set<Usuario> usuarios) {
		this.usuarios = usuarios;
	}

}
