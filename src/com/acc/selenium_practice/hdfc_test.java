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

public class hdfc_test {
	WebDriver driver;
	@Test
	public void legister() throws InterruptedException
	{
		int total_frame=driver.findElements(By.tagName("frame")).size();
		System.out.println(total_frame);
		driver.switchTo().frame(0);
		//driver.switchTo().frame("login_page");
		driver.findElement(By.name("fldLoginUserId")).sendKeys("436657	");
		//parallel input
		driver.switchTo().defaultContent();
		driver.switchTo().frame(1);
		driver.findElement(By.partialLinkText("Privacy Policy")).click();


		Set<String> winIds = driver.getWindowHandles();
		Iterator<String> it = winIds.iterator();
		
		System.out.println("Total windows - "+ winIds.size());
		
		String mainWindowID = it.next();
		
		String firstPopup = it.next();
		
		System.out.println(mainWindowID);
		System.out.println(firstPopup);
		
		driver.switchTo().window(firstPopup);
		
		driver.findElement(By.linkText("Personal")).click();
		driver.switchTo().defaultContent();
		
		//System.out.println(driver.findElements(By.tagName("frame")).size());
		Thread.sleep(2000);

		driver.switchTo().window(mainWindowID);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("/html/body/form/table[2]/tbody/tr/td[2]/table/tbody/tr[1]/td[1]/table/tbody/tr[3]/td[2]/table/tbody/tr[6]/td[2]/a/img")).click();
		//		             driver.findElement(By.xpath("//img[@alt='continue']")).click();
		
		
		
	}
	
	
	@BeforeTest
	public void load() throws InterruptedException
{
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://netbanking.hdfcbank.com/netbanking/");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void after()
	{
		
	}
	
}
