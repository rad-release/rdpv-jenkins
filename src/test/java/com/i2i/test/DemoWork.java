package com.i2i.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class DemoWork {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@Test
	public void validateLoginPage() throws InterruptedException {

<<<<<<< HEAD:src/test/java/com/i2i/test/DemoWork.java
		Thread.sleep(4000);
		System.out.println("====================Loading the Login page===========================");
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("superuser");
		WebElement pass = driver.findElement(By.name("password"));
=======
		Thread.sleep(6000);
		System.out.println("====================Loading the Login page===========================");
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("superuser");
		WebElement pass = driver.findElement(By.name("j_password"));
>>>>>>> 532fa53b4602640cee0680cd71fcbd87d6c97754:src/test/demo/com/i2i/test/DemoWork.java
		pass.sendKeys("superuser");
		WebElement log = driver.findElement(By.id("btnSubmit"));
		log.click();

	}
	@BeforeMethod
	public void beforeMethod() {

<<<<<<< HEAD:src/test/java/com/i2i/test/DemoWork.java
		driver.get("http://159.203.72.246:7080/rdpv-jenkins/");
		
=======
		driver.get("http://192.168.1.173:5080/rdpv-jenkins/");
>>>>>>> 532fa53b4602640cee0680cd71fcbd87d6c97754:src/test/demo/com/i2i/test/DemoWork.java
		System.out.println("=========================LoginPage===================================");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("==============================Running Browser close============================");
		driver.close();
	}

}


