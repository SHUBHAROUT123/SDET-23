package com.crm.vtiger.GenericUtils;

import java.util.Date;
import java.util.Random;

public class JavaUtility {
	/**
	 * @author dell
	 */
	/**
	 * This method is generate random number to avoid duplicates
	 * @return
	 */
	
	public static String getRandomData()
	{
		Random rndm=new Random();
		int ran=rndm.nextInt(1000);
		return ""+ran;
		
	}
	/**
	 * @author dell
	 * This method is used to generate current date.
	 * @return
	 */
	public static String getCurrentDate()
	{
		Date d=new Date();
		String cd=d.toString();
		return cd;
	}
	

}
