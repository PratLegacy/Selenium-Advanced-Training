package com.acc.selenium_practice;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Testng_demo2 {
WebDriver driver;
	@Test(groups = { "Register" })
	public void legister()
	{
		driver.findElement(By.partialLinkText("SignUp")).click();
		driver.findElement(By.name("userName")).sendKeys("Prathik");
		driver.findElement(By.xpath("//input[@name='gender' and @value='Female']")).click();
		driver.findElement(By.xpath("//fieldset/div/div[9]/div/div/img")).click();
		
		WebElement Month = driver.findElement(By.className("ui-datepicker-month"));
		Select s1 = new Select(Month);
		s1.selectByValue("3");
		
		WebElement Year = driver.findElement(By.className("ui-datepicker-year"));
		Select s2 = new Select(Year);
		s2.selectByValue("1954");
		
		//driver.findElement(By.xpath("//*[@id='ui-datepicker-div']/table/tbody/tr[5]/td[3]/a")).click();
		driver.findElement(By.xpath("//a[contains(., '28')]")).click();
		
	}
	
	@Test(groups = { "Login" })
	public void login() throws InterruptedException
	{
		driver.findElement(By.partialLinkText("SignIn")).click();
		driver.findElement(By.name("userName")).sendKeys("lalitha");
		driver.findElement(By.name("password")).sendKeys("password123");
		driver.findElement(By.name("Login")).click();
//		driver.findElement(By.partialLinkText("SignOut")).click();
		/*driver.findElement(By.partialLinkText("All Categories")).click();
		driver.findElement(By.partialLinkText("Electronics")).click();
		Thread.sleep(1000);
		driver.findElement(By.partialLinkText("Head Phone")).click();*/
		
		WebElement mainelement = driver.findElement(By.xpath("//span[contains(., 'All Categories')]"));
		Actions act = new Actions(driver);
		act.moveToElement(mainelement);
		WebElement submenu = driver.findElement(By.xpath("//span[contains(., 'Electronics')]"));
		
		act.moveToElement(submenu);
		act.click().build().perform();;
		Thread.sleep(3000);
		driver.findElement(By.xpath("//span[contains(., 'Head Phone')]")).click();
		
		
	}
	
	@BeforeTest
	public void launch_browser()
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://10.250.88.214:8083/TestMeApp");
		driver.findElement(By.partialLinkText("SignUp")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,1000)");
		
	}
	
	@AfterTest
	public void close_browser()
	{
		
	}
}
