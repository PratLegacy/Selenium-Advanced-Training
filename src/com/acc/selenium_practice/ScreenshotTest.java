package com.acc.selenium_practice;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ScreenshotTest {
	WebDriver driver;
	static String d;
	@Test
	public void legister() throws InterruptedException
	{
		driver.findElement(By.name("q")).sendKeys("Selenium");
		Thread.sleep(1000);
		ScreenshotTest.captureScreenshot(driver);
		
	}
	
	
	public static void captureScreenshot(WebDriver driver1)
	{
		File src = ((TakesScreenshot)driver1).getScreenshotAs(OutputType.FILE);
		try{
			d= new SimpleDateFormat("yyyy-MM-dd HH-mm-ss ").format(new Date());
			FileUtils.copyFile(src, new File("C:\\driver99\\screenshot\\"+d+System.currentTimeMillis()+" TestMe.png"));	
		}
		catch(IOException e)
		{
			System.out.println(e.getMessage());
		}
	}
	
	@BeforeTest
	public void launch_browser()
	{
		
		System.setProperty("webdriver.ie.driver", "C:\\driver99\\IEDriverServer1.exe");
		driver = new InternetExplorerDriver();
		/*System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();*/
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		
	}
	
	@AfterTest
	public void close_browser()
	{
		driver.close();

	}
}
