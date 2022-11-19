package ar.edu.unlam.pb2;

import java.util.*;

public class Figurita implements Comparable <Figurita>{
	
	private Integer cod_figu;
	private TipoGrupo grupo;
	private String seleccion;
	private String nombreJugador;
	private Double valorJugador;
	private Estado estado;
	

	public Figurita(Integer cod_figu, TipoGrupo grupo, String seleccion, String nombreJugador, Double valorJugador,
			Estado estado) {
		super();
		this.cod_figu = cod_figu;
		this.grupo = grupo;
		this.seleccion = seleccion;
		this.nombreJugador = nombreJugador;
		this.valorJugador = valorJugador;
		this.estado = estado;
	}

	public String getSeleccion() {
		return seleccion;
	}

	public void setSeleccion(String seleccion) {
		this.seleccion = seleccion;
	}

	public Integer getCod_figu() {
		return cod_figu;
	}

	public void setCod_figu(Integer cod_figu) {
		this.cod_figu = cod_figu;
	}

	public TipoGrupo getGrupo() {
		return grupo;
	}

	public void setGrupo(TipoGrupo grupo) {
		this.grupo = grupo;
	}

	public String getNombreJugador() {
		return nombreJugador;
	}

	public void setNombreJugador(String nombreJugador) {
		this.nombreJugador = nombreJugador;
	}

	public Double getValorJugador() {
		return valorJugador;
	}

	public void setValorJugador(Double valorJugador) {
		this.valorJugador = valorJugador;
	}

	

	@Override
	public int hashCode() {
		return Objects.hash(cod_figu, estado, grupo, nombreJugador, seleccion, valorJugador);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Figurita other = (Figurita) obj;
		return Objects.equals(cod_figu, other.cod_figu) && estado == other.estado && grupo == other.grupo
				&& Objects.equals(nombreJugador, other.nombreJugador) && Objects.equals(seleccion, other.seleccion)
				&& Objects.equals(valorJugador, other.valorJugador);
	}

	@Override
	public int compareTo(Figurita o) {
		if(this.grupo.equals(o.grupo)) {
			if(this.seleccion.equals(o.seleccion)) {
				return this.cod_figu.compareTo(o.cod_figu);
			}return this.seleccion.compareTo(o.seleccion);
		} return this.grupo.compareTo(o.grupo);
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	
	
	
	

	
	
	

}
