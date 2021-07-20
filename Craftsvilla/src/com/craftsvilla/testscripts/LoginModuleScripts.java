package com.craftsvilla.testscripts;

import java.util.Scanner;

import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.craftsvilla.generic.BaseTest;
import com.craftsvilla.pompages.HomePage;
import com.craftsvilla.pompages.SignInPages;

public class LoginModuleScripts extends BaseTest
{
	HomePage hp = null;
	SignInPages sp = null;
	Scanner in = new Scanner(System.in);
	int OTP = 0;
	String mobile = "9953011811"; 
	Logger log = Logger.getLogger(LoginModuleScripts.class);

	@Test
	public void TC_01_LoginWithMultipleCredentials()
	{
		
		hp = new HomePage(driver);
		sp = new SignInPages(driver);
		try
		{
			hp.clickOnSignINLink();
			System.out.println("Enter the Your 10 digit Mobile Number : ");
			mobile = in.next();
			sp.setMobile(mobile);
			sp.clickContinue();
			System.out.println("Enter the OTP : ");
			OTP = in.nextInt();
			sp.setPasswordByOTP(OTP);
			Assert.fail();
			sp.clickOnLogin();
			hp.gotoMyAccount();
			hp.clickOnLogout();
		}
		catch(Exception ex)
		{
			log.error(""+ex);
		}
	}
}
