package atf.i2i.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
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
		logger.info("======Launching the site========");
		//driver.get("http://192.168.1.211:8080/Radaptive-1.0/");
		driver.get("http://45.55.53.138:8082/Radaptive-1.0/");		
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.presenceOfElementLocated(By.id("btnSubmit")));
		try {
			logger.info("=======Username and Password Entered======");
			WebElement user = driver.findElement(By.id("j_username"));
			user.sendKeys("superuser");
			WebElement pass = driver.findElement(By.id("password"));
			pass.sendKeys("superuser");
			WebElement log = driver.findElement(By.id("btnSubmit"));
			log.click();
			//logger.info("=========Login into Application=========");
		}catch (Exception e) {
			logger.error("Error on Login page" +" "+e);
			Assert.fail("Login page error");
		}		
		logger.info("================Launching the Appliaction=================");
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		/*wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("enable-rclick-menuitems")));
		String userName=driver.findElement(By.xpath(".//*[@id='header-inner']/div/div/ul/li[6]/a/span")).getText();*/
		//String userName="Bala Ganesh";
		logger.info("========User Loggedin Successfully================");
/*		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[contains(text(),'Account')]")));
		WebElement account = driver.findElement(By.xpath("//a[contains(text(),'Account')]"));
		account.click();*/
		logger.info("==================Logout Successfully==============================");
	}

	@AfterMethod
	public void afterMethod(){
		driver.close();
	}	
}