package com.beverlyshill.steps;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import junit.framework.Assert;

public class BeverlyshillWebIndexSteps {
	
	private GlobalSteps global;
	
	private Index index;
	
	public BeverlyshillWebIndexSteps(GlobalSteps globalSteps) {
		global = globalSteps;
		index = Index.getIndex(globalSteps);
	}
	
	String indexTitle = "";
	
	@Value("${indexPageTitle}")
	private String indexPageTitle;

	private boolean indexMenusBSHWeb = false;

	private boolean indexMenusPEWeb;
    
	@Given("^the web page displays$")
    public void the_web_page_displays() throws Exception {
    	indexTitle = index.getIndexPageTitleChrome();
    }
    
    @Then("^page title can be verified$")
    public void page_title_can_be_verified() throws Exception {
        assertTrue("The Index page title is incorrect.", indexTitle.equals(indexPageTitle));
    }
    
    @Then("^the Beverly S\\. Hill menu is found$")
    public void the_Beverly_S_Hill_menu_is_found() throws Exception {
    	index.verifyIsDisplayed(index.BSHMenu());
    }
    
    @Then("^the Professional Experience menu is found$")
    public void the_Professional_Experience_menu_is_found() throws Exception {
        index.verifyIsDisplayed(index.professionalExperienceMenu());
    }


}
