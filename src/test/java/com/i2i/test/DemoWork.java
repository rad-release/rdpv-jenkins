package com.i2i.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
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
    try {
		WebElement manageData = driver.findElement(By.xpath("//a[text()='Manage Data']"));
		manageData.click();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		System.out.println("Error on clicking ManageData: "+e1);
	}
    System.out.println("==================Launching the ManageData form============================");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.linkText("Checklist")));
    try {
		WebElement checklist = driver.findElement(By.linkText("Checklist"));
		checklist.click();
	} catch (Exception e) {
		// TODO Auto-generated catch block
		System.out.println("Error on clicking the checklist: "+e);
	}
    System.out.println("==================Launching the checklist form============================");
    wait.until(ExpectedConditions.presenceOfElementLocated(By.name("item")));
    WebElement items = driver.findElement(By.name("item"));
    items.sendKeys("Test data work");
    WebElement status = driver.findElement(By.name("checkListStatus"));
    Select mySelect = new Select(status);
    mySelect.selectByValue("Started");
    Thread.sleep(2000);
    WebElement create = driver.findElement(By.id("create"));
    create.click();
    System.out.println("==================Created the Checklist============================");
    
    wait.until(ExpectedConditions.presenceOfElementLocated(By.className("viewLabel")));
    String ticket = driver.findElement(By.className("viewLabel")).getText();
    System.out.println("Created ticket id: "+ticket);
    
	}
	@BeforeMethod
	public void beforeMethod() {


		driver.get("http://192.168.1.173:8080");
		System.out.println("==================Launching the Login Page============================");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("==================Running Browser close============================");
		//driver.close();
	}

}


