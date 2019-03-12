package com.beverlyshill.utils;

import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;
import static org.junit.Assert.assertTrue;

import org.openqa.selenium.By;

import com.beverlyshill.steps.GlobalSteps;

/**
 * 
 * Controller for verifications in the 
 * step definition classes
 *  
 * @author beverlyshill
 *
 */
public class VerifyController {
	
	private static GlobalSteps global;
	
	private VerifyController() {
		
	}
	
	/**
	 * Static factory method to 
	 * instantiate a VerifyController
	 * 
	 * @param globalSteps a GlobalSteps object
	 * 
	 * @return the VerifyController class
	 * 
	 */
	public static VerifyController getVerifyController(GlobalSteps globalSteps) {
		global = globalSteps;
		return new VerifyController();
	}
	
	/**
	 * 
	 * Method that verifies that a 
	 * WebElement is displayed on a web
	 * page
	 * 
	 * @param element a WebElement
	 * 
	 * @return teh VerifyController class
	 * verifyIsDisplayed method
	 * 
	 */
	public VerifyController verifyIsDisplayed(By element) {
		assertTrue(getChromeDriver().findElement(element).isDisplayed());
		return this;
	}

}
