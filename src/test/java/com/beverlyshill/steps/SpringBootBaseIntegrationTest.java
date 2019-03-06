package com.beverlyshill.steps;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

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
	
	@Value("${listOfStrings}")
	private String [] listOfStrings;
	private WebDriver chromeDriver;
	
	@Value("${hostName}")
	private String hostName;
	
	@Value("${indexEndpoint}")
	private String indexEndpoint;
	
    private RestTemplate restTemplate;
    
    public SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }

    private String indexEndpoint() {
        return hostName + indexEndpoint;
    }
    
    public ArrayList<String> getMenus() {
    	System.out.println("The listOfStrings is: " + listOfStrings);
    	ResponseEntity<String> resp = restTemplate.getForEntity(indexEndpoint(), String.class);
    	ArrayList<String> webMenus = new ArrayList<String>();
    	webMenus.add(resp.getBody());
    	return webMenus;
    }
    	
	public ArrayList<String> getExpectedMenus() {
		String output = "\"" + StringUtils.arrayToDelimitedString(listOfStrings , "\",\"") + '"';
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(output);
		return expected;
	}
	
	public void setChromeWebDriverConfig() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	}
	
	public WebDriver getChromeDriver() {
		chromeDriver = new ChromeDriver();
		return chromeDriver;
	}
	
	public String getIndexPageTitleChrome() {
		chromeDriver.get(hostName);
		return chromeDriver.getTitle();
	}
}
