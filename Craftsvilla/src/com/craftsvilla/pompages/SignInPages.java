package com.craftsvilla.pompages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;


public class SignInPages extends BasePage
{
	Logger log = Logger.getLogger(SignInPages.class);
	
	@FindBy (id="login-signup-heading")
	private WebElement LBL_LoginHeader;
	
	@FindBy (id="login-signup-msg")
	private WebElement LBL_LoginMessge;
	
	@FindBy (id="loginMobile")
	private WebElement TXT_LoginMobile;
	
	@FindBy (id="loginAction")
	private WebElement BTN_Continue;
	
	@FindBy (id="loginMobile")
	private WebElement TXT_LoginPassword;
	
	@FindBy (xpath="//span[starts-with(text(), 'Please enter OTP sent to your')]")
	private WebElement LBL_EnterOTP;
	
	@FindBy (id="changeLoginNumber")
	private WebElement Link_ChangeMobile;
	
	@FindBy (xpath="//input[@class='otp-input'][1]")
	private WebElement TXT_OtpPart1;

	@FindBy (xpath="//input[@class='otp-input'][2]")
	private WebElement TXT_OtpPart2;

	@FindBy (xpath="//input[@class='otp-input'][3]")
	private WebElement TXT_OtpPart3;

	@FindBy (xpath="//input[@class='otp-input'][4]")
	private WebElement TXT_OtpPart4;

	@FindBy (id="verifyOtpAction")
	private WebElement BTN_Login;
	
	@FindBy (xpath="//span[text()=\"Didn't recieve OTP?\"]")
	private WebElement LBL_NotRecieveOTP;
	
	@FindBy (xpath="//span[text()='Resend OTP']")
	private WebElement Link_ResendOTP;

	public SignInPages(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void setMobile(String mobile)
	{
		try
		{
			verifyElementPresent(TXT_LoginMobile);
			TXT_LoginMobile.sendKeys(mobile);
		}
		catch(Exception ex) 
		{
			log.error("" + ex);
		}
	}
	
	public void clickContinue()
	{
		try
		{
			verifyElementPresent(BTN_Continue);
			BTN_Continue.click();
			log.info("");
		}
		catch(Exception ex) 
		{
			log.error("" + ex);
		}
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
				//System.out.println(a[i+1]);
			}
			
			verifyElementPresent(TXT_OtpPart1);
			verifyElementPresent(TXT_OtpPart2);
			verifyElementPresent(TXT_OtpPart3);
			verifyElementPresent(TXT_OtpPart4);
			
			TXT_OtpPart1.sendKeys(Integer.toString(a[0]));
			TXT_OtpPart2.sendKeys(Integer.toString(a[1]));
			TXT_OtpPart3.sendKeys(Integer.toString(a[2]));
			TXT_OtpPart4.sendKeys(Integer.toString(a[3]));
			
			verifyElementPresent(BTN_Login);
			BTN_Login.click();
		}
		catch(Exception ex) 
		{
			log.error("" + ex);
		}
	}

	public void clickOnLogin()
	{
		try
		{
			verifyElementPresent(BTN_Login);
			BTN_Login.click();
			log.info("Click on Login Button.");
		}
		catch(Exception ex) 
		{
			log.error("" + ex);
		}
	}
	
}
