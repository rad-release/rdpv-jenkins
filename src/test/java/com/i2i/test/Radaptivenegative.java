package com.i2i.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import junit.framework.Assert;

public class Radaptivenegative {
	
	
	/*
	 * Creating a new account in radaptive and validating whether
	 * it is created or not
	 */

	static Logger logger=Logger.getLogger(Radaptivenegative.class);
	static WebDriver driver = new FirefoxDriver();
	WebDriverWait waites = new WebDriverWait(driver, 30);

	@Test
	public void coreChecklistDemo() throws InterruptedException 
	{

		waites.until(ExpectedConditions.presenceOfElementLocated(By.name("btnSubmit")));
		try {
			WebElement user = driver.findElement(By.id("j_username"));
			highlightElement(user);
			user.sendKeys("superuser");
			logger.info("=================userfield=========================");
			WebElement pass = driver.findElement(By.id("password"));
			highlightElement(pass);
			pass.sendKeys("superuser");
			WebElement log = driver.findElement(By.id("btnSubmit"));
			highlightElement(log);
			log.click();
		} catch (Exception e) {
			logger.error("Error on Login page" +" "+e);
			Assert.fail("Login page error");
		}
		logger.info("==================Launching Home Page==============================");
		waites.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Account")));
		WebElement account = driver.findElement(By.linkText("Account"));
		highlightElement(account);
		account.click();
		logger.info("==================Clicking the Account==============================");
		waites.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Create Account']")));
		try {
			WebElement createaccount = driver.findElement(By.xpath("//a[text()='Create Account']"));
			highlightElement(createaccount);
			createaccount.click();
		} catch (Exception e1) {

			logger.error("Error on clicking CreateAccount: "+e1);
			Assert.fail("Click on create account error");
		}
		logger.info("==================Launching the Account Section====================");

		driver.switchTo().alert().accept();
		driver.switchTo().alert().accept();
		waites.until(ExpectedConditions.presenceOfElementLocated(By.id("accountId")));

		try {
			WebElement accountId = driver.findElement(By.id("accountId"));
			highlightElement(accountId);
			accountId.sendKeys("denny4");


		/*	WebElement password = driver.findElement(By.id("password"));
			highlightElement(password);
			password.sendKeys("1234567");*/

			WebElement confpassword = driver.findElement(By.id("confirmPassword"));
			highlightElement(confpassword);
			confpassword.sendKeys("1234596");
			WebElement firstname = driver.findElement(By.id("firstName"));
			highlightElement(firstname);
			firstname.sendKeys("demo3");

			WebElement lastname = driver.findElement(By.id("lastName"));
			highlightElement(lastname);
			lastname.sendKeys("d");

			WebElement email = driver.findElement(By.id("email"));
			highlightElement(email);
			email.sendKeys("iw1@gmail.com");

			WebElement number = driver.findElement(By.id("contactNumber"));
			highlightElement(number);
			number.sendKeys("9383986312393");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error on updating the fields: "+e);
			Assert.fail("Error on updating the fields");
		}
		waites.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[onclick='saveAccount();']")));
		try {
			WebElement save = driver.findElement(By.cssSelector("input[onclick='saveAccount();']"));
			highlightElement(save);
			save.click();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			logger.error("Error on saving on account: "+e);
			Assert.fail("Error on saving on account");
		}

		String error;
		try {
			WebElement alertId = driver.findElement(By.id("message_label"));
			error = alertId.getText();
		} catch (Exception e) {
			logger.error("Error on alert: " +e);
			Assert.fail("Error on alert");
		}

		waites.until(ExpectedConditions.presenceOfElementLocated(By.id("MANAGE_ACCOUNTSaccountId")));
		WebElement accountd = driver.findElement(By.id("MANAGE_ACCOUNTSaccountId"));
		highlightElement(accountd);
		accountd.sendKeys("denny4");

		WebElement search = driver.findElement(By.id("search"));
		highlightElement(search);
		search.click();

		logger.info("==============================New Account is created=====================");

	}

	@BeforeMethod
	public void beforeMethod() {


		driver.get("http://192.168.1.211:8080/Radaptive-1.0");
		driver.manage().window().maximize();



	}

	@AfterMethod
	public void afterMethod() {

		driver.close();
	}


	public static void highlightElement(WebElement element) throws
	InterruptedException
	{
		for (int i=0;i<2;i++)
		{
			//((JavascriptExecutor)driver).executeScript("arguments[0].style.backgroundColor = 'yellow'", element);
			((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", element);
		}
	}
}


