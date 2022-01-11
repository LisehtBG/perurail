package com.perurail.entities;

import java.util.List;

public class Reserva {
	private Busqueda busqueda;
	private List<Cabina> cabinas;
	private Cabina tren;

	public Busqueda getBusqueda() {
		return busqueda;
	}

	public void setBusqueda(Busqueda busqueda) {
		this.busqueda = busqueda;
	}

	public List<Cabina> getCabinas() {
		return cabinas;
	}

	public void setCabinas(List<Cabina> cabinas) {
		this.cabinas = cabinas;
	}

	public Cabina getTren() {
		return tren;
	}

	public void setTren(Cabina tren) {
		this.tren = tren;
	}

}
