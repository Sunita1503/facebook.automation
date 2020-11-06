package com.facebook.automation;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class EnvSetup {

	public WebDriver driver;

	// set up initial environment
	
	public void initializeWebEnv() {

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
		
		System.out.println(driver.getTitle());

	}

	public WebDriver getDriver() {

		
		return driver;
	}

}
