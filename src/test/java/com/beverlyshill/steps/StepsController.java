package com.beverlyshill.steps;

import static com.beverlyshill.utils.WebDriverFactory.getChromeDriver;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;

public class StepsController {
	
static GlobalSteps global;
	
	private StepsController(GlobalSteps globalSteps) {
		
	}
	
	public static StepsController getStepsController(GlobalSteps globalSteps) {
		global = globalSteps;
		return new StepsController(globalSteps);
	}
	
	public String getIndexEndpoint() {
		return global.indexEndpoint();
	}
	
	public String getIndexPageTitleChrome() {
		getChromeDriver().get(global.getHostName());
		return getChromeDriver().getTitle();
	}
	
	public ArrayList<String> getMenus() {
    	ResponseEntity<String> resp = global.getRestTemplate().getForEntity(global.indexEndpoint(), String.class);
    	ArrayList<String> webMenus = new ArrayList<String>();
    	webMenus.add(resp.getBody());
    	return webMenus;
    }
	
	public static By BSHMenu() {
		return By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[1]/a");
	}
	
	public static By professionalExperienceMenu() {
		return By.xpath("//*[@id=\"navbar-collapse\"]/div[2]/h3/li[2]/a");	
	}
	
	public ArrayList<String> getExpectedMenus() {
		String output = "\"" + StringUtils.arrayToDelimitedString(global.getListOfStrings() , "\",\"") + '"';
		ArrayList<String> expected = new ArrayList<String>();
		System.out.println("The expected output is: " + output);
		expected.add(output);
		return expected;
	}

}
