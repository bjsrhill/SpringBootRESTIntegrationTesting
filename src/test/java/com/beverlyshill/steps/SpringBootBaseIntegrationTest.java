package com.beverlyshill.steps;

import static com.beverlyshill.utils.WebDriverFactory.closeChromeDriver;
import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;

import java.util.ArrayList;

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
public abstract class SpringBootBaseIntegrationTest {
	
	@Value("${hostName}")
	private String hostName;

	@Value("${indexEndpoint}")
	private String indexEndpoint;
	
	@Value("${listOfStrings}")
	private String [] listOfStrings;

	private RestTemplate restTemplate;

	private WebDriver chromeDriver = getChromeDriver();
        
    public SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }

    public String indexEndpoint() {
        return hostName + indexEndpoint;
    }
    
	public void setChromeWebDriverConfig() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	}
	
	public WebDriver getWebDriverChrome() {
		return chromeDriver;
	}
	
	public void chromeDriverClose() {
		closeChromeDriver();
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public RestTemplate getRestTemplate() {
		return restTemplate;
	}
	
	public String[] getListOfStrings() {
		return listOfStrings;
	}

}
