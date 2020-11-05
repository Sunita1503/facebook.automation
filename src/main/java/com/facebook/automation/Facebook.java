package com.facebook.automation;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class Facebook {

	public static WebDriver driver = null;

	// set up initial environment
	@Test(priority = 1)
	public void setup() {

		// set driver exe path
		System.setProperty("webdriver.chrome.driver",
				System.getProperty("user.dir") + "\\src\\main\\resources\\drivers\\chromedriver.exe");

		driver = new ChromeDriver();

		// maximize window
		driver.manage().window().maximize();

		// open url
		driver.get("https://www.facebook.com/r.php");

		// implicit wait
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

	}

	// Register for new facebook user using valid first name , last name and
	// password
	@Test(priority = 2)
	public void registration() {

		// locate and set firstname
		WebElement userName = driver.findElement(By.xpath("//input[@name='firstname']"));
		userName.sendKeys("Sunita");

		// locate and set lastname
		driver.findElement(By.name("lastname")).sendKeys("shinde");

		// locate and set random 10 digit mobile number
		driver.findElement(By.name("reg_email__")).sendKeys(generateMobileNo());
		// locate and set password
		driver.findElement(By.id("password_step_input")).sendKeys("abcdfgh");

	}

	// Generate random mobile No.
	public static String generateMobileNo() {

		long mobileNo = (long) Math.floor(Math.random() * 9999999999L);

		// convert long value to string
		String strMobile = String.valueOf(mobileNo);
		String mobileNumber = strMobile.replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1) $2-$3");

		System.out.println(mobileNumber);

		return mobileNumber;

	}

	@Test(priority = 3)
	public void enterDay() {

		WebElement day = driver.findElement(By.name("birthday_day"));

		Select objSelect = new Select(day);

		objSelect.selectByIndex(3);

	}

	// enter month
	@Test(priority = 3)
	public void enterMonth() {
		// locate month
		WebElement monthLocator = driver.findElement(By.id("month"));

		Select objSelectMonth = new Select(monthLocator);

		List<WebElement> allOption = objSelectMonth.getOptions();

		allOption.get(5).click();

	}

	// Enter Year
	@Test(priority = 4)
	public void enterYear() {

		List<WebElement> yearData = driver.findElements(By.xpath("//option[contains(@value,'20')]"));

		yearData.get(4).click();

	}

	// Select Radio button
	@Test(priority = 5)
	public void selectRadioButton() {

		// locate radio button Male and click
		driver.findElement(By.xpath("//input[@name ='sex' and contains(@value,'2') ]")).click();
		;
		// driver.findElement(By.id("u_0_5")).click();
		// radioBtn.click();

		// locate Sign Up button and click
		// driver.findElement(By.name("websubmit")).click();
	}

}
