package com.acc.selenium_practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class excelread {
	WebDriver driver;
	FileInputStream Fread;
	FileOutputStream FWrite;
	XSSFWorkbook wb;
	XSSFSheet sh;
	String d1;
	String d2;
	
	String login, pwd;

	String wbmsg, xlmsg;

	String pass="Test case is Passed";

	String fail="Test case is Failed---xxxx---";

	int rowval, rowcount;
	
	@BeforeTest
	public void launch_browser() throws IOException
	{
		
		//System.setProperty("webdriver.ie.driver", "C:\\driver99\\IEDriverServer1.exe");
		//driver = new InternetExplorerDriver();
		System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
		driver = new ChromeDriver();
		Fread = new FileInputStream("C:\\driver99\\orangehrmidandpassword.xlsx");
		wb = new XSSFWorkbook(Fread);
		sh = wb.getSheetAt(0);
		
		d1 = sh.getRow(0).getCell(0).getStringCellValue();
		d2 = sh.getRow(0).getCell(1).getStringCellValue();

		rowcount = sh.getPhysicalNumberOfRows();
		System.out.println(d1);
		System.out.println(d2);
		System.out.println(rowcount);
		
	}
	
	@Test
	public void legister() throws InterruptedException, IOException
	{    
		 for(rowval=1;rowval<rowcount;rowval++)
		 {
		  login=sh.getRow(rowval).getCell(0).getStringCellValue();
		  pwd=sh.getRow(rowval).getCell(1).getStringCellValue();
		  xlmsg=sh.getRow(rowval).getCell(2).getStringCellValue();
			 
		  driver.get("http://professional.demo.orangehrmlive.com/");
		  Thread.sleep(2000);
		  driver.findElement(By.id("txtUsername")).clear();
		  driver.findElement(By.id("txtUsername")).sendKeys(login);
		  driver.findElement(By.id("txtPassword")).clear();
		  driver.findElement(By.id("txtPassword")).sendKeys(pwd);
		  driver.findElement(By.id("btnLogin")).click();
		  Thread.sleep(2000);
		  wbmsg=driver.findElement(By.id("account-name")).getText();
		  System.out.println(wbmsg);
		  driver.findElement(By.id("user-dropdown")).click();
		  Thread.sleep(2000);
		  driver.findElement(By.id("logoutLink")).click();

		  System.out.println(" ");
		  System.out.println(" ");
		  
		  System.out.println("Login id used is " + login);
		  System.out.println("Password used is " + pwd);
		  System.out.println("The user name is " + wbmsg);
		  
		 
		
		  FWrite=new FileOutputStream("C:\\driver99\\orangehrmidandpassword.xlsx");
		  sh.getRow(rowval).createCell(3).setCellValue(wbmsg);

			  if(wbmsg.equals(xlmsg))
			  {
				 System.out.println(pass);
				 sh.getRow(rowval).createCell(4).setCellValue(pass);
			  }
			  else
			  {
				System.out.println(fail);
				sh.getRow(rowval).createCell(4).setCellValue(fail);
			  }
			  wb.write(FWrite);
		 }
	  	 }
		 
	  

	  @AfterTest
	  public void afterTest() throws Exception {
		  Thread.sleep(2000);
		  driver.close();
		  wb.close();
	  
	  }

	}

