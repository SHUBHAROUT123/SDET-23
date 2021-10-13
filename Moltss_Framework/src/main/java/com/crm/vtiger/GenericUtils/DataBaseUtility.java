package com.crm.vtiger.GenericUtils;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class DataBaseUtility
{
Connection con = null;
ResultSet result=null;
Driver driverRef;

/**
 * Connection with database is established
 * @throws Throwable
 */
public void connecToDB() throws Throwable
{
	DriverManager.registerDriver(driverRef);
	con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sdet","root","root");
	
}

/**
 * DB connection is closed
 * @throws Throwable
 */
public void closeDB()throws Throwable
{
	con.close();
	
}
}
