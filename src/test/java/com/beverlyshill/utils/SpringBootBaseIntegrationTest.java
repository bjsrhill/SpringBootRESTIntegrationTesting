package com.beverlyshill.utils;

import static com.beverlyshill.utils.WebDriverFactory.closeChromeDriver;
import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)

/**
 * 
 * @author beverlyshill
 *
 * Base class that handles all of the access to the website
 * and configuring/invoking the Selenium WebDriver
 * 
 */
public class SpringBootBaseIntegrationTest {
	
	@Value("${hostName}")
	private String hostName;

	@Value("${indexEndpoint}")
	private String indexEndpoint;
	
	@Value("${listOfStrings}")
	private String [] listOfStrings;

	private RestTemplate restTemplate = new RestTemplate();

	private WebDriver chromeDriver = getChromeDriver();

	/**
	 * 
	 * Gets the Index page URL
	 * 
	 * @return a String representing the 
	 * Index page URL
	 */
    public String indexURL() {
        return hostName + indexEndpoint;
    }
    
    /**
     * Sets a configuration for a Chrome
     * Selenium WebDriver
     */
	public void setChromeWebDriverConfig() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	}
	
	/**
	 * Gets a Chrome WebDriver
	 *  
	 * @return a Chrome Selenium WebDriver
	 */
	public WebDriver getWebDriverChrome() {
		return chromeDriver;
	}
	
	/**
	 * Closes a Chrome WebDriver
	 */
	public void chromeDriverClose() {
		closeChromeDriver();
	}
	
	/**
	 * Gets the web application 
	 * host name
	 * 
	 * @return a String representing 
	 * the web application host name
	 */
	public String getHostName() {
		return hostName;
	}
	
	/**
	 * Get a Spring Boot RestTemplate
	 * 
	 * @return a RestTemplate object
	 */
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	/**
	 * Get the expected list of menu items
	 * for web application
	 * 
	 * @return a String Array representing the list
	 * of menu itmes for the web application being
	 * tested
	 */
	public String[] getListOfStrings() {
		return listOfStrings;
	}

}
