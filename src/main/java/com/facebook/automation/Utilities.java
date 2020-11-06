package com.facebook.automation;

import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class Utilities {

		
	// Generate 10 digit random mobile No.
		public static String generateMobileNo() {

			long longMobileNo = (long) Math.floor(Math.random() * 9999999999L);

			// convert long value to string
			String strMobile = String.valueOf(longMobileNo);
			String mobileNumber = strMobile.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "$1-$2-$3");
	
			if (mobileNumber.length() < 12 )
				 mobileNumber.concat("1");
				
			return mobileNumber;
		}
		
		public static List<String> listofMonths(){
			
			List<String> monthsList = Arrays.asList ("Month","Jan" ,"Feb" ,"Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
			
			return monthsList;
			
		}
		
		public static String getRandomMonth(){
			
			Random random = new Random();
			String selectMonth="";
		
			List<String> listofMonths = Arrays.asList ("Jan" ,"Feb" ,"Mar","Apr","May","Jun","Jul","Aug","Sep","Oct","Nov","Dec");
			int randomIndex;
			for (int i=0; i< listofMonths.size(); i++){
				randomIndex = random.nextInt(listofMonths.size());
				selectMonth = listofMonths.get(randomIndex);						
			}
			return selectMonth;
			
		}
		
	
		
		public void verifyDropDownMonth (String strMonth){
			//WebElement webElement = objEnvSetup.getDriver().findElement(By.id("month"));
		/*	Select objSelectMonth = new Select(webElement);

			List<WebElement> allOption = objSelectMonth.getOptions();

			allOption.get(5).click();
*/
		}

		public static void selectDropDown(WebElement webelement,String strDropDownOption){
			Select objSelect = new Select(webelement);
			objSelect.selectByVisibleText(strDropDownOption);
		}
		
		public static void selectDropDownOfYear(List<WebElement> yeardropdown,int no){
			int yearsize = yeardropdown.size();
			System.out.println("size of year>>>"+yearsize);
			for(int i = 1;i<yearsize;i++)
			{
				String dropDownOption= yeardropdown.get(i).getText();
				System.out.println("All dropdown text is" + dropDownOption);
				yeardropdown.get(no).click();
				
				
			}
			}
		
}
