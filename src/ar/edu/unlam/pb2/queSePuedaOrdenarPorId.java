package ar.edu.unlam.pb2;

import java.util.Comparator;

public class queSePuedaOrdenarPorId implements Comparator<Figurita>{

	@Override
	public int compare(Figurita o1, Figurita o2) {
		if(o1.getSeleccion().compareTo(o2.getSeleccion()) == 0) {
			return o1.getCod_figu().compareTo(o2.getCod_figu());
		}else {
			return o1.getSeleccion().compareTo(o2.getSeleccion());
		}
		
	}

}
