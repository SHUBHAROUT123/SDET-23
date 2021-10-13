package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.vtiger.GenericUtils.FileUtility;
public class Login extends FileUtility{
	

	@FindBy(name="user_name")
	private WebElement username;
	
	@FindBy(name="user_password")
	 private WebElement password;
	
	@FindAll({@FindBy(id="submitButton")})
	private WebElement loginbtn;
	
	
	
	
	
		public Login(WebDriver driver )
		{
			
			PageFactory.initElements(driver, this );
		}
	
	public void loginToApp(String un , String pw) throws Throwable
	
	{
		
		username.sendKeys(un);
		password.sendKeys(pw);
		loginbtn.click();
		
		
	}


}
