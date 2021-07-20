package com.craftsvilla.generic;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;


public class BasePage 
{
	
	WebDriver driver = null;
	Logger log = Logger.getLogger(BasePage.class);
	
	public BasePage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void verifyTitlePresent(String expTitle)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		String actTitle = null;
		try
		{
			 w.until(ExpectedConditions.titleContains(expTitle));
			 actTitle = driver.getTitle();
			 Assert.assertEquals(actTitle, expTitle);
			 log.info("Matched ; ER : " + expTitle + " AR : " + actTitle);
		}
		catch(Exception ex)
		{
			Reporter.log(actTitle);
			log.error("Mismatched ; ER : " + expTitle + " AR : " + actTitle + "Exception: "+ex);
		}
	}
	
	public void verifyElementPresent(WebElement ele)
	{
		WebDriverWait w = new WebDriverWait(driver, 10);
		try
		{
			w.until(ExpectedConditions.visibilityOf(ele)); 
			log.info("'" + ele + "' was found");
		}
		catch(Exception ex)
		{
			log.info("'" + ele + "' unable to find the element." + "Exception : " + ex);
			
		}
	}
	
	public void MouseOver(WebElement ele)
	{
		try
		{
			Actions action = new Actions(driver);
			action.moveToElement(ele).perform();
			log.info("Mouse overed on '" + ele + "'");
		}
		catch (Exception ex)
		{
			log.info("Mouse overed failed on  '" + ele + "'" + ex);
		}
	}
}
