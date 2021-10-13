package com.vtiger.comcast.pomrepositorylib;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateNewLead 
{

	WebDriver driver;	
	
	public CreateNewLead(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	
	@FindBy(name="firstname")
	private WebElement firstname;
		
	
	@FindBy(name="lastname")
	private WebElement lastname;
	
	@FindBy(name="company")
	private WebElement company;
	
	@FindBy(name="email")
	private WebElement email;
	
	@FindBy(name="secondaryemail")
	private WebElement secondaryemail;
	
	@FindBy(name="noofemployees")
	private WebElement noofemployees;
	
	@FindBy(name="annualrevenue")
	private WebElement annual_revenue;
	
	@FindBy(name="bill_country")
	private WebElement bill_country;
	
	
	@FindBy(name="bill_street")
	private WebElement bill_street;
	
	@FindBy(name="bill_pobox")
	private WebElement bill_pobox;
	
	@FindBy(name="bill_city")
	private WebElement bill_city;
	
	@FindBy(name="bill_state")
	private WebElement bill_state;
	
	@FindBy(name="bill_code")
	private WebElement bill_code;
	
	@FindBy(name="description")
	private WebElement description;

	@FindBy(name="button")
	private WebElement button;
	
	

	public WebElement getFirstname() {
		return firstname;
	}


	public WebElement getLastname() {
		return lastname;
	}


	public WebElement getCompany() {
		return company;
	}


	public WebElement getEmail() {
		return email;
	}


	public WebElement getSecondaryemail() {
		return secondaryemail;
	}


	public WebElement getNoofemployees() {
		return noofemployees;
	}


	public WebElement getAnnual_revenue() {
		return annual_revenue;
	}


	public WebElement getBill_country() {
		return bill_country;
	}


	public WebElement getBill_street() {
		return bill_street;
	}


	public WebElement getBill_pobox() {
		return bill_pobox;
	}


	public WebElement getBill_city() {
		return bill_city;
	}


	public WebElement getBill_state() {
		return bill_state;
	}


	public WebElement getBill_code() {
		return bill_code;
	}


	public WebElement getDescription() {
		return description;
	}


	public WebElement getButton() {
		return button;
	}
	
	

	
	public void leadDetails(String Firstname, String Lastname , String Company, String Annual_revenue )
	{
		getFirstname().sendKeys(Firstname);
		getLastname().sendKeys(Lastname);
		getCompany().sendKeys(Company);
		getAnnual_revenue().sendKeys(Annual_revenue);	
		getButton().click();
	
	}
	public void leadDetails1(String Firstname, String Lastname , String Company, String NoOFEmployee )
	{
		getFirstname().sendKeys(Firstname);
		getLastname().sendKeys(Lastname);
		getCompany().sendKeys(Company);
		getNoofemployees().sendKeys(NoOFEmployee);	
		getButton().click();
	
	}
	
	public void leadDetails2(String Firstname, String Lastname , String Company, String Email, String SEMail )
	{
		getFirstname().sendKeys(Firstname);
		getLastname().sendKeys(Lastname);
		getCompany().sendKeys(Company);
		getEmail().sendKeys(Email);	
		getSecondaryemail().sendKeys(SEMail);	
		getButton().click();
	
	}
	

}
