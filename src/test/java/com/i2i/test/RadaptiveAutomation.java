package com.i2i.test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import junit.framework.Assert;

public class RadaptiveAutomation {

	/*
	 * Getting row data's and checking whether actual data is came or not
	 *
	 */

	@Test
	public void validateText()throws InterruptedException{
		
        System.out.println("========== Radaptive Automation Test started ==========");
		WebDriver driver = new FirefoxDriver();

		driver.get("http://192.168.1.211:6080/rdpv-jenkins-1.0/sample.jsp");

		String expectmail = "dinesh@ideas2it.com";
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//table[@class='table']/tbody")));

		List<WebElement>datacolumn = driver.findElements(By.xpath("//table[@class='table']/tbody/tr[6]"));
		String coloumnx = "//table[@class='table']/tbody/tr[6]/td[";


		for(int radaptive=0; radaptive<datacolumn.size();radaptive++)
		{

			String count_coloum = coloumnx+(radaptive+6)+"]";

			//System.out.println("Counted Column: "+count_coloum);

			String actual_data = driver.findElement(By.xpath(count_coloum)).getText();
			Assert.assertEquals("dinesh@ideas2it.com",actual_data );

/*
			if(expectmail.equals(actual_data))
			{
				System.out.println("Acutal mail id: "+actual_data);

				System.out.println("Test case is pass");

			}
			else
			{
				System.out.println("Acutal mail id: "+actual_data);
				System.out.println("Test case is fail");
			}*/
		}
	}

}