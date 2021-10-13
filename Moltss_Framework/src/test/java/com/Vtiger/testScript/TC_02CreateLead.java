package com.Vtiger.testScript;

import org.junit.Assert;
import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.Base;
import com.vtiger.comcast.pomrepositorylib.CreateNewLead;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Lead;




public class TC_02CreateLead extends Base {
	@Test
	public void TestCase_12() throws Throwable {
		Home h = new Home(driver);
		h.getLeads().click();

		Lead ld = new Lead(driver);
		ld.CreateLead().click();

		String FN = eLib.getExcelData("Sheet1", 4, 1);
		String LN = eLib.getExcelData("Sheet1", 4, 2);
		String CM = eLib.getExcelData("Sheet1", 4, 3);
		String AR = eLib.getExcelData("Sheet1", 4, 4);
		
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.leadDetails(FN, LN, CM, AR);
		
		



		String aT = driver.switchTo().alert().getText();
		driver.switchTo().alert().accept();
		
		String eT = "Invalid Annual Revenue";
		Assert.assertEquals(aT, eT);
		System.out.println("Test Case Passed");

		
	}
}