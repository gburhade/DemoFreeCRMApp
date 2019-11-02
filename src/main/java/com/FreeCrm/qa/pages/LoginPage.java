package com.FreeCrm.qa.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCrm.qa.Base.TestBase;
import com.FreeCrm.qa.Util.TestUtil;

public class LoginPage extends TestBase
{
	// PageFactory - Object repository
	
	@FindBy(name="username")
	WebElement username;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@class='btn btn-small']")
	WebElement loginbutton;
	
	@FindBy(xpath="//a[@class='navbar-brand']//img[@class='img-responsive']")
	WebElement crmlogo;
	
	@FindBy(xpath="//button[@class='btn']")
	WebElement signuplink;
		
	// Initializing the objects
	public LoginPage() throws Exception
	{
		PageFactory.initElements(driver,this);
	}
	
	// Actions
	
	public String ValidatepageTitle()
	{
		return driver.getTitle();
	}
	
	public boolean ValidateCrmlogo()
	{
		return crmlogo.isDisplayed();
	}
	
	public HomePage Login(String un , String pwd) throws Exception
	{
		username.sendKeys(un);
		password.sendKeys(pwd +Keys.ENTER);
		return new HomePage();
	}

}
