package com.beverlyshill.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BeverlyshillWebIndexSteps extends SpringBootBaseIntegrationTest {
	
	String indexTitle = "";
	
	@Value("${indexPageTitle}")
	private String indexPageTitle;

	private String indexTitleH;

    @Before
    public void setup() {
    	setChromeWebDriverConfig();
    	getChromeDriver();
    }
    
    @Given("^the web page displays$")
    public void the_web_page_displays() throws Exception {
    	indexTitle = getIndexPageTitleChrome();
    }
    
    @Then("^page title can be verified$")
    public void page_title_can_be_verified() throws Exception {
        assertTrue("The Index page title is incorrect.", indexTitle.equals(indexPageTitle));
    }


}
