package com.FreeCrm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.FreeCrm.qa.Base.TestBase;
import com.FreeCrm.qa.Util.TestUtil;
import com.FreeCrm.qa.pages.ContactPage;
import com.FreeCrm.qa.pages.HomePage;
import com.FreeCrm.qa.pages.LoginPage;

public class HomePageTest extends TestBase
{
	LoginPage loginpage;
	TestUtil testutil;
	HomePage homepage;
	ContactPage contactpage;

	public HomePageTest() throws Exception 
	{
		super();
	}
	
	//Test Cases should be independent of each other
	//Before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	@BeforeMethod
	public void Setup() throws Exception
	{
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		contactpage = new ContactPage();
		homepage = loginpage.Login(prop.getProperty("username"),prop.getProperty("password"));
	}
	
	@Test(priority=1)
	public void homepagetitletest() throws Exception
	{
	    String homepagetitle = homepage.ValidateHomepageTitle();
        Assert.assertEquals(homepagetitle, "CRMPRO","Home page title not Matched");	
	}
	
	@Test(priority=2)
	public void VerifyUserNameLabelTest()
	{
		testutil.SwitchToFrame();
		Assert.assertTrue(homepage.VerifyUserNameLable());
	}
	
	@Test(priority=3)
	public void clickonContactpagelinktest() throws Exception
	{
		testutil.SwitchToFrame();
	    contactpage = homepage.clickonContactspagelink();
	}
	
	
	
		
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	

}
