package com.beverlyshill.steps;

import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;
import static com.beverlyshill.utils.WebDriverFactory.closeChromeDriver;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;
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
	
	@Value("${listOfStrings}")
	private String [] listOfStrings;

	@Value("${hostName}")
	private String hostName;
	
	@Value("${indexEndpoint}")
	private String indexEndpoint;
	
    private RestTemplate restTemplate;
    
    private WebDriver chromeDriver = getChromeDriver();
        
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
	
	public String getIndexPageTitleChrome() {
		chromeDriver.get(hostName);
		return getChromeDriver().getTitle();
	}
	
	public boolean getIndexMenusBSHChrome() {
		return getChromeDriver().findElement(By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[1]/a")).isDisplayed();
	}
	
	public boolean getIndexMenusProExpChrome() {
		chromeDriver.get(hostName);
		return getChromeDriver().findElement(By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[2]/a")).isDisplayed();
	}
	
	public WebDriver getWebDriverChrome() {
		return chromeDriver;
	}
	
	public void chromeDriverClose() {
		closeChromeDriver();
	}
	

}
