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
	
	WebDriver driver  = null;
	
	//set up initial environment
	@BeforeSuite
	public void setup(){
	
		//set driver exe path
	System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+ "\\src\\main\\resources\\drivers\\chromedriver.exe");
	
	driver = new ChromeDriver();
	
	//maximize window
	driver.manage().window().maximize();
	
	//open url
	driver.get("https://www.facebook.com/r.php");
	
	//implicit wait
	driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
	
	}
	
	//Register for new facebook user using valid first name , last name  and password 
	@Test (priority = 1)
	public void registration(){
		
		//Explicit wait
		/*
		WebDriverWait objWebDriverWait = new WebDriverWait(driver, 10);
		objWebDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstname']")));
		*/
		
		
		WebElement userName = driver.findElement(By.xpath("//input[@name='firstname']"));
		userName.sendKeys("Sunita");
		
		//System.out.println("*******Get Attribute of name is : " + userName.getAttribute("name"));
		
		driver.findElement(By.name("lastname")).sendKeys("shinde");
		driver.findElement(By.name("reg_email__")).sendKeys("100200323");
		driver.findElement(By.id("password_step_input")).sendKeys("afaf");
		
	}
	@Test (priority = -2)
	public void enterDay(){
				
		WebElement day = driver.findElement(By.name("birthday_day"));
		
		Select objSelect= new Select(day);
		
		objSelect.selectByIndex(3);
		//objSelect.selectByValue("8");
		//objSelect.selectByVisibleText("14");
		
	}
	
	//enter month
	@Test (priority = -1)
	public void enterMonth(){
		//locate month
		WebElement monthLocator = driver.findElement(By.id("month"));
		
		Select objSelectMonth = new Select(monthLocator);
		
		List<WebElement> allOption = objSelectMonth.getOptions();
		
		int size = allOption.size();
		System.out.println("Total months are : " + size);
		
		String month;
		for (int i=1; i<size; i++){
			month = allOption.get(i).getText();
			System.out.println(month);			
		}
		allOption.get(5).click();
			
	}
	
	//Enter Year
	@Test (priority = 0)
	public void enterYear(){
		
		List<WebElement> yearData = driver.findElements(By.xpath("//option[contains(@value,'20')]"));
		//year.sendKeys("2012");	
		int size = yearData.size();
		
		String birthYear ;
		
		for (int i=0; i<size; i++){
		birthYear = yearData.get(i).getText();
		System.out.println(birthYear);
		}
		yearData.get(4).click();
		
	}
	
	//Select Radio button
	@Test
	public void selectRadioButton(){
		
		//locate radio button Male and click
		WebElement radioBtn = driver.findElement(By.xpath("//input[@name ='sex' and contains(@value,'2') ]"));
		radioBtn.click();
		
		//locate Sign Up button and click 
		driver.findElement(By.name("websubmit")).click();
	}
	

}
