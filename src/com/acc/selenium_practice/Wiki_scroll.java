package com.acc.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Wiki_scroll {
	WebDriver driver;
	@Test
	public void legister() throws InterruptedException
	{
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);
		Assert.assertEquals(title, "Wikipedia");
		WebElement search = driver.findElement(By.id("searchInput"));
		js.executeScript("arguments[0].value='india';", search);
		js.executeScript("arguments[0].style.border='7px dotted red'", search);
		Thread.sleep(2000);
		
		WebElement searchB = driver.findElement(By.xpath("//*[@id='search-form']/fieldset/button"));
		js.executeScript("arguments[0].click();", searchB);
		Thread.sleep(1000);
		js.executeScript("window.scrollBy(50,10000)");
		
		js.executeScript("alert('Scrolled India page');");
		Thread.sleep(3000);
		driver.switchTo().alert().accept();
		
		
	}
	
	@BeforeTest
	public void launch_browser()
	{
		
		System.setProperty("webdriver.ie.driver", "C:\\driver99\\IEDriverServer1.exe");
		driver = new InternetExplorerDriver();
		//System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		//driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org");
		
		
	}
	
	@AfterTest
	public void close_browser()
	{
		
	}
}
