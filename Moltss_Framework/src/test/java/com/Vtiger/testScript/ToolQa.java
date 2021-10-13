package com.Vtiger.testScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


import com.crm.vtiger.GenericUtils.WebDriverUtility;

public class ToolQa {

	public static void main(String[] args) {
		WebDriverUtility wlib = new WebDriverUtility();
	WebDriver driver=new ChromeDriver();
	driver.get("https://demoqa.com/tool-tips");
	
	wlib.maximize(driver);
	wlib.waitUntilPageLoad(driver);
	
		WebElement elem = driver.findElement(By.xpath("//button[text()='Hover me to see']"));
		wlib.mouseHover(driver, elem);
		String txt = driver.findElement(By.xpath("//div[text()='You hovered over the Button']")).getText();
		driver.findElement(By.id("toolTipTextField")).sendKeys(txt);
		System.out.println(txt);
	
	}

}
