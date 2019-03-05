package com.beverlyshill.steps;

import java.util.ArrayList;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.beverlyshill.Index;
import com.beverlyshill.IndexController;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public abstract class SpringBootBaseIntegrationTest {
	
	private final String SERVER_URL = "http://beverlyshill.solutions";
    private final String INDEX_ENDPOINT = "/index";
    private Index index = new Index();

    private RestTemplate restTemplate;
    private IndexController controller = new IndexController();

    public SpringBootBaseIntegrationTest() {
        restTemplate = new RestTemplate();
    }

    private String indexEndpoint() {
        return SERVER_URL + INDEX_ENDPOINT;
    }
    
    public ArrayList<String> getMenus() {
    	ResponseEntity<String> resp = restTemplate.getForEntity(indexEndpoint(), String.class);
    	ArrayList<String> webMenus = new ArrayList<String>();
    	webMenus.add(resp.getBody());
    	return webMenus;
    }
    
    public ArrayList<String> getExpectedMenus() {
    	return controller.getExpectedMenus();
    }
    
}
