package com.acc.selenium_practice;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;


public class telerik_test {
	
	WebDriver driver;

@Test
public void test()
{
	WebElement from = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[1]/div/div/span"));
	WebElement to = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00']/tbody/tr/td"));
	WebElement from2 = driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadTreeView1']/ul/li/ul/li[3]/ul/li[2]/div/div/span"));

	//WebElement to = driver.findElement(By.id("ctl00_ContentPlaceholder1_priceChecker"));

	Actions act = new Actions(driver);
	act.dragAndDrop(from, to);
	act.dragAndDrop(from2, to);

	act.build().perform();
	
	WebDriverWait wait=new WebDriverWait(driver,10);
	wait.until(ExpectedConditions.invisibilityOfElementWithText(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00']/tfoot/tr/td[2]"),"$0"));
	    String price=driver.findElement(By.xpath("//*[@id='ctl00_ContentPlaceholder1_RadGrid1_ctl00']/tfoot/tr/td[2]")).getText();
	         System.out.println("Total price of all items = " + price.substring(price.indexOf('$')));
	         
	         Assert.assertTrue(price.contains("$"));
	         System.out.println("passed");	
}


@BeforeTest
public void load() throws InterruptedException
{
	System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
	driver = new ChromeDriver();
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	driver.manage().window().maximize();
	driver.get("https://demos.telerik.com/aspnet-ajax/treeview/examples/overview/defaultcs.aspx");
	Thread.sleep(4000);
}

@AfterTest
public void after()
{
	//driver.close();
}

}
