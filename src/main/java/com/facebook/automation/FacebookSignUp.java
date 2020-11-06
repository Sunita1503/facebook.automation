package com.facebook.automation;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class FacebookSignUp extends EnvSetup {
	
	private ModularFunctions objModularFunctions;
	private By drpLocator = By.id("month");
	
	@BeforeClass
	public void initializeWebEnvironment(){
		
		objModularFunctions = new ModularFunctions(this);
		initializeWebEnv();
	}
	
	@Test
	public void signUpForFacebook(){
		
		objModularFunctions.verifyFacebookTitle();
		
		objModularFunctions.setFirstName("Sunita");
		
		objModularFunctions.setLastName("Shinde");
		
		objModularFunctions.setMobileNumber(Utilities.generateMobileNo());
		objModularFunctions.setPassword("abcd4567");
		
		objModularFunctions.setDay();
		
		objModularFunctions.verifyAllDropdownValues(drpLocator);
		objModularFunctions.setMonthInDropdown(Utilities.getRandomMonth());
		
		
		objModularFunctions.setYear();
		objModularFunctions.setradiobutton();
	}
	
	

}
