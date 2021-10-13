package com.Vtiger.testScript;

import org.testng.annotations.Test;

import com.crm.vtiger.GenericUtils.Base;
import com.vtiger.comcast.pomrepositorylib.CreateNewLead;
import com.vtiger.comcast.pomrepositorylib.Home;
import com.vtiger.comcast.pomrepositorylib.Lead;
import com.vtiger.comcast.pomrepositorylib.LeadInfo;

public class TC_01CreateLead extends  Base
{
	@Test    
	public void TestCase_11() throws Throwable 
	{
	    
		
		Home h = new Home(driver);
		h.getLeads().click();

		Lead ld = new Lead(driver);
		ld.CreateLead().click();

		String FN = eLib.getExcelData("Sheet1", 1, 1);
		String LN = eLib.getExcelData("Sheet1", 1, 2);
		String CM = eLib.getExcelData("Sheet1", 1, 3);
		String AR = eLib.getExcelData("Sheet1", 1, 4);
		
		CreateNewLead cnl = new CreateNewLead(driver);
		cnl.leadDetails(FN, LN, CM, AR);
		
		LeadInfo li = new LeadInfo(driver);
		li.verifyLeadInfo(FN);
		
}
}
