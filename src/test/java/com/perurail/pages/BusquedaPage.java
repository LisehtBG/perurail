package com.perurail.pages;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.perurail.BaseWebDriver;
import com.perurail.entities.Busqueda;

public class BusquedaPage extends BaseWebDriver {

	By byDestinoSelect = By.id("destinoSelect");
	By byRutaSelect = By.id("rutaSelect");
	By byTrenSelect = By.id("cbTrenSelect");
	By bySalida = By.id("salida");	
	By byBuscar = By.name("frm_booking");	
	By byDatePickerNext = By.className("ui-datepicker-next");
	By byDatePickerCalendar = By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a");
	
		
	public BusquedaPage(WebDriver driver) {
		super(driver);
	}

	public void buscar(Busqueda busqueda) throws ParseException {

		selectedValue(busqueda.getDestino(), byDestinoSelect);
		selectedValue(busqueda.getRuta(), byRutaSelect);
		selectedValue(busqueda.getTren(), byTrenSelect);
		
		click(bySalida);
		
		String fecha_defecto = getValue(bySalida);
		String fecha_salida = busqueda.getFechaSalida();
		
		int meses = obtenerMesesDiferencia(fecha_defecto, fecha_salida);		

		for (int i = 0; i < meses; i++) {
			click(byDatePickerNext);
		}

		List<WebElement> diasSalida = findElements(byDatePickerCalendar);

		for (WebElement dia : diasSalida) {
			if (dia.getText().equals(fecha_salida.split("-")[0])) {
				dia.click();
				break;
			}
		}

		submit(byBuscar);
	}
	
	private int obtenerMesesDiferencia(String fechaInicio, String fechaFin) throws ParseException {

		Calendar inicio = new GregorianCalendar();
		Calendar fin = new GregorianCalendar();
		inicio.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(fechaInicio));
		fin.setTime(new SimpleDateFormat("dd-MM-yyyy").parse(fechaFin));
		int anios = fin.get(Calendar.YEAR) - inicio.get(Calendar.YEAR);
		int meses = anios * 12 + fin.get(Calendar.MONTH) - inicio.get(Calendar.MONTH);
		return meses;
	}
}
