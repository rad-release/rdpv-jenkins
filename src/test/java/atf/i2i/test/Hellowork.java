package atf.i2i.test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class Hellowork {

	WebDriver driver = new FirefoxDriver();
	WebDriverWait wait = new WebDriverWait(driver, 20);

	@Test
	public void validateLoginPage() throws InterruptedException {

		Thread.sleep(4000);
		System.out.println("====================Loading the Login page===========================");
		try {
		WebElement user = driver.findElement(By.id("username"));
		user.sendKeys("superuser");
		WebElement pass = driver.findElement(By.name("password"));
		pass.sendKeys("superuser");
		WebElement log = driver.findElement(By.id("btnSubmit"));
		log.click();
		} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();

		}
		System.out.println("====================Loading Home Page===========================");
		Thread.sleep(2000);
		//Assert.assertEquals("hello' superuser ' your logged in successfully...", driver.findElement(By.xpath("//body[@bgcolor='#f0f0f0']/h1")));

	}
	@BeforeMethod
	public void beforeMethod() {

		//driver.get("http://192.168.1.173:5080/rdpv-jenkins/");
		driver.get("http://192.168.1.211:6080/rdpv-jenkins-1.0/");
		System.out.println("=========================LoginPage===================================");
		driver.manage().window().maximize();

	}

	@AfterMethod
	public void afterMethod() {

		System.out.println("Running Browser close");
		driver.close();
	}

}


