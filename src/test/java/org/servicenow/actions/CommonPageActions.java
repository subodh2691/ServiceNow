package org.servicenow.actions;

import org.servicenow.resources.PrePostSteps;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonPageActions {
	
	
	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;	
	
	public CommonPageActions(PrePostSteps obj)
	{
		prePostSteps=obj;
		driver=obj.driver;
		wait=obj.wait;
//		this.test=testReport.test;
	}
	
	public void acceptAlert()
	{
		driver.switchTo().alert().accept();
	}
	
	public void ClearField(WebElement element)
	{
		
	    try {
	    	Actions navigator = new Actions(driver);
		    navigator.click(element);
			Thread.sleep(2000);
		    navigator.doubleClick(element);
			Thread.sleep(2000);
			 navigator.sendKeys(Keys.END)
			 	.keyDown(Keys.SHIFT)
		        .sendKeys(Keys.ARROW_UP)
		        .keyUp(Keys.SHIFT)
		        .sendKeys(Keys.DELETE);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	   
	}
	
}
