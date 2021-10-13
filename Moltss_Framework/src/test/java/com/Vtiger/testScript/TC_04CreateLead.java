package com.Vtiger.testScript;




import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.Base;

import com.vtiger.comcast.pomrepositorylib.CreateNewLead;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Lead;

import junit.framework.Assert;



public class TC_04CreateLead extends Base{
	@Test
	public void TestCase_14() throws Throwable {

		Home h = new Home(driver);
		h.getLeads().click();

		Lead ld = new Lead(driver);
		ld.CreateLead().click();

		String FN = eLib.getExcelData("Sheet1", 10, 1);
		String LN = eLib.getExcelData("Sheet1", 10, 2);
		String CM = eLib.getExcelData("Sheet1", 10, 3);
		String NOE = eLib.getExcelData("Sheet1", 10, 4);
		
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.leadDetails1(FN, LN, CM, NOE);
		
		String aT = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		String eT = "Invalid No Of Employees";
		Assert.assertEquals(aT, eT);
		System.out.println("Test Case Passed");
		

		
		

}
}