package com.FreeCrm.qa.Base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import com.FreeCrm.qa.Util.TestUtil;
import com.FreeCrm.qa.Util.WebEventListener;

public class TestBase 
{
	public static Properties prop;
	public static WebDriver driver;
	public static EventFiringWebDriver e_driver;
	public static WebEventListener evntlistener;
	
	public TestBase() throws Exception
	{
		try{
	    prop = new Properties();
		FileInputStream ip = new FileInputStream("D:\\gb\\Eclipse Workspace\\FreeCRMAPP\\src\\main\\java\\com\\FreeCrm\\qa\\config\\Config.properties");
		prop.load(ip);
		}
		
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	
	public static void initialization() throws Exception 
	{
		String browsername = prop.getProperty("browser");
		if(browsername.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver","D:\\gb\\Drivers\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(browsername.equals("FF"))
		{
			System.setProperty("webdriver.gecko.driver","D:\\gb\\Drivers\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		e_driver = new EventFiringWebDriver(driver);
		evntlistener = new WebEventListener();
		e_driver.register(evntlistener);
		driver = e_driver;
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.Page_Load_Timeout, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.Implicit_wait, TimeUnit.SECONDS);
		driver.get(prop.getProperty("URL"));
	//	driver.get("https://classic.crmpro.com/index.html");
	}
	

}
