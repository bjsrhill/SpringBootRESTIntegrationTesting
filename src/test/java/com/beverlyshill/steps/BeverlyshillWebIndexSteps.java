package com.beverlyshill.steps;

import static org.junit.Assert.assertTrue;

import static com.beverlyshill.steps.Index.getIndex;

import org.springframework.beans.factory.annotation.Value;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class BeverlyshillWebIndexSteps {
	
	private GlobalSteps global;
	
	private Index index = getIndex();
	
	public BeverlyshillWebIndexSteps(GlobalSteps globalSteps) {
		global = globalSteps;
	}
	
	String indexTitle = "";
	
	@Value("${indexPageTitle}")
	private String indexPageTitle;
    
	@Given("^the web page displays$")
    public void the_web_page_displays() throws Exception {
    	indexTitle = index.steps()
    			.getIndexPageTitleChrome();
    }
    
    @Then("^page title can be verified$")
    public void page_title_can_be_verified() throws Exception {
        assertTrue("The Index page title is incorrect.", indexTitle.equals(indexPageTitle));
    }
    
    @Then("^the Beverly S\\. Hill menu is found$")
    public void the_Beverly_S_Hill_menu_is_found() throws Exception {
    	index.steps();
		index
    	.verify()
    	.verifyIsDisplayed(StepsController.BSHMenu());
    }
    
    @Then("^the Professional Experience menu is found$")
    public void the_Professional_Experience_menu_is_found() throws Exception {
    	index.steps();
		index
    	.verify()
    	.verifyIsDisplayed(StepsController
        		.professionalExperienceMenu());
    }


}
