package com.beverlyshill.steps;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * 
 * @author beverlyshill
 * 
 * Step definition class for Index.feature
 *
 */
public class BeverlyshillRESTIndexSteps extends SpringBootBaseIntegrationTest{
	
	ArrayList<String> indexMenusResponse = new ArrayList<String>();
	ArrayList<String> expectedMenus = new ArrayList<String>();
	
	@Given("^the page displays$")
	public void the_page_displays() throws Exception {
	    indexMenusResponse = getMenus();
	}

	@Then("^menu items are found$")
	public void menu_items_are_found() throws Exception {
		expectedMenus = getExpectedMenus();
		assertTrue("The index menus are not correct.", indexMenusResponse.get(0).equals(expectedMenus.toString()));
	}

}
