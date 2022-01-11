package com.perurail;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class BaseWebDriver {

	private WebDriver driver;

	public BaseWebDriver() {
	}

	public BaseWebDriver(WebDriver driver) {
		this.driver = driver;
	}

	public WebDriver connectionDriver() {
		//descomentar para windows
		//System.setProperty("webdriver.chrome.driver", "./src/test/resources/drivers/chromedriver.exe");
		driver = new ChromeDriver();
		return driver;
	}

	public WebDriver getDriver() {
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}

	public WebElement findElement(WebElement element, By locator) {
		return element.findElement(locator);
	}

	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}

	public List<WebElement> findElements(WebElement element, By locator) {
		return element.findElements(locator);
	}

	public String getText(WebElement element) {
		return element.getText();
	}

	public String getText(By locator) {
		return findElement(locator).getText();
	}

	public String getValue(By locator) {
		return findElement(locator).getAttribute("value");
	}

	public String getValue(WebElement element) {
		return element.getAttribute("value");
	}

	public void sendText(String text, By locator) {
		findElement(locator).sendKeys(text);
	}
	
	public void sendText(String text, WebElement element) {
		element.sendKeys(text);
	}

	public void selectedValue(String value, By locator) {
		Select select = new Select(findElement(locator));
		select.selectByValue(value);
	}
	
	public void selectedValue(String value, WebElement element, By locator) {
		Select select = new Select(element.findElement(locator));
		select.selectByValue(value);
	}

	public String getSelectedValue(By locator) {
		Select select = new Select(findElement(locator));
		WebElement opcionRuta = select.getFirstSelectedOption();
		return opcionRuta.getAttribute("value");
	}

	public void click(By locator) {
		findElement(locator).click();
	}

	public void click(WebElement element) {
		element.click();
	}

	public void submit(By locator) {
		findElement(locator).submit();
	}

	public void submit(WebElement element) {
		element.submit();
	}

	public void visit(WebDriver driver, String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

	public void visit(String url) {
		driver.manage().window().maximize();
		driver.get(url);
	}

}
