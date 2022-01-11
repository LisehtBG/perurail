package com.perurail.pages;

import java.text.ParseException;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perurail.BaseWebDriver;
import com.perurail.entities.Cabina;
import com.perurail.entities.Pasajero;

public class PasajerosPage extends BaseWebDriver {

	By byContinuar = By.id("btnContinuarPas");
	By byCalendario = By.id("ui-datepicker-div");

	By byEmail = By.className("email");
	By byNumeroDoc = By.className("numero_doc");
	By byCelular = By.className("mobile-number");
	By byEmailConf = By.className("email_conf");
	By byName = By.className("name");
	By byLastname = By.className("lastname");
	By byCalendarYear = By.className("calendaryear");
	By byMes = By.className("ui-datepicker-month");
	By byAnio = By.className("ui-datepicker-year");
	By byTituloPasajero = By.className("title-pasajero");
	By byDatosPasajero = By.className("datos-pasajero");
	By byTituloAcordion = By.className("accordion-title-item");
	By byContenidoAcordion = By.className("accordion-content-item");

	By byCalendar = By.xpath("table[@class='ui-datepicker-calendar']/tbody/tr/td/a");
	By byDatosPasajeroBae = By.xpath("//form[@id='datos-pasajeros-bae']/div[@id='divpadre']");
	By byDivDatosPasajero = By.xpath("div/div[@class='datos-pasajero']/div");
	By byNacion = By.xpath("select[starts-with(@name,'sel_nacion')]");
	By byTipoDoc = By.xpath("select[starts-with(@name,'sel_tpdoc')]");
	By bySexo = By.xpath("select[starts-with(@name,'sel_sexo')]");
	By byOfertas = By.xpath("label/input[starts-with(@name,'chk_ofertas')]");

	public PasajerosPage(WebDriver driver) {
		super(driver);
	}

	public void cargarDatos(List<Cabina> cabinas) throws ParseException, InterruptedException {
		List<WebElement> elementCabinas = findElements(byDatosPasajeroBae);

		int i = 0;

		for (WebElement elementCabina : elementCabinas) {

			String style = findElement(elementCabina, byDatosPasajero).getAttribute("style");

			if (!style.contains("block")) {
				click(byTituloPasajero);
			}

			List<WebElement> elementPasajeros = findElements(elementCabina, byDivDatosPasajero);

			List<Pasajero> pasajeros = cabinas.get(i).getPasajeros();

			int j = 0;

			for (WebElement elementPasajero : elementPasajeros) {

				Pasajero pasajero = pasajeros.get(j);

				WebElement elementContenido = findElement(elementPasajero, byContenidoAcordion);
				style = elementContenido.getAttribute("style");

				if (!style.contains("block")) {
					click(findElement(elementPasajero, byTituloAcordion));
				}

				sendText(pasajero.getNombres(), findElement(elementContenido, byName));
				sendText(pasajero.getApellidos(), findElement(elementContenido, byLastname));

				click(findElement(elementContenido, byCalendarYear));

				String[] fecha = pasajero.getFechaNacimiento().split("-");

				WebElement calendar = findElement(byCalendario);
				selectedValue(fecha[1], calendar, byMes);
				selectedValue(fecha[2], calendar, byAnio);

				for (WebElement dia : findElements(calendar, byCalendar)) {
					if (getText(dia).equals(fecha[0])) {
						click(dia);
						break;
					}
				}

				selectedValue(pasajero.getNacionalidad(), elementContenido, byNacion);
				selectedValue(pasajero.getTipoDocumento(), elementContenido, byTipoDoc);
				sendText(pasajero.getNumeroDocumento(), findElement(elementContenido, byNumeroDoc));
				selectedValue(pasajero.getSexo(), elementContenido, bySexo);

				sendText(pasajero.getTelefono(), findElement(elementContenido, byCelular));
				click(findElement(elementContenido, byOfertas));

				sendText(pasajero.getEmail(), findElement(elementContenido, byEmail));
				sendText(pasajero.getEmail(), findElement(elementContenido, byEmailConf));

				Thread.sleep(2000);
				j++;
			}

			Thread.sleep(1000);
			i++;
		}

		click(byContinuar);
	}
}
