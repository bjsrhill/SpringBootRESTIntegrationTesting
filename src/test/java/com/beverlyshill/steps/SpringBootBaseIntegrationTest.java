package com.beverlyshill.steps;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import cucumber.api.java.Before;


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
    
    private WebDriverWait wait;
    
    private static boolean dunit = false;
    
    protected SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }

    protected String indexEndpoint() {
        return hostName + indexEndpoint;
    }
    
    protected ArrayList<String> getMenus() {
    	System.out.println("The listOfStrings is: " + listOfStrings);
    	ResponseEntity<String> resp = restTemplate.getForEntity(indexEndpoint(), String.class);
    	ArrayList<String> webMenus = new ArrayList<String>();
    	webMenus.add(resp.getBody());
    	return webMenus;
    }
    	
	protected ArrayList<String> getExpectedMenus() {
		String output = "\"" + StringUtils.arrayToDelimitedString(listOfStrings , "\",\"") + '"';
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(output);
		return expected;
	}
	
	protected void setChromeWebDriverConfig() {
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
	}
	
	protected WebDriver getChromeDriver() {
		chromeDriver = new ChromeDriver();
		chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(chromeDriver, 5);
		return chromeDriver;
	}
	
	protected String getIndexPageTitleChrome() {
		chromeDriver.get(hostName);
		return chromeDriver.getTitle();
	}
	
	protected boolean getIndexMenusBSHChrome() {
		return chromeDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[1]/a")).isDisplayed();
	}
	
	protected Object getIndexMenusProExpChrome() {
		chromeDriver.get(hostName);
		return chromeDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[2]/a")).isDisplayed();
	}
	
	protected void closeChromeDriver() {
		chromeDriver.close();
		
	}

}
