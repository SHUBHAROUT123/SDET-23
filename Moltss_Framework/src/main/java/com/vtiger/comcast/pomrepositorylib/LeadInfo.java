package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import junit.framework.Assert;

public class LeadInfo 
{

	public LeadInfo(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement leadInfoTitle;
	
	
	
	public WebElement getLeadInfoTitle() {
		return leadInfoTitle;
	}

	
		public void verifyLeadInfo( String expectedTitle)
	{
		String actualTitle=leadInfoTitle.getText();
		Assert.assertTrue(actualTitle.contains(expectedTitle));
		
	}
		
}
