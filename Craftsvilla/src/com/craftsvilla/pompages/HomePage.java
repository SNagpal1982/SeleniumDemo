package com.craftsvilla.pompages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.craftsvilla.generic.BasePage;

public class HomePage extends BasePage
{

	Actions action = null;
	Logger log = Logger.getLogger(HomePage.class);
	
	public HomePage(WebDriver driver)
	{
		super(driver);
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (id="signinAction")
	private WebElement LINK_SIGNIN;  
	
	@FindBy (xpath="//input[@placeholder='Search For Products ,Brands & More']")
	private WebElement TXT_SEARCH;
	
	@FindBy (xpath = "//span[@class='cart-profile-links']")
	private WebElement LINK_CART;
	
	@FindBy (id="notification-badge-btn")
	private WebDriver LINK_NOTIFICATION;
	
	@FindBy (id="myAccountDiv")
	private WebElement LINK_MYACCOUNT;
	
	public void clickOnSignINLink()
	{
		try 
		{
		verifyElementPresent(LINK_SIGNIN);
		LINK_SIGNIN.click();
		}
		catch(Exception ex)
		{
			log.error(""+ex);
		}
	}
	
	public void gotoMyAccount()
	{
		try 
		{
			verifyElementPresent(LINK_MYACCOUNT);
			LINK_MYACCOUNT.click();
		}
		catch(Exception ex)
		{
			log.error(""+ex);
		}
	}

	public void clickOnLogout()
	{
		try 
		{
			verifyElementPresent(LINK_MYACCOUNT);
			LINK_MYACCOUNT.click();
		}
		catch(Exception ex)
		{
			log.error(""+ex);
		}
	}
	
}
