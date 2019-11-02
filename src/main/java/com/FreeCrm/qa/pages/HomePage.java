package com.FreeCrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.FreeCrm.qa.Base.TestBase;

public class HomePage extends TestBase
{
	
 @FindBy(xpath="//td[contains(text(),'User: naveen k')]")
 WebElement userNamelabel;
 
 @FindBy(xpath="//a[text()='Contacts']")
 WebElement contactspagelink;
 
 @FindBy(xpath="//a[text()='New Contact']")
 WebElement newcontactlink;
 
 @FindBy(xpath="//a[text()='Deals']")
 WebElement dealspagelink;
 
 @FindBy(xpath="//a[text()='Tasks']")
WebElement taskpagelink;
 
 public HomePage() throws Exception
 {
	 PageFactory.initElements(driver, this);
 }
 
 public String ValidateHomepageTitle()
 {
	 return driver.getTitle();
 }
 
 public boolean VerifyUserNameLable()
 {
	return userNamelabel.isDisplayed();
 }
 
 public ContactPage clickonContactspagelink() throws Exception
 {
	 contactspagelink.click();
	 return new ContactPage();
 }
 
 public void clickonNewContactLink()
 {
	 Actions action = new Actions(driver);
	 action.moveToElement(contactspagelink).build().perform();
	 newcontactlink.click();
 }
 
 public DealPage clickonDealspagelink()
 {
	 dealspagelink.click();
	 return new DealPage();
 }
 
 public TaskPage clickonTaskpagelink()
 {
	 taskpagelink.click();
	 return new TaskPage();
 }

	

}
