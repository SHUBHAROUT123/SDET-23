package com.crm.vtiger.GenericUtils;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.google.common.io.Files;

public class WebDriverUtility extends FileUtility {
	/**
	 * This menthod wait for 20s for page loading
	 * 
	 * @param driver
	 */
	public void waitUntilPageLoad(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}

	/**
	 * this method wait for the element for visible
	 * 
	 * @param element
	 * @param driver
	 */
	public void waitForElementVisibility(WebElement element, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	/**
	 * this method is used for the element to be clicked
	 * 
	 * @param element
	 * @throws InterruptedException
	 */
	public void waitAndClick(WebElement element) throws InterruptedException {
		int count = 0;
		while (count < 40) {
			try {
				element.click();
			} catch (Throwable e) {
				Thread.sleep(1000);
				count++;

			}
		}
	}

	/**
	 * This method enables user to handle dropdown using VisibleText
	 * 
	 * @param element
	 * @param option
	 */
	public void SelectOption(WebElement element, String option) {
		Select s = new Select(element);
		s.selectByVisibleText(option);
	}

	/**
	 * This method enables user to handle dropdown using index
	 * 
	 * @param element
	 * @param index
	 */
	public void SelectOption(WebElement element, int index) {
		Select s = new Select(element);
		s.selectByIndex(index);
	}

	/**
	 * This method will perform mouse hover action
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHover(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	/**
	 * This method will perform right click operation
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClick(WebDriver driver, WebElement element) {
		Actions a = new Actions(driver);
		a.contextClick(element).perform();
	}

	/**
	 * This method helps to switch from one window to another
	 * 
	 * @param driver
	 * @param partialWinTitle
	 */
	public void switchToWindow(WebDriver driver, String partialWinTitle) {
		Set<String> window = driver.getWindowHandles();
		Iterator<String> it = window.iterator();
		while (it.hasNext()) {
			String winId = it.next();
			String title = driver.switchTo().window(winId).getTitle();
			if (title.contains(partialWinTitle)) {
				break;
			}

		}
	}

	/**
	 * Accept alert
	 * 
	 * @param driver
	 */
	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	/**
	 * Cancel Alert
	 * 
	 * @param driver
	 */
	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	/**
	 * This method is used for scrolling action in a webpage
	 * 
	 * @param driver
	 * @param element
	 */
	public void scrollToWebElement(WebDriver driver, WebElement element) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		int y = element.getLocation().getY();
		js.executeScript("window.scrollBy(0," + y + ")", element);
	}

	public void switchFrame1(WebDriver driver, String index) {
		driver.switchTo().frame(index);
	}

	public void switchFrame(WebDriver driver, String element) {
		driver.switchTo().frame(element);
	}

	public String takeScreenshot(String screenshotName, WebDriver driver) throws IOException {
		String ss = "./screenshot/" + screenshotName + JavaUtility.getCurrentDate() + ".PNG";
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(ss);
		Files.copy(src, dest);
		return ss;
	}

	public void pressEnterKey() throws AWTException {
		Robot r = new Robot();
		r.keyPress(KeyEvent.VK_ENTER);
		r.keyRelease(KeyEvent.VK_ENTER);

	}

	public void maximize(WebDriver driver) 
	{
		driver.manage().window().maximize();
	}
}
