package com.beverlyshill;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

/**
 * 
 * @author beverlyshill
 *
 * Utility class for testing the /index endpoint
 * 
 */
public class Index {
	
	private String [] listOfStrings = {"Beverly S. Hill", "Professional Experience", "Other Experience", "Technical Skills", "Training", "Education"};
	
	public ArrayList<String> getExpectedMenus() {
		String output = "\"" + StringUtils.arrayToDelimitedString(listOfStrings , "\",\"") + '"';
		ArrayList<String> expected = new ArrayList<String>();
		expected.add(output);
		return expected;
		
	}
	
	

}
