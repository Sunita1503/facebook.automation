package com.facebook.automation;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import junit.framework.Assert;

public class ModularFunctions {

	private EnvSetup objEnvSetup;
	public static Random random = new Random();

	// constructor to call EnvSetup
	public ModularFunctions(EnvSetup envSetup) {

		this.objEnvSetup = envSetup;
	}

	public void verifyFacebookTitle() {

		// get title
		String strTitle = objEnvSetup.getDriver().getTitle();

		// check if Title matches
		Assert.assertEquals(strTitle, "Sign up for Facebook | Facebook");

		// wait till 15 seconds
		objEnvSetup.getDriver().manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	public void setFirstName(String strFirstName) {

		WebElement webElement = objEnvSetup.getDriver().findElement(By.name("firstname"));
		webElement.sendKeys(strFirstName);
	}

	public void setLastName(String strLastName) {

		WebElement webElement = objEnvSetup.getDriver().findElement(By.name("lastname"));
		webElement.sendKeys(strLastName);
	}

	public void setMobileNumber(String strMobileNumber) {
		WebElement webelement = objEnvSetup.getDriver().findElement(By.name("reg_email__"));
		webelement.sendKeys(strMobileNumber);
	}

	public void setPassword(String strPassword) {

		WebElement webElement = objEnvSetup.getDriver().findElement(By.id("password_step_input"));
		webElement.sendKeys(strPassword);
	}

	public void setDay(String strDay) {

		WebElement webElement = objEnvSetup.getDriver().findElement(By.name("birthday_day"));
		Select objSelect = new Select(webElement);

		objSelect.selectByVisibleText("6");
		webElement.sendKeys(strDay);
	}

	public void setMonth(String strMonth) {
		WebElement webelement = objEnvSetup.getDriver().findElement(By.id("month"));
	}

	public void verifyAllDropdownValues(By Locator) {

		WebElement webElement = objEnvSetup.getDriver().findElement(By.id("month"));

		Select objSelectMonth = new Select(webElement);
		List<WebElement> dropdownMonths = objSelectMonth.getOptions();

		System.out.println("List of month from drop down : " + dropdownMonths.get(5).getText());

		List<String> monthsList = Utilities.listofMonths();

		System.out.println("*** Month from utilities : " + monthsList.get(5));

		for (WebElement month : dropdownMonths) {
			boolean blnFlag = false;
			for (int i = 0; i < monthsList.size(); i++) {
				if (month.getText().equals(monthsList.get(i))) {
					blnFlag = true;
				}
			}
			Assert.assertTrue(blnFlag);
		}
	}
	/*
	 * public void setDateOfMonthDropDown(int index) { WebElement dropdownmonth
	 * = objEnvSetup.getDriver().findElement(By.id("month"));
	 * Utilities.selectDropDownOfMonth(dropdownmonth, index); }
	 */

	public void setMonthInDropdown(String strMonth) {
		WebElement element = objEnvSetup.getDriver().findElement(By.id("month"));
		Utilities.selectDropDown(element, strMonth);

	}

	public void setYear() {

		List<WebElement> yearList = objEnvSetup.getDriver().findElements(By.xpath("//option[contains(@value,'20')]"));
		// Select objSelect = new Select(webelement);
		// List<WebElement> yearList = objSelect.getOptions();

		System.out.println("Year list size : " + yearList.size());
		System.out.println("Years is : " + yearList);

		int randomYear = 0;
		String yearSelected = null;
		for (int i = 0; i < yearList.size(); i++) {
			randomYear = random.nextInt(yearList.size());
			yearSelected = yearList.get(randomYear).getText();
		}
		System.out.println("Random year is : **********== " + yearSelected);

	}

	public void setradiobutton() {

		objEnvSetup.getDriver().findElement(By.xpath("//input[@name ='sex' and contains(@value,'2') ]")).click();

	}

	public void setDay() {

		WebElement webelement = objEnvSetup.getDriver().findElement(By.name("birthday_day"));

		Select objSelect = new Select(webelement);
		List<WebElement> dayList = objSelect.getOptions();

		System.out.println("Days list size is : " + dayList.size());
		String selectDay;
		int randomIndex = 0;
		for (int i = 0; i < dayList.size(); i++) {
			randomIndex = random.nextInt();
		}
		selectDay = String.valueOf(randomIndex);

		
	}

}
