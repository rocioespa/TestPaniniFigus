package ar.edu.unlam.pb2;

import java.util.*;

public class UsuarioFinal extends Usuario{
	
	private List<Figurita> figuritiasEnElStock; //puede tener repetidas
	private Set <Figurita> albumDeFiguritas;

	public UsuarioFinal(Integer idUsuario) {
		super(idUsuario);
		this.figuritiasEnElStock = new ArrayList<>();
		this.albumDeFiguritas= new HashSet<>();
	}

	@Override
	public void agregarFigurita(Figurita fm) {
		this.figuritiasEnElStock.add(fm);
		
	}



	@Override
	public void sacarFigurita(Figurita fm) {
		this.figuritiasEnElStock.remove(fm);
		
	}


	public List<Figurita> getFiguritiasEnElStock() {
		return figuritiasEnElStock;
	}

	public void setFiguritiasEnElStock(List<Figurita> figuritiasEnElStock) {
		this.figuritiasEnElStock = figuritiasEnElStock;
	}

	public Set<Figurita> getAlbumDeFiguritas() {
		return albumDeFiguritas;
	}

	public void setAlbumDeFiguritas(Set<Figurita> albumDeFiguritas) {
		this.albumDeFiguritas = albumDeFiguritas;
	}

	public void pegarFigu(Figurita f) throws YaFuePegada, NoSeEncontroLaFigurita {
		if(buscarFiguritaEnElStock(f)) {
			if(albumDeFiguritas.contains(f) || f.getEstado() == Estado.pegada) {
				throw new YaFuePegada("Figurita ya pegada en el album");
			}else {
				this.albumDeFiguritas.add(f);
				f.setEstado(Estado.pegada);
				sacarFigurita(f); //pego la figurita y la saco de la lista
			}
			
		} 
		
	}
	
	
	public Boolean buscarFiguritaEnElStock(Figurita f) throws NoSeEncontroLaFigurita {
		if(figuritiasEnElStock.contains(f)) {
			return true;
		}
		throw new NoSeEncontroLaFigurita("El usuario no contiene esta figurita en su stock");
	}
	
	
	public Boolean buscarsiElAdministradorCreoLaFiguritaYAgregarFigu(Set<Figurita> figuritaParaComercializar, Figurita f) throws NoSePudoAgregarException {
		if(figuritaParaComercializar.contains(f)) {
			agregarFigurita(f);
			return true;
		}
		throw new NoSePudoAgregarException("El administrador no dio de alta la figurita");
	
		
	}

	public void cambiarFiguritaConOtroUsuarioFinal(UsuarioFinal uf, UsuarioFinal uf2, Figurita figuUsuario1, Figurita figuUsuario2) throws NoSeEncontroLaFigurita, YaFuePegada {
		if(uf.buscarFiguritaEnElStock(figuUsuario1) && uf2.buscarFiguritaEnElStock(figuUsuario2)) {
			if(figuUsuario1.getEstado() == Estado.sinPegar && figuUsuario2.getEstado() == Estado.sinPegar) {
				uf.sacarFigurita(figuUsuario1);
				uf.agregarFigurita(figuUsuario2);
				uf2.sacarFigurita(figuUsuario2);
				uf2.agregarFigurita(figuUsuario1);
			}else {
				throw new YaFuePegada("Esta figurita ya esta pegada en el album, no se puede cambiar");
			}
			
		}
		
	}





		
	
	
	

}
