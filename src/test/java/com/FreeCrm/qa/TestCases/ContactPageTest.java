package com.FreeCrm.qa.TestCases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.FreeCrm.qa.Base.TestBase;
import com.FreeCrm.qa.Util.TestUtil;
import com.FreeCrm.qa.pages.ContactPage;
import com.FreeCrm.qa.pages.HomePage;
import com.FreeCrm.qa.pages.LoginPage;

public class ContactPageTest extends TestBase 
{
	
	LoginPage loginpage;
	TestUtil testutil;
	HomePage homepage;
	ContactPage contactpage;
	
	public ContactPageTest() throws Exception {
		super();
	}
	
	@BeforeMethod
	public void setUp() throws Exception
	{
		initialization();
		loginpage = new LoginPage();
		testutil = new TestUtil();
		homepage = new HomePage();
		contactpage = new ContactPage();
		loginpage.Login(prop.getProperty("username"), prop.getProperty("password"));
		testutil.SwitchToFrame();
		contactpage = homepage.clickonContactspagelink();
	}
	
	@Test(priority=1)
	public void VerifyContactpagelabel()
	{
		Assert.assertTrue(contactpage.VerifycontactpageLabel(),"contact page label is missing");
	}
	
	@Test(priority=2)
	public void SelectSingleCheckboxforNameTest()
	{
		contactpage.SelectcontactbyName("Adminskm nvnvewn");
	}
	
	@Test(priority=3)
	public void SelectMultiplecheckboxesByname()
	{
		contactpage.SelectcontactbyName("atest btest");
		contactpage.SelectcontactbyName("atesting btesting");
		contactpage.SelectcontactbyName("aaa ccc");
	}
	
	@DataProvider
	public Object[][] GetCRMData()
	{
		Object[][] data = TestUtil.GetTestData("ContactList");
		return data;
	}
	
	@Test(priority=4, dataProvider="GetCRMData")
	public void FillNewContactDetails(String title, String fname, String lstname, String company)
	{
		homepage.clickonNewContactLink();
		contactpage.CreateNewContact(title,fname,lstname,company);
		
	}
	
	@AfterMethod
	public void teardown()
	{
		driver.close();
	}
	
	

}
