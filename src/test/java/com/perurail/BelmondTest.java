package com.perurail;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import com.perurail.entities.Cabina;
import com.perurail.entities.Reserva;
import com.perurail.pages.BusquedaPage;
import com.perurail.pages.CabinasPage;
import com.perurail.pages.ComfirmacionPage;
import com.perurail.pages.PasajerosPage;

public class BelmondTest {

	private WebDriver driver;
	private BaseWebDriver baseWebDriver;
	private BusquedaPage busqueda;
	private CabinasPage cabinas;
	private PasajerosPage pasajeos;
	private ComfirmacionPage confirmacion;
	Reserva reserva;

	@Before
	public void setUp() {
		baseWebDriver = new BaseWebDriver();
		driver = baseWebDriver.connectionDriver();

		busqueda = new BusquedaPage(driver);
		cabinas = new CabinasPage(driver);
		pasajeos = new PasajerosPage(driver);
		confirmacion = new ComfirmacionPage(driver);
		
		baseWebDriver.visit(driver, "https://www.perurail.com/es/");
	}

	@Test
	public void realizarBusqueda() {

		try {
			reserva = Datos.get_datos_puno_cusco();

			busqueda.buscar(reserva.getBusqueda());
			cabinas.seleccionar(reserva.getCabinas());

			int numeroCabinas = reserva.getCabinas().size();
			int numeroPasajeros = 0;

			for (Cabina cabina : reserva.getCabinas()) {
				numeroPasajeros += cabina.getPasajeros().size();
			}

			String totalCabinas = cabinas.obtenerTotalCabinas();
			String totalPasajeros = cabinas.obtenerTotalPasajeros();

			assertTrue(cabinas.validarPrecioDolares());
			assertTrue(totalCabinas.equals(String.valueOf(numeroCabinas)));
			assertTrue(totalPasajeros.equals(String.valueOf(numeroPasajeros)));

			cabinas.continuar();
			pasajeos.cargarDatos(reserva.getCabinas());
			confirmacion.cargarDatos();

			assertTrue(true);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			assertFalse(true);
		}
	}

	@After
	public void tearDown() {
		try {
			Thread.sleep(3000);
			driver.quit();
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
}
