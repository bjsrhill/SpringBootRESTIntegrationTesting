package com.beverlyshill.steps;

import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

public class VerifyController {
	
	VerifyController(GlobalSteps globalSteps) {
		
	}
	
	public VerifyController verifyIsDisplayed(By element) {
		assertTrue(getChromeDriver().findElement(element).isDisplayed());
		return this;
	}

}
