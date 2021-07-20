package com.craftsvilla.generic;

import java.util.Scanner;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class test {

	public WebDriver driver = null;
	public static void main(String[] args) 
	{
		
		Scanner getdata = new Scanner(System.in);
		int OTP;

		test obj = new test();
		obj.setup();
		System.out.println("Enter the OTP : ");
		OTP = getdata.nextInt();
		System.out.println("OTP:" + OTP);
		obj.setPasswordByOTP(OTP);
		System.out.println("OTP:" + OTP);
		
		getdata.close();
	}
	
	public void setup()
	{
		System.setProperty(AutoConst.CHROME_KEY, AutoConst.CHROME_VALUE);
		driver = new ChromeDriver();
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.get(AutoConst.APP_URL);
		driver.findElement(By.id("signinAction")).click();
		driver.findElement(By.id("loginMobile")).sendKeys("9953011811");
		driver.findElement(By.id("loginAction")).click();
		
		
	}
	public void setPasswordByOTP(int OTP_Password)
	{
		try
		{
			int count = 0,i=3;
			int a[] = {0,0,0,0}; 
			while(count != 4) 
			{
				a[i--] = OTP_Password % 10;
				OTP_Password = OTP_Password / 10;
				count = count + 1;
				System.out.println(a[i+1]);
			}
			
			WebElement TXT_OtpPart1 = driver.findElement(By.xpath("//input[@class='otp-input'][1]"));
			WebElement TXT_OtpPart2 = driver.findElement(By.xpath("//input[@class='otp-input'][2]"));
			WebElement TXT_OtpPart3 = driver.findElement(By.xpath("//input[@class='otp-input'][3]"));
			WebElement TXT_OtpPart4 = driver.findElement(By.xpath("//input[@class='otp-input'][4]"));
			
			TXT_OtpPart1.sendKeys(Integer.toString(a[0]));
			TXT_OtpPart2.sendKeys(Integer.toString(a[1]));
			TXT_OtpPart3.sendKeys(Integer.toString(a[2]));
			TXT_OtpPart4.sendKeys(Integer.toString(a[3]));
			
			driver.findElement(By.xpath("//div[text()='LOGIN']")).click();

		}
		catch(Exception ex) 
		{
			System.out.println("" + ex);
		}
	}



}
