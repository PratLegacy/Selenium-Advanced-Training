package com.acc.selenium_practice;

import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class testme2_test {
	WebDriver driver;
	@Test(priority=2)
	public void tableread() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("OrderDetails")).click();
		Thread.sleep(2000);
		
		//row count
		int rowCount = driver.findElements(By.tagName("tr")).size();
		
		//column count
		int colCount=driver.findElements(By.xpath("//thead//th")).size();

        System.out.println("Row count :" + rowCount);
        System.out.println("Col count :" + colCount);
		
		for(WebElement tdata:driver.findElements(By.tagName("tr")))
		{
			System.out.println(tdata.getText());
		}
		
		int linkCount = driver.findElements(By.xpath("//table//td[5]/a")).size();
		System.out.println(linkCount);
		
	}
	
	
	@Parameters({"sUsername", "sPassword"})
	
	@Test(priority=1)
	public void login(String sUsername, String sPassword) throws InterruptedException
	{
		driver.findElement(By.partialLinkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("password123");
		driver.findElement(By.name("Login")).click();
		Thread.sleep(3000);
		

	}
	
	
	@BeforeTest
	public void launch_browser() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.232.237.143:443/TestMeApp2.2");
		Thread.sleep(1000);
	}
	
	@AfterTest
	public void close_browser()
	{
		
	}
}
