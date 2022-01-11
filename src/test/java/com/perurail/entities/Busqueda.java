package com.perurail.entities;

public class Busqueda {
	private boolean idaVuelta;
	private String destino;
	private String ruta;
	private String tren;
	private String fechaSalida;
	private String fechaRegreso;

	public boolean isIdaVuelta() {
		return idaVuelta;
	}

	public void setIdaVuelta(boolean idaVuelta) {
		this.idaVuelta = idaVuelta;
	}

	public String getDestino() {
		return destino;
	}

	public void setDestino(String destino) {
		this.destino = destino;
	}

	public String getRuta() {
		return ruta;
	}

	public void setRuta(String ruta) {
		this.ruta = ruta;
	}

	public String getTren() {
		return tren;
	}

	public void setTren(String tren) {
		this.tren = tren;
	}

	public String getFechaSalida() {
		return fechaSalida;
	}

	public void setFechaSalida(String fechaSalida) {
		this.fechaSalida = fechaSalida;
	}

	public String getFechaRegreso() {
		return fechaRegreso;
	}

	public void setFechaRegreso(String fechaRegreso) {
		this.fechaRegreso = fechaRegreso;
	}

}
