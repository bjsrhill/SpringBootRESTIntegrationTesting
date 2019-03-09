package com.beverlyshill.steps;

import static org.junit.Assert.assertTrue;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BeverlyshillWebIndexSteps extends SpringBootBaseIntegrationTest {
	
	@Before
    public void setup() {
    	setChromeWebDriverConfig();
    	getChromeDriver();
    }
    
    @After
    public void tearDown() {
    	closeChromeDriver();
    }
	
	String indexTitle = "";
	
	@Value("${indexPageTitle}")
	private String indexPageTitle;

	private boolean indexMenusBSHWeb = false;
	private boolean indexMenusProfessionalWeb = false;

	private Object indexMenusPEWeb;
    
	@Given("^the web page displays$")
    public void the_web_page_displays() throws Exception {
    	indexTitle = getIndexPageTitleChrome();
    }
    
    @Then("^page title can be verified$")
    public void page_title_can_be_verified() throws Exception {
        assertTrue("The Index page title is incorrect.", indexTitle.equals(indexPageTitle));
    }
    
    @Then("^the Beverly S\\. Hill menu is found$")
    public void the_Beverly_S_Hill_menu_is_found() throws Exception {
    	indexMenusBSHWeb = getIndexMenusBSHChrome();
        assertTrue("The Beverly S. Hill menu item was not found.",indexMenusBSHWeb);
    }
    
    @Then("^the Professional Experience menu is found$")
    public void the_Professional_Experience_menu_is_found() throws Exception {
        indexMenusPEWeb = getIndexMenusProExpChrome();
        
    }


}
