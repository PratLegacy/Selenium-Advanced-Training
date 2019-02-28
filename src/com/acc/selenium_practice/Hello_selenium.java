package com.acc.selenium_practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Hello_selenium {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
			System.out.println("Hello java selenium");
			System.setProperty("webdriver.chrome.driver", "C:\\driver99\\chromedriver.exe");
			ChromeDriver driver = new ChromeDriver();
			driver.get("http://newtours.demoaut.com/");
			driver.findElement(By.linkText("REGISTER")).click();
			driver.findElement(By.name("firstName")).sendKeys("Prathik");
			driver.findElement(By.name("lastName")).sendKeys("R");
			driver.findElement(By.name("phone")).sendKeys("7795467547");
			driver.findElement(By.xpath("//*[@id='userName']")).sendKeys("prathikramk");
			
			driver.findElement(By.name("address1")).sendKeys("JP");
			driver.findElement(By.name("address2")).sendKeys("Nagar");
			driver.findElement(By.name("city")).sendKeys("Bangalore");
			driver.findElement(By.name("state")).sendKeys("Karnataka");
			driver.findElement(By.name("postalCode")).sendKeys("560076");
			
			//By name
			//driver.findElement(By.name("country")).sendKeys("INDIA");
			WebElement CNT = driver.findElement(By.name("country"));
			Select s1 = new Select(CNT);
			//s1.selectByVisibleText("INDIA");
			//s1.selectByValue("92");
			s1.selectByIndex(107);
			
			//driver.findElement(By.name("email")).sendKeys("PrathikR");
			//driver.findElement(By.name("password")).sendKeys("acc123");
//			driver.findElement(By.name("confirmPassword")).sendKeys("acc123");
			
			driver.findElement(By.name("register")).click();
			
			driver.findElement(By.partialLinkText("sign-in")).click();
			
			driver.findElement(By.name("userName")).sendKeys("mercury");
			driver.findElement(By.name("password")).sendKeys("mercury");
			driver.findElement(By.name("login")).click();
			
			driver.findElement(By.xpath("//form/table/tbody/tr[2]/td[2]/b/font/input[2]")).click();

			WebElement Pass = driver.findElement(By.name("passCount"));
			s1 = new Select(Pass);
			s1.selectByValue("3");
			
			driver.close();//current tab
			//driver.quit(); for all tabs
			
	}

}


