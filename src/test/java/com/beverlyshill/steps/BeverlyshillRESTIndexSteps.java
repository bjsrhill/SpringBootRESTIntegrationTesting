package com.beverlyshill.steps;

import static com.beverlyshill.utils.StepsController.getStepsController;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import com.beverlyshill.utils.StepsController;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

/**
 * 
 * @author beverlyshill
 * 
 * Step definition class for Index.feature
 *
 */
public class BeverlyshillRESTIndexSteps {
	
	private GlobalSteps global;
	
	private StepsController stepsController;
	
	/**
	 * Class constructor
	 * 
	 * @param globalSteps GlobalSteps class
	 */
	public BeverlyshillRESTIndexSteps(GlobalSteps globalSteps) {
		global = globalSteps;
		stepsController = getStepsController(global);
	}
	
	ArrayList<String> indexMenusResponse = new ArrayList<String>();
	ArrayList<String> expectedMenus = new ArrayList<String>();
	
	@Given("^the page displays$")
	public void the_page_displays() throws Exception {
	    indexMenusResponse = stepsController.getMenus();
	}

	@Then("^menu items are found$")
	public void menu_items_are_found() throws Exception {
		expectedMenus = stepsController.getExpectedMenus();
		assertTrue("The index menus are not correct.", indexMenusResponse.get(0).equals(expectedMenus.toString()));
	}

}
