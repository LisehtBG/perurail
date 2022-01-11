package com.perurail.pages;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perurail.BaseWebDriver;
import com.perurail.entities.Cabina;

public class CabinasPage extends BaseWebDriver {

	By byContinuar = By.id("continuar_bae");
	By byRoom = By.className("room");
	By bySelectRoom = By.className("selectRooms");
	By byCabinas = By.xpath(
			"//form[@id='frm_viajes_bae']/div[@class='section-cabina']/div[@class='contenido-cabina']/div[@class='box-cabina']");
	By byDetalleCabina = By.xpath("div[@class='detalle-cabina']/h3");

	By byDescripcionTren = By.xpath("//form[@id='frm_viajes_bae']/div[@class='section-descripcion']/div/h2");
	By byRuta = By.xpath("//form[@id='frm_viajes_bae']/div[@class='section-descripcion']/div/h3");

	By byResumenCompra = By.xpath("//section[@id='compra']/a");
	
	By byTotalCabinas = By.id("totalCABINS");
	By byTotalPasajeros = By.id("totalPASSENGER");
	By byPrecioDolares = By.id("priceUSD");
	By byPrecioSoles = By.id("pricePEN");

	By byPrecioDolaresDesc = By.id("priceUSDrc");

	public CabinasPage(WebDriver driver) {
		super(driver);
	}

	public void seleccionar(List<Cabina> cabinas) throws InterruptedException {

		List<WebElement> elementcabinas = findElements(byCabinas);

		for (WebElement elementCabina : elementcabinas) {

			String nombreCabina = getText(findElement(elementCabina, byDetalleCabina));

			List<Cabina> filtroCabinas = cabinas.stream().filter(x -> x.getNombre().equals(nombreCabina))
					.collect(Collectors.toList());

			if (filtroCabinas.size() > 0) {

				selectedValue(String.valueOf(filtroCabinas.size()), bySelectRoom);

				int i = 0;
				for (Cabina cabina : filtroCabinas) {
					i++;

					long cantidadAdultos = cabina.getPasajeros().stream().filter(x -> !x.isMenor()).count();
					long cantidadMenores = cabina.getPasajeros().stream().filter(x -> x.isMenor()).count();

					cantidadAdultos = cantidadAdultos > 2 ? 2 : cantidadAdultos;
					selectedValue(String.valueOf(cantidadAdultos), By.className("baeRoomAdult" + String.valueOf(i)));

					if (cantidadAdultos != 2) {
						cantidadMenores = cantidadMenores > 0 ? 2 - cantidadAdultos : cantidadMenores;
						selectedValue(String.valueOf(cantidadMenores),
								By.className("baeRoomChild" + String.valueOf(i)));
					}

					Thread.sleep(500);
				}
			}
		}
		
		click(byResumenCompra);
		Thread.sleep(2000);
	}

	public void continuar() throws InterruptedException {
		click(byResumenCompra);
		click(byContinuar);
	}

	public boolean validarPrecioDolares() {

		String precioDolares = getText(byPrecioDolares);
		String precioDolaresDesc = getText(byPrecioDolaresDesc);
		
		return precioDolares.equals(precioDolaresDesc);
	}

	public String obtenerTotalCabinas() {
		return getText(byTotalCabinas);
	}

	public String obtenerTotalPasajeros() {
		return getText(byTotalPasajeros);
	}
}
