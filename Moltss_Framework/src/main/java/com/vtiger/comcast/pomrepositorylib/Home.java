package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class Home extends WebDriverUtility{
	
	public Home(WebDriver driver)
	{
		PageFactory.initElements(driver, this );
		
	}
	

	
	@FindBy(xpath="(//img[@src='themes/softed/images/user.PNG]")
	private WebElement admin;
	
	
	@FindBy(linkText ="Sign Out")
	private WebElement signoutbtn;
	
	@FindBy(xpath="//a[.='Leads']")
	private WebElement Leads;
	
	
	public WebElement getAdmin() {
		return admin;
	}


	public WebElement getsgnoutbtn() {
		return signoutbtn;
	}

	public WebElement getLeads() {
		return Leads;
	}
	

	public void signout(WebDriver driver)
	{
		mouseHover(driver, admin);
		signoutbtn.click();
		
	}

}
