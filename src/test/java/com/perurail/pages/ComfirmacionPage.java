package com.perurail.pages;

import java.text.ParseException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import com.perurail.BaseWebDriver;

public class ComfirmacionPage extends BaseWebDriver {

	By byVisa = By.id("visa");
	By byTerminos = By.id("chk_tercon");
	
	public ComfirmacionPage(WebDriver driver) {
		super(driver);
	}

	public void cargarDatos() throws InterruptedException {

		Thread.sleep(2000);

		click(byVisa);
		click(byTerminos);		
	}
}
