package com.beverlyshill.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

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
