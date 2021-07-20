package com.craftsvilla.generic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BaseTest implements AutoConst
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	@Parameters("browserType")
	@BeforeMethod
	public void launchApp(String browser)
	{
		if(browser.equalsIgnoreCase("Chrome"))
		{
			System.setProperty(CHROME_KEY, CHROME_VALUE);
			driver = new ChromeDriver();
		}
		else if (browser.equalsIgnoreCase("gechodriver"))
		{
			System.setProperty(GECHO_KEY, GECHO_VALUE);
			driver = new FirefoxDriver();
		}
		else
		{
			//Reporter.log
			System.out.println("Invalid Broswer Selection");
			System.exit(0);		
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get(APP_URL);
	}
	
	@AfterMethod
	public void closeApp()
	{
		driver.quit();
	}

}
