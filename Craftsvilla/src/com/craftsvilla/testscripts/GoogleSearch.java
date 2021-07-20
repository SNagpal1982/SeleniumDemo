package com.craftsvilla.testscripts;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;



public class GoogleSearch
{
	public static WebDriver driver = null;
	public static WebDriverWait wait = null;
	
	@Parameters("browserType")
	@Test
	public void googleSeach(String browserType) throws MalformedURLException
	{
	
		String clientURL = "http://192.168.29.172:4444/wd/hub";
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setPlatform(Platform.WIN10);
		cap.setBrowserName(browserType);
		
		driver = new RemoteWebDriver(new URL(clientURL), cap);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		wait = new WebDriverWait(driver, 10);
		driver.get("https://google.com");
		WebElement search = driver.findElement(By.xpath("//input[@name='q']"));
		search.sendKeys("selenium");
		search.submit();
		System.out.println(driver.getTitle());
		
		
	}

}
