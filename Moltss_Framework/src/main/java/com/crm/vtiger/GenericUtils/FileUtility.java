package com.crm.vtiger.GenericUtils;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class FileUtility {
	/**
	 * 
	 * @author Naina
	 * @param Key
	 * @return
	 * @throws Throwable
	 */
	public String getPropertyKeyVAlue(String Key) throws Throwable{
		FileInputStream fis=new FileInputStream(IPathConstant.PROPERTY_FILEPATH);
		Properties p=new Properties();
		p.load(fis);
		return p.getProperty(Key);
		
	}
	/**
	 * 
	 * @param key
	 * @return
	 * @throws IOException
	 * @throws ParseException
	 */
	
	public String getJsonKeyValue(String key) throws IOException, ParseException
	{
		
		
		FileReader reader =new FileReader(IPathConstant.JSONFILEPATH);
		JSONParser parser= new JSONParser();
		Object ob=parser.parse(reader);
		
		JSONObject Jb=(JSONObject)ob;
		String value=Jb.get(key).toString();
		
		return value;
		
	}

}
