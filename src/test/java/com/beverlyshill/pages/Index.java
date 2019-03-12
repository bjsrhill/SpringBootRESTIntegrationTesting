package com.beverlyshill.pages;

import static com.beverlyshill.utils.StepsController.getStepsController;
import static com.beverlyshill.utils.VerifyController.getVerifyController;

import com.beverlyshill.steps.GlobalSteps;
import com.beverlyshill.utils.StepsController;
import com.beverlyshill.utils.VerifyController;

/**
 * Index page object class
 * 
 * @author beverlyshill
 *
 */
public class Index  {
	
	static GlobalSteps global;
	
	private static StepsController steps;
    private static VerifyController verify;
	
    /**
     * 
     * Method to instantiate a StepsController class
     * 
     * @return a StepsController class
     */
    public StepsController steps(){
        return steps;
    }

    /**
     * 
     * Method to instantiate a VerifyController class
     * 
     * @return a VerifyController class
     */
    public VerifyController verify(){
        return verify;
    }
	
    /**
     * 
     * Static factory method to instantiate 
     * an Index class
     * 
     * @param globalSteps GlobalSteps class
     * @return Index class
     */
	public static Index getIndex(GlobalSteps globalSteps){
		global = globalSteps;
		steps = getStepsController(global);
		verify = getVerifyController(global);
        return new Index();
    }
	
	
}
