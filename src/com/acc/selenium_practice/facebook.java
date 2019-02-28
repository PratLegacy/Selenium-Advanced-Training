package com.acc.selenium_practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class facebook {
	WebDriver driver;
	@Test
	public void legister() throws InterruptedException
	{
		//driver.findElement(By.id(identifierId)).sendKeys();
		
		
	}
	
	
	@BeforeTest
	public void load() throws InterruptedException
{
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.gmail.com");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void after()
	{
		
	}
	
}