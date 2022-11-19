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

	public void pegarFigu(Figurita f) throws YaFuePegada, NoSeEncontroLaFiguritaEnElStock {
		if(figuritiasEnElStock.contains(f)) {
			if(albumDeFiguritas.contains(f) && f.getEstado() == Estado.pegada) {
				throw new YaFuePegada("Figurita ya pegada en el album");
			}else {
				this.albumDeFiguritas.add(f);
				f.setEstado(Estado.pegada);
				figuritiasEnElStock.remove(f);
			}
			
		} else{
			throw new NoSeEncontroLaFiguritaEnElStock();
		}
		
	}

	public void figuritsValida(Set<Figurita> figuritas, Figurita f) throws NoSePudoAgregarException {
		for (Figurita figurita : figuritas) {
			if(figurita.getCod_figu().equals(f.getCod_figu())) {
				agregarFigurita(f);
				break;
			}
			throw new NoSePudoAgregarException("El administrador no dio de alta la figurita");
		} 
		
	}





		
	
	
	

}
