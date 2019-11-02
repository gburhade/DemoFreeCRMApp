package com.FreeCrm.qa.TestCases;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCrm.qa.Base.TestBase;
import com.FreeCrm.qa.pages.HomePage;
import com.FreeCrm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase
{
	LoginPage loginpage;
	HomePage homepage;
	
	public LoginPageTest() throws Exception
	{
		super();
	}
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		initialization();
		loginpage = new LoginPage();
	}
	
	@Test(priority=1)
	public void LoginPageTitletest()
	{
		String title = loginpage.ValidatepageTitle();
		AssertJUnit.assertEquals(title, "CRMPRO - CRM software for customer relationship management, sales, and support.");
	}
	
	@Test(priority=2)
	public void ValidateCRMLogo()
	{
		boolean logoavailability = loginpage.ValidateCrmlogo();
		AssertJUnit.assertTrue(logoavailability);
	}
	
	@Test(priority=3)
	public void Logintest() throws Throwable 
	{
		String usernm = prop.getProperty("username");
		String pswd = prop.getProperty("password");
	   homepage = loginpage.Login(usernm,pswd);
	}

	
	@AfterMethod
	public void TearDown()
	{
		driver.close();
	}
}
