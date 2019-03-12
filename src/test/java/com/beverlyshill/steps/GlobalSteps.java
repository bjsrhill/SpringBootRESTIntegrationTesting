package com.beverlyshill.steps;

import com.beverlyshill.utils.SpringBootBaseIntegrationTest;

import cucumber.api.java.After;
import cucumber.api.java.Before;

/**
 * 
 * Class containing global test methods and extension of
 * the SpringBootBaseIntegrationTest base class
 * 
 * @author beverlyshill
 *
 */
public class GlobalSteps extends SpringBootBaseIntegrationTest {
	
	@Before
    public void setup() {
    	setChromeWebDriverConfig();
    	getWebDriverChrome();
    }
    
    @After
    public void tearDown() {
    	chromeDriverClose();
    }

}
