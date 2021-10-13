package com.Vtiger.testScript;



import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.Base;
import com.vtiger.comcast.pomrepositorylib.CreateNewLead;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Lead;
import com.vtiger.comcast.pomrepositorylib.LeadInfo;


public class TC_03CreateLead extends Base {
	@Test(groups= {"smoketest"})
	public void TestCase_13() throws Throwable {


		Home h = new Home(driver);
		h.getLeads().click();

		Lead ld = new Lead(driver);
		ld.CreateLead().click();

		String FN = eLib.getExcelData("Sheet1", 7, 1);
		String LN = eLib.getExcelData("Sheet1", 7, 2);
		String CM = eLib.getExcelData("Sheet1", 7, 3);
		String NOE = eLib.getExcelData("Sheet1", 7, 4);
		
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.leadDetails(FN, LN, CM, NOE);
		
		LeadInfo li = new LeadInfo(driver);
		li.verifyLeadInfo(FN);
		
		
}
}