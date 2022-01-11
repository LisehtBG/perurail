package com.perurail;

import java.util.ArrayList;
import java.util.List;

import com.perurail.entities.Busqueda;
import com.perurail.entities.Cabina;
import com.perurail.entities.Pasajero;
import com.perurail.entities.Reserva;

public class Datos {

	public static Reserva get_datos_puno_cusco() {

		List<Pasajero> pasajeros = new ArrayList<Pasajero>();
		List<Cabina> cabinas = new ArrayList<Cabina>();
		
		Pasajero pasajero = null;
		Cabina cabina = null;

		pasajero = new Pasajero();
		pasajero.setMenor(false);
		pasajero.setApellidos("ALVARADO");
		pasajero.setNombres("FRANK");
		pasajero.setFechaNacimiento("15-8-2000");
		pasajero.setNacionalidad("PER");
		pasajero.setTipoDocumento("DNI");
		pasajero.setNumeroDocumento("78787878");
		pasajero.setSexo("M");
		pasajero.setTelefono("987456321");
		pasajero.setPromociones(true);
		pasajero.setEmail("frank@gmail.com");
		pasajeros.add(pasajero);

		pasajero = new Pasajero();
		pasajero.setMenor(false);
		pasajero.setApellidos("BACILIO");
		pasajero.setNombres("LISEHT");
		pasajero.setFechaNacimiento("16-6-2002");
		pasajero.setNacionalidad("PER");
		pasajero.setTipoDocumento("DNI");
		pasajero.setNumeroDocumento("54545454");
		pasajero.setSexo("F");
		pasajero.setTelefono("123456789");
		pasajero.setPromociones(true);
		pasajero.setEmail("liseht@gmail.com");
		pasajeros.add(pasajero);
		
		cabina = new Cabina();
		cabina.setNombre("SUITE CABINS");
		cabina.setPasajeros(pasajeros);	
		cabinas.add(cabina);

		Busqueda busqueda = new Busqueda();
		busqueda.setIdaVuelta(false);
		busqueda.setDestino("3");
		busqueda.setRuta("31");
		busqueda.setTren("2");
		busqueda.setFechaSalida("14-09-2022");
		busqueda.setFechaRegreso("28-09-2022");
		
		Reserva reserva = new Reserva();
		reserva.setBusqueda(busqueda);
		reserva.setCabinas(cabinas);

		return reserva;
	}
}
