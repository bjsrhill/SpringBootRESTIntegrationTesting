package com.beverlyshill.steps;

public class Index  {
	
	static GlobalSteps global;
	
	private StepsController steps;
    private VerifyController verify;
	
	public StepsController stepsController() {
		return stepsController();
	}

    public StepsController steps(){
        return steps;
    }

    public VerifyController verify(){
        return verify;
    }
    
    private Index(StepsController steps, VerifyController verify){
        this.steps = steps;
        this.verify = verify;
    }
	
	public static Index getIndex(){
        return new Index(new StepsController(global),
                            new VerifyController(global));
    }
	
	
}
