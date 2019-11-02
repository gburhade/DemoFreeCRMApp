package com.FreeCrm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.FreeCrm.qa.Base.TestBase;

public class ContactPage extends TestBase 
{
	
	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactlable;
	
	@FindBy(name="title")
	WebElement title;
	
	@FindBy(id="first_name")
	WebElement firstname;
	
	@FindBy(id="surname")
	WebElement surname;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//td[@align='center' and @valign='top' and @colspan='2']/child::input[2]")
	WebElement savebtn;
	
	public ContactPage() throws Exception 
	{
		PageFactory.initElements(driver, this);
	}
	
   public boolean VerifycontactpageLabel()
   {
	   return contactlable.isDisplayed();
   }
   
   public void SelectcontactbyName(String name)
   {
	   driver.findElement(By.xpath("//a[text()='"+name+"']//parent::td[@class='datalistrow']"
	   		+ "//preceding-sibling::td[@class='datalistrow']//input[@name='contact_id']")).click();
   }
	
   public void CreateNewContact(String Title, String fname, String lstname, String comp)
   {
	   Select sel = new Select(title);
	   sel.selectByVisibleText(Title);
	   
	   firstname.sendKeys(fname);
	   surname.sendKeys(lstname);
	   company.sendKeys(comp);
	   savebtn.click();
   }

}
