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
	private static WebDriver chromeDriver;
	
	@Value("${hostName}")
	private String hostName;
	
	@Value("${indexEndpoint}")
	private String indexEndpoint;
	
    private RestTemplate restTemplate;
    
    private static WebDriverWait wait;
    
    public SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }

    public String indexEndpoint() {
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
	
	public static WebDriver getChromeDriver() {
		if(chromeDriver == null) {
			chromeDriver = new ChromeDriver();
			chromeDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			wait = new WebDriverWait(chromeDriver, 5);
		}
		return chromeDriver;
	}
	
	public String getIndexPageTitleChrome() {
		chromeDriver.get(hostName);
		return chromeDriver.getTitle();
	}
	
	public boolean getIndexMenusBSHChrome() {
		return chromeDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[1]/a")).isDisplayed();
	}
	
	public boolean getIndexMenusProExpChrome() {
		chromeDriver.get(hostName);
		return chromeDriver.findElement(By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[2]/a")).isDisplayed();
	}
	
	public void closeChromeDriver() {
		if(!(chromeDriver == null)) {
			chromeDriver.close();
			chromeDriver = null;
		}
	}

}
