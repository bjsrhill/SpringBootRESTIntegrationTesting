package com.beverlyshill.utils;

import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

import com.beverlyshill.steps.GlobalSteps;

/**
 * Controller for the step definition classes
 * This class handles interaction with Selenium
 * and the web pages
 * 
 * @author beverlyshill
 *
 */
public class StepsController {
	
static GlobalSteps global;

	private String hostName;
	
	/**
	 * Static factory method to 
	 * instantiate a StepsController
	 * 
	 * @param globalSteps a GlobalSteps object
	 * 
	 * @return a StepsController class
	 */
	public static StepsController getStepsController(GlobalSteps globalSteps) {
		global = globalSteps;
		return new StepsController();
	}
	
	/**
	 * 
	 * Gets the URL of the web application
	 * Index page
	 * 
	 * @return a String representing the tested web
	 * application Index page URL
	 */
	public String getIndexURL() {
		return global.indexURL();
	}
	
	/**
	 * 
	 * Gets the title of the tested web
	 * application's Index page
	 * 
	 * @return a String representing the
	 * web application Index page title
	 */
	public String getIndexPageTitleChrome() {
		getChromeDriver().get(global.getHostName());
		return getChromeDriver().getTitle();
	}
	
	/**
	 * Gets the menus of the tested web
	 * application's Index page using 
	 * the Spring Boot RestTemplate
	 * 
	 * @return and Array of Strings representing
	 * the web application's Index page menus
	 */
	public ArrayList<String> getMenus() {
    	ResponseEntity<String> resp = global.getRestTemplate().getForEntity(global.indexURL(), String.class);
    	ArrayList<String> webMenus = new ArrayList<String>();
    	webMenus.add(resp.getBody());
    	return webMenus;
    }
	
	/**
	 * Gets the home menu WebElement xpath of the tested
	 * web application's Index page
	 * 
	 * @return a By xpath value of the home menu web element
	 */
	public static By BSHMenu() {
		return By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[1]/a");
	}
	
	/**
	 * Gets the professional experience menu 
	 * WebElement xpath of the tested
	 * web application's Index page
	 * 
	 * @return a By xpath value of the professional
	 * experience menu web element
	 */
	public static By professionalExperienceMenu() {
		return By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[2]/a");	
	}
	
	/**
	 * Gets the expected menus for the tested web
	 * application's Index page using 
	 * the Spring Boot RestTemplate
	 * 
	 * @return and Array of Strings representing
	 * the web application's expected Index 
	 * page menus
	 */
	public ArrayList<String> getExpectedMenus() {
		String output = "\"" + StringUtils.arrayToDelimitedString(global.getListOfStrings() , "\",\"") + '"';
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(output);
		return expected;
	}

}
