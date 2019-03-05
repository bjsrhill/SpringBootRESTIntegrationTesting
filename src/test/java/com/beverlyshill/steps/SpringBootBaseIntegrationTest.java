package com.beverlyshill.steps;

import java.util.ArrayList;

import org.junit.runner.RunWith;
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
 * Base class that accesses the REST endpoint(s)
 * and returns the response and expected values
 * for the integration testing
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
    
}
