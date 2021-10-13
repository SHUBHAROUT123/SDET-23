package com.crm.vtiger.GenericUtils;

import java.io.IOException;


import org.json.simple.parser.ParseException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Login;

public class Base 
{

	public DataBaseUtility dLib= new DataBaseUtility();
	public WebDriverUtility wLib= new WebDriverUtility();
	public FileUtility fLib=new FileUtility();
	public ExcelUtility eLib= new ExcelUtility();
	public JavaUtility jLib=new JavaUtility();
	public WebDriver driver ;
	/**
	 * 
	 * @throws Throwable
	 */
	
	@BeforeSuite(groups= {"smoketest","regression"})
	public void connectDB() throws Throwable
	{
		//	dLib.connecToDB();
	System.out.println("==========Connection Successsfull=========");
	
	}
	
	
	/**
	 * 
	 * @throws IOException
	 * @throws ParseException
	 */
	@Parameters(value= {"browser"})
	@BeforeClass(groups= {"smoketest", "regression"})
	public void launchBrowser(String browser) throws IOException, ParseException
	{
		
	//System.out.println("launching Browser: "+ browserValue);
		// read data from Json file
		//String BROWSER= fLib.getJsonKeyValue("browser");
		String URL= fLib.getJsonKeyValue("url");
		
		if(browser.equalsIgnoreCase("chrome"))
			driver= new ChromeDriver();
		
		if(browser.equalsIgnoreCase("firefox"))
			driver = new FirefoxDriver();
	
		else 
		{
			System.out.println("Invalid browser name");
		}
		driver.get(URL);
		System.out.println("========Browser Launch Successfully======");
		
	}
	
	
/**
 * 
 * @throws Throwable
 */
	@BeforeMethod(groups= {"smoketest"})
	public void loginToApp() throws Throwable
	{
		//read data from property file
		String USERNAME= fLib.getJsonKeyValue("username");
		String PASSWORD= fLib.getJsonKeyValue("password");
		
		//login to app
		Login l=new Login(driver);
		l.loginToApp(USERNAME, PASSWORD);
		System.out.println("======Login Successful=======");
		
	}
	
	
		@AfterMethod(groups= {"smoketest"})
	public void logoutofApp()
	{
		Home h= new Home(driver);
		h.getsgnoutbtn();
		System.out.println("========Sign Out Successful======");
	}
		
		
	@AfterClass(groups= {"smoketest"})
	public void closeBrowser()
	{
		driver.close();
		System.out.println("========Browser closed successfully======");
	}
	
	
	@AfterSuite(groups= {"smoketest"})
	public void closeDB() throws Throwable
	{
		//dLib.closeDB();
		System.out.println("=======DB connectiion closed successfuly");
	}
	
}
