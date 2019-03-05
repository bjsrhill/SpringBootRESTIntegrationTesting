package com.beverlyshill.steps;

import java.util.ArrayList;
import java.util.List;

import com.beverlyshill.Index;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import static org.junit.Assert.assertTrue;


public class BeverlyshillRESTIndexSteps extends SpringBootBaseIntegrationTest{
	
	ArrayList<String> indexMenusResponse = new ArrayList<String>();
	//Index index = new Index();
	ArrayList<String> expectedMenus = new ArrayList<String>();
	
	@Given("^the page displays$")
	public void the_page_displays() throws Exception {
	    indexMenusResponse = getMenus();
	}

	@Then("^menu items are found$")
	public void menu_items_are_found() throws Exception {
		//expectedMenus = index.getExpectedMenus();
		expectedMenus = getExpectedMenus();
		System.out.println("The index menus in steps is: " + indexMenusResponse.get(0).toString());
		System.out.println("The expectedMenus is: " + expectedMenus);
		assertTrue("The index menus are not correct.", indexMenusResponse.get(0).equals(expectedMenus.toString()));
	}

	
}
