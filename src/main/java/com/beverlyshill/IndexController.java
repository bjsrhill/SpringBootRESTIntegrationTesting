package com.beverlyshill;

import java.util.ArrayList;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
/**
 * 
 * @author beverlyshill
 * 
 * Rest controller for the 
 *
 */
public final class IndexController {
	
	private final Index index = new Index();
	
	@GetMapping
    public ArrayList<String> getExpectedMenus() {
        return index.getExpectedMenus();
    }
	
	

}
