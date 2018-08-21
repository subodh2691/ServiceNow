package org.servicenow.actions;

import java.util.ArrayList;
import java.util.List;

import org.servicenow.objectrepo.LandingPageObjects;
import org.servicenow.resources.PrePostSteps;
import org.servicenow.resources.Reporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class CreateItemActions {

	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;

	public CreateItemActions(PrePostSteps obj) {
		prePostSteps = obj;
		driver = obj.driver;
		wait = obj.wait;
		// this.test=testReport.test;
	}
	
	public boolean click_branch() {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLanding.MenuItem("Entities"))).click();
			objLanding.MenuItem("Branch").click();
			return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean click_staff() {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLanding.MenuItem("Entities"))).click();
			objLanding.MenuItem("Staff").click();
			return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean createBranch(String BranchName, String Code) {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			
			wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Create a new Branch"))).click();
			wait.until(ExpectedConditions.visibilityOf(objLanding.inputField("name"))).clear();
			objLanding.inputField("name").sendKeys(BranchName);
			objLanding.inputField("code").sendKeys(Code);
			wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Save"))).click();
			Thread.sleep(2000);
			List <WebElement> data = driver.findElements(By.xpath("//table//tr//td[2]"));
			
			List <String> Items = new ArrayList <String>();
			for(WebElement w : data) {
				Items.add(w.getText());
				System.out.println("Element is "+w.getText());
		    }
			System.out.println("Data is "+Items);
			if (Items.contains(BranchName)) {
				Reporter.addStepLog("Branch created successfully");
				return true;
			}
			else {
				Reporter.addStepLog("Branch added is not found");
				PrePostSteps.capture();
				return false;
			}
	        
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
public boolean createStaff(String StaffName, String Branch) {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			
			wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Create a new Staff"))).click();
			wait.until(ExpectedConditions.visibilityOf(objLanding.inputField("name"))).clear();
			objLanding.inputField("name").sendKeys(StaffName);
			Select select = new Select(objLanding.slctBranch);
			select.selectByVisibleText(Branch);
			objLanding.btnOperation("Save").click();
			
			Thread.sleep(2000);
			List <WebElement> data = driver.findElements(By.xpath("//table//tr//td[2]"));
			
			List <String> Items = new ArrayList <String>();
			for(WebElement w : data) {
				Items.add(w.getText());
				System.out.println("Element is "+w.getText());
		    }
			System.out.println("Data is "+Items);
			if (Items.contains(StaffName)) {
				Reporter.addStepLog("Staff created successfully");
				return true;
			}
			else {
				Reporter.addStepLog("Staff added is not found");
				PrePostSteps.capture();
				return false;
			}
	        
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}

public boolean search(String Query) {
	
	LandingPageObjects objLanding = new LandingPageObjects(driver);
	try {
		
		wait.until(ExpectedConditions.visibilityOf(objLanding.srchQuery)).clear();
		objLanding.srchQuery.sendKeys(Query);
		wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Search"))).click();
		Thread.sleep(2000);
		String Name = driver.findElement(By.xpath("//table//tr//td[2]")).getText();
		String Branch = driver.findElement(By.xpath("//table//tr//td[3]")).getText();
		
		if (Name.equals(Query) && Branch.length()>1) {
			Reporter.addStepLog("Searched query found");
			return true;
		}
		else {
			Reporter.addStepLog("Searched item not found or Branch/Code field contains null");
			PrePostSteps.capture();
			return false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		return false;
	}
}

public boolean viewDetails(String name, String branch) {
	
	LandingPageObjects objLanding = new LandingPageObjects(driver);
	try {
		wait.until(ExpectedConditions.visibilityOf(objLanding.DataButton(name,"View"))).click();
		wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Back")));
		Thread.sleep(2000);
		String branchValue = null;
		String nameValue = objLanding.InputValue("Name").getAttribute("value");
		
		if(driver.getTitle().contains("Branch")) {
			branchValue = objLanding.InputValue("Code").getAttribute("value");
		}
		else {
			branchValue = objLanding.InputValue("Branch").getAttribute("value");
		}
		System.out.println("Name is " +nameValue + " and branch/code is "+branchValue);
		System.out.println("Given Name is " +name + " and branch/code is "+branch);
		if (nameValue.equals(name) && branchValue.equals(branch)) {
			System.out.println("Value matches");
			Reporter.addStepLog("Details match");
			return true;
		}
		else {
			Reporter.addStepLog("Values doesn't match");
			PrePostSteps.capture();
			return false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		return false;
	}
}

public boolean editBranchOrStaff(String name, String newName, String branchOrcode) {
	LandingPageObjects objLanding = new LandingPageObjects(driver);
	try {
		
		wait.until(ExpectedConditions.visibilityOf(objLanding.srchQuery));
		objLanding.DataButton(name, "Edit").click();
		wait.until(ExpectedConditions.visibilityOf(objLanding.inputField("name"))).clear();
		objLanding.inputField("name").sendKeys(newName);
		if(driver.getTitle().contains("Branch")) {
			objLanding.inputField("code").clear();
			objLanding.inputField("code").sendKeys(branchOrcode);
		}
		else {
			Select select = new Select(objLanding.slctBranch);
			select.selectByVisibleText(branchOrcode);
		}
		Thread.sleep(1000);
		wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Save"))).click();
		wait.until(ExpectedConditions.visibilityOf(objLanding.srchQuery));
		Thread.sleep(2000);
		List <WebElement> data = driver.findElements(By.xpath("//table//tr//td[2]"));
		
		List <String> Items = new ArrayList <String>();
		for(WebElement w : data) {
			Items.add(w.getText());
			System.out.println("Element is "+w.getText());
	    }
		System.out.println("Data is "+Items);
		if (Items.contains(newName)) {
			Reporter.addStepLog("Entry edited successfully");
			return true;
		}
		else {
			Reporter.addStepLog("Record edited is not found");
			PrePostSteps.capture();
			return false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		return false;
	}
}

public boolean deleteItem(String name) {
	LandingPageObjects objLanding = new LandingPageObjects(driver);
	try {
		
		wait.until(ExpectedConditions.visibilityOf(objLanding.srchQuery));
		objLanding.DataButton(name, "Delete").click();
		wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Delete"))).click();
		wait.until(ExpectedConditions.visibilityOf(objLanding.srchQuery));
		
		List <WebElement> data = driver.findElements(By.xpath("//table//tr//td[2]"));
		List <String> Items = new ArrayList <String>();
		for(WebElement w : data) {
			Items.add(w.getText());
			System.out.println("Element is "+w.getText());
	    }
		System.out.println("Data is "+Items);
		if (!Items.contains(name)) {
			Reporter.addStepLog("Entry deleted successfully");
			return true;
		}
		else {
			Reporter.addStepLog("Entry is not deleted");
			PrePostSteps.capture();
			return false;
		}
	}
	catch(Exception e) {
		e.printStackTrace();
		return false;
	}
}

}
