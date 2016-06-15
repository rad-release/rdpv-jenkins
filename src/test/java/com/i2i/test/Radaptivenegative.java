package com.i2i.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Radaptivenegative {
	/*
	 * Creating a new account in radaptive and validating whether
	 * it is created or not
	 */
	static WebDriver driver;
	static Logger logger=Logger.getLogger(Radaptivenegative.class);
		
	@BeforeSuite
	public static void startDriver() {
		driver=new HtmlUnitDriver(true);
		((HtmlUnitDriver)driver).setJavascriptEnabled(true);
    }	

	@Test
	public void coreChecklistDemo() throws InterruptedException 
	{
		//driver.get("http://192.168.1.211:8080/Radaptive-1.0");
		driver.get("http://45.55.53.138:8082/Radaptive-1.0/");
		driver.manage().window().maximize();
		WebDriverWait waites = new WebDriverWait(driver, 30);
		waites.until(ExpectedConditions.presenceOfElementLocated(By.name("btnSubmit")));
		try {
			WebElement user = driver.findElement(By.id("j_username"));
			user.sendKeys("superuser");
			WebElement pass = driver.findElement(By.id("password"));
			pass.sendKeys("superuser");
			WebElement log = driver.findElement(By.id("btnSubmit"));
			log.click();
		} catch (Exception e) {
			logger.error("Error on Login page" +" "+e);
			Assert.fail("Login page error");
		}
		logger.info("==================Launching Home Page==============================");
		waites.until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='side-menu-list']/li[7]/a")));
		WebElement account = driver.findElement(By.xpath(".//*[@id='side-menu-list']/li[7]/a"));
		account.click();
		logger.info("==================Clicking the Account==============================");
		waites.until(ExpectedConditions.presenceOfElementLocated(By.id("sideMenu4099af9c-74c8-11e1-ab81-001cc0ebc61a")));
		try {
			WebElement createaccount = driver.findElement(By.id("sideMenu4099af9c-74c8-11e1-ab81-001cc0ebc61a"));
			createaccount.click();
		} catch (Exception e1) {
			logger.error("Error on clicking CreateAccount: "+e1);
			Assert.fail("Click on create account error");
		}
		logger.info("==================Launching the Account Section====================");
		waites.until(ExpectedConditions.presenceOfElementLocated(By.id("accountId")));
		try {
			WebElement accountId = driver.findElement(By.id("accountId"));
			accountId.sendKeys("denny4");
			WebElement confpassword = driver.findElement(By.id("confirmPassword"));
			confpassword.sendKeys("12398776");
			WebElement firstname = driver.findElement(By.id("firstName"));
			firstname.sendKeys("demo3");
			WebElement lastname = driver.findElement(By.id("lastName"));
			lastname.sendKeys("d");
			WebElement email = driver.findElement(By.id("email"));
			email.sendKeys("test@gmail.com");
			WebElement number = driver.findElement(By.id("contactNumber"));
			number.sendKeys("9383986312393");
		} 
		catch (Exception e) {
			logger.error("Error on updating the fields: "+e);
			Assert.fail("Error on updating the fields");
		}
		waites.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[onclick='saveAccount();']")));
		try {
			WebElement save = driver.findElement(By.cssSelector("input[onclick='saveAccount();']"));
			save.click();
		} catch (Exception e) {
			logger.error("Error on saving on account: "+e);
			Assert.fail("Error on saving on account");
		}
		try 
		{
			WebElement alertId = driver.findElement(By.id("message_label"));
			String error = alertId.getText();
			System.out.println(error);
		} catch (Exception e) {
			logger.error("Error on alert: " +e);
			Assert.fail("Error on alert");
		}
		
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
	}
}