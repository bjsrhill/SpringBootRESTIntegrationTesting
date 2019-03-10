package com.beverlyshill.steps;

import static org.junit.Assert.assertTrue;

import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BeverlyshillWebIndexSteps {
	
	
	public BeverlyshillWebIndexSteps(GlobalSteps globalSteps) {
		global = globalSteps;
	}
	
	String indexTitle = "";
	
	@Value("${indexPageTitle}")
	private String indexPageTitle;

	private boolean indexMenusBSHWeb = false;

	private GlobalSteps global;

	private boolean indexMenusPEWeb;
    
	@Given("^the web page displays$")
    public void the_web_page_displays() throws Exception {
    	indexTitle = global.getIndexPageTitleChrome();
    }
    
    @Then("^page title can be verified$")
    public void page_title_can_be_verified() throws Exception {
        assertTrue("The Index page title is incorrect.", indexTitle.equals(indexPageTitle));
    }
    
    @Then("^the Beverly S\\. Hill menu is found$")
    public void the_Beverly_S_Hill_menu_is_found() throws Exception {
    	indexMenusBSHWeb = global.getIndexMenusBSHChrome();
        assertTrue("The Beverly S. Hill menu item was not found.",indexMenusBSHWeb);
    }
    
    @Then("^the Professional Experience menu is found$")
    public void the_Professional_Experience_menu_is_found() throws Exception {
        indexMenusPEWeb = global.getIndexMenusProExpChrome();
        assertTrue("The Professional Experience menu item was not found.",indexMenusPEWeb);
        
    }


}
