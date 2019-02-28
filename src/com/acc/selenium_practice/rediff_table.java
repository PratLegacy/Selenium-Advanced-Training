package com.acc.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class rediff_table {
	WebDriver driver;
	@Test
	public void tableread() throws InterruptedException
	{
		
		driver.findElement(By.partialLinkText("Group A")).click();
		Thread.sleep(2000);
		
		//row count
		int rowCount = driver.findElements(By.tagName("tr")).size();
		
		//column count
		int colCount=driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th")).size();

        System.out.println("Row count :" + rowCount);
        System.out.println("Col count :" + colCount);
		
		for(WebElement tdata:driver.findElements(By.tagName("tr")))
		{
			System.out.println(tdata.getText());
			
		}
		
		int i=1;
		for(WebElement tcompany:driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]/a")))
		{
			
			if(tcompany.getText().equalsIgnoreCase("UPL"))
			{
				String stock = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+i+"]/td[5]")).getText();
				System.out.println("Stock of "+tcompany.getText()+" is "+stock);
				break;
			}
			i++;	
			//System.out.println(tcompany.getText());	
		}
			
		int testrow = 21;
		int testcol = 1;
		
		for(int i1=1; i1<=rowCount; i1++)
		{
			if(i1==testrow)
			for(int j=1; j<=colCount; j++)
				if(j==testcol)
				{
					String a = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr["+i1+"]/td["+j+"]/a")).getText();
					System.out.println(a);
					break;
				}
		}		
		
		
		
		//String company = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[14]/td[1]/a")).getText();
		//int linkCount = driver.findElements(By.xpath("//table//td[5]/a")).size();
		//System.out.println(linkCount);
		
	}
	
	
	@BeforeTest
	public void launch_browser() throws InterruptedException
	{
		
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://money.rediff.com/gainers");
		Thread.sleep(2000);
	}
	
	@AfterTest
	public void close_browser()
	{
		
	}
}
