package com.Vtiger.testScript;


import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.Base;

import com.vtiger.comcast.pomrepositorylib.CreateNewLead;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Lead;
import com.vtiger.comcast.pomrepositorylib.LeadInfo;

public class TC_05CreateLead extends Base{
	@Test(groups= {"smoketest"})
	public void TestCase_15() throws Throwable {
		Home h = new Home(driver);
		h.getLeads().click();

		Lead ld = new Lead(driver);
		ld.CreateLead().click();

		String FN = eLib.getExcelData("Sheet1", 13, 1);
		String LN = eLib.getExcelData("Sheet1", 13, 2);
		String CM = eLib.getExcelData("Sheet1", 13, 3);
		String EM = eLib.getExcelData("Sheet1", 13, 4);
		String SE = eLib.getExcelData("Sheet1", 13, 5);
		
		
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.leadDetails2(FN,LN, CM, EM, SE);
		
		LeadInfo li = new LeadInfo(driver);
		li.verifyLeadInfo(FN);

}

}
