package wdcmds;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import com.aventstack.extentreports.MediaEntityBuilder;

import config.StartBrowser;

public class ActionDriver {

	WebDriver driver;

	public ActionDriver() {
		driver = new StartBrowser().driver;
	}

	/**
	 * 
	 * @param url
	 */
	public void navigateApplication(String url) {

		try {
			driver.get(url);
			StartBrowser.childTest.pass("Successfully lauched url" + url);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Failed to lauched url" + url);
		}
	}

	/**
	 * 
	 * @param locator
	 * @param eleName
	 * @throws Exception
	 */

	public void click(By locator, String eleName) throws Exception {

		try {
			driver.findElement(locator).click();
			StartBrowser.childTest.pass("Successfully clicked" + eleName);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Failed to click " + eleName,
					MediaEntityBuilder.createScreenCaptureFromBase64String("base64String").build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}

	/**
	 * 
	 * @param locator
	 * @param value
	 * @param eleName
	 * @throws Exception
	 */
	public void type(By locator, String value, String eleName) throws Exception {

		try {
			driver.findElement(locator).sendKeys(value);
			StartBrowser.childTest.pass("Successfully data entered into :" + eleName + " with data :" + value);
		} catch (Exception e) {
			StartBrowser.childTest.fail("Failed to enter data : " + eleName + " with data :" + value,
					MediaEntityBuilder.createScreenCaptureFromBase64String("base64String").build());
			StartBrowser.childTest.info(e);
			throw e;
		}

	}
	
	public String getText(By locator) throws Exception {
		
		try {
			String value =driver.findElement(locator).getText();
			StartBrowser.childTest.pass("Text is :" +value);
			return value;
		}
		catch(Exception e){
			StartBrowser.childTest.fail("unable to get text :", MediaEntityBuilder.createScreenCaptureFromBase64String("base64String").build());
			return null;
		}
	}
	
	public void mouseover(By locator , String eleName) throws Exception {

		try {
			Actions action=new Actions(driver);
			WebElement mo=driver.findElement(locator);
			action.moveToElement(mo).perform();
			
			StartBrowser.childTest.pass("Successfully mouse moved to :" + eleName );
		} catch (Exception e) {
			StartBrowser.childTest.fail("Failed to move mouse : " + eleName ,
					MediaEntityBuilder.createScreenCaptureFromBase64String("base64String").build());
			StartBrowser.childTest.info(e);
			throw e;
		}
	}
	
}
