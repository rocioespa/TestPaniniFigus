package ar.edu.unlam.pb2;

import java.util.*;

public class Administrador extends Usuario{

	private Set <Figurita> figuritaParaComercializar = new TreeSet();
	
	public Administrador(Integer idUsuario) {
		super(idUsuario);
		
	}

	@Override
	public void agregarFigurita(Figurita fm) throws NoSePudoAgregarException {
		if(figuritaParaComercializar.contains(fm)) {
			 throw new NoSePudoAgregarException("El administrador no puede dar de alta figuritas con el mismo codigo");
		}
		this.figuritaParaComercializar.add(fm);
		
	}

	@Override
	public void sacarFigurita(Figurita fm) {
		this.figuritaParaComercializar.remove(fm);
		
	}

	public Set<Figurita> getFiguritaParaComercializar() {
		return figuritaParaComercializar;
	}

	public void setFiguritaParaComercializar(Set<Figurita> figuritaParaComercializar) {
		this.figuritaParaComercializar = figuritaParaComercializar;
	}

	
	
	
	

}
