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

public class naukri_test {
	WebDriver driver;
	@Test
	public void legister() throws InterruptedException
	{
		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		
		String mainWindowID = it.next();
		
		//for loop implementation
		/*int winSize = winIds.size();
		
		for(int i=1; i<=winSize; i++)
		{
		driver.switchTo().window(it.next());
		driver.close();
		}	*/
		
		//while loop implementation
		while(it.hasNext())
		{
			driver.switchTo().window(it.next());
			driver.close();
			
		}
		
		driver.switchTo().window(mainWindowID);
	}
	
	
	@BeforeTest
	public void load() throws InterruptedException
{
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://www.naukri.com");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void after()
	{
		
	}
	
}
