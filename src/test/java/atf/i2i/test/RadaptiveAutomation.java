package atf.i2i.test;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class RadaptiveAutomation {

	/*
	 * Creating a new account in radaptive and validating whether
	 * it is created or not
	 */

	static WebDriver driver;
	Logger logger=Logger.getLogger(RadaptiveAutomation.class);

	@BeforeSuite
	public static void startDriver() {
		driver=new HtmlUnitDriver(true);
		((HtmlUnitDriver)driver).setJavascriptEnabled(true);
	}

	@Test
	public void coreChecklistDemo() throws InterruptedException{
		System.out.println("Launching the site");
		logger.info("Launching the site");
		//driver.get("http://192.168.1.211:8080/Radaptive-1.0/");
		driver.get("http://45.55.53.138:8082/Radaptive-1.0/");		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSubmit")));
		try {
			WebElement user = driver.findElement(By.id("j_username"));
			user.sendKeys("superuser");
			WebElement pass = driver.findElement(By.id("password"));
			pass.sendKeys("super123$");
			WebElement log = driver.findElement(By.id("btnSubmit"));
			log.click();
			System.out.println("Login into Server");
		}catch (Exception e) {
			System.out.println("Inside Catch Block");
			logger.error("Error on Login page" +" "+e);
			Assert.fail("Login page error");
		}		
		logger.info("==================Launching Home Page==============================");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("scroll(0,250)","");*/
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='side-menu-list']/li[7]/a")));
		WebElement account = driver.findElement(By.xpath("//*[@id='side-menu-list']/li[7]/a"));	
		account.click();
		logger.info("==================Clicking the Account==============================");
	}

	@AfterMethod
	public void afterMethod(){
		driver.close();
	}	
}