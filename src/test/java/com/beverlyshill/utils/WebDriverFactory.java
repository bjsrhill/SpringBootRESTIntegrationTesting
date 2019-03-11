package com.beverlyshill.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverFactory {
	
	private static WebDriver chromeDriver;
	private static WebDriverWait wait;
	
	private WebDriverFactory() {
		
	}
	
	public static WebDriver getChromeDriver() {
		if(chromeDriver == null) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
			chromeDriver = new ChromeDriver();
			chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait = new WebDriverWait(chromeDriver, 5);
		}
		return chromeDriver;
	}
	
	public static WebDriverWait getWebDriverWait() {
		if(wait == null) {
			wait = new WebDriverWait(getChromeDriver(), 5);
		}
		return wait;
	}
	
	public static void closeChromeDriver() {
		if(!(chromeDriver == null)) {
			chromeDriver.close();
			chromeDriver = null;
		}
	}

}
