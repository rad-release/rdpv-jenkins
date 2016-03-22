package com.i2i.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoWork {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 40);

	@Test
	public void validateChecklist() throws InterruptedException {

	
	wait.until(ExpectedConditions.presenceOfElementLocated(By.id("j_username")));	
    WebElement user = driver.findElement(By.id("j_username"));
    user.sendKeys("superuser");
    WebElement pass = driver.findElement(By.id("password"));
    pass.sendKeys("superuser");
    WebElement log = driver.findElement(By.id("btnSubmit"));
    log.click();
    System.out.println("==================Launching Home Page============================");
    Thread.sleep(8000);
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Data")));
    WebElement data = driver.findElement(By.linkText("Data"));
    data.click();
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[text()='Manage Data']")));
    WebElement manageData = driver.findElement(By.xpath("//a[text()='Manage Data']"));
    manageData.click();
	}
	@BeforeMethod
	public void beforeMethod() {


		driver.get("http://192.168.1.173:8080");
		System.out.println("=========================Launching the Login Page===================================");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("==============================Running Browser close============================");
		//driver.close();
	}

}


