package org.servicenow.resources;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.servicenow.resources.Reporter;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class PrePostSteps {
	
	public static WebDriver driver;
	public static WebDriverWait wait; 
   
	public static void setUp(String browserName){
		try {
			System.out.println("Initilizing Driver..."+ browserName);
			switch (browserName) {
			case "Firefox":
				if (driver == null) {
					driver = new FirefoxDriver();
				}
				break;
			case "IE":
				if (driver == null) {
					System.setProperty("webdriver.ie.driver","IEDriver//IEDriverServer.exe");
					driver = new InternetExplorerDriver();
				}
				break;
			case "Chrome":
				if (driver == null) {
					System.setProperty("webdriver.chrome.driver","ChromeDriver//chromedriver.exe");
					driver = new ChromeDriver();
				}
				break;
			}
			System.out.println("Deleting cookies...");
			driver.manage().deleteAllCookies();
			driver.manage().window().maximize();
			driver.get("http://localhost:8080");
			wait = new WebDriverWait(driver, 30);
			System.out.println("Driver Running");
			
		}
		catch(Exception e) {
			System.out.println("Exception Caught");
			e.printStackTrace();
		}
	}
   
	public static void afterMethod()
	{     
		System.out.println("in AfterMethod");
	        driver = getDriver();
	        if (driver == null) {
	            return;
	        }
	        driver.quit();
	        driver = null;
	        System.out.println("Closing driver");
	    }

	public static void capture() {
			// TODO Auto-generated method stub

		System.out.println("Taking and processing Screenshot");
	        try {
		    	TakesScreenshot ts = (TakesScreenshot)driver;
		        File source = ts.getScreenshotAs(OutputType.FILE);
		        String dest = System.getProperty("user.dir") +"/ErrorScreenshots/ServiceNow"+new Date().getTime()+".png";
		        System.out.println(dest);
		        File destination = new File(dest);
				FileUtils.copyFile(source, destination);
		        Reporter.addScreenCaptureFromPath(dest,"Please review attached Screenshot");
		        System.out.println("Please review attached Screenshot");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}        
	                     		
	 }
	  

	private static WebDriver getDriver() {
		// TODO Auto-generated method stub
		return driver;
	}
    
	
	public WebDriverWait getWebDriverWait(){
		return wait;
	}
}