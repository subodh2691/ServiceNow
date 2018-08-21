package org.servicenow.actions;


import org.servicenow.objectrepo.LandingPageObjects;
import org.servicenow.resources.PrePostSteps;
import org.servicenow.resources.Reporter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPageActions {

	private PrePostSteps prePostSteps;
	private WebDriver driver;
	private WebDriverWait wait;

	public LoginPageActions(PrePostSteps obj) {
		prePostSteps = obj;
		driver = obj.driver;
		wait = obj.wait;
		// this.test=testReport.test;
	}
	
	public boolean clickHome() {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLanding.MenuItem("Home"))).click();
			wait.until(ExpectedConditions.visibilityOf(objLanding.LoginType("login"))).isDisplayed();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean login(String Username, String Password) {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLanding.LoginType("login"))).click();
			wait.until(ExpectedConditions.visibilityOf(objLanding.userName)).clear();
			objLanding.userName.sendKeys(Username);
			objLanding.password.clear();
			objLanding.password.sendKeys(Password);
			objLanding.btnAuthenticate.click();
			
			wait.until(ExpectedConditions.visibilityOf(objLanding.SuccessLogin)).isDisplayed();
			objLanding.SuccessLogin.getText().contains("logged in as user \"" + Username +"\"");
	        return true;
		}
		
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}	
	}
	
	public boolean login_verify(String user) {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLanding.SuccessLogin)).isDisplayed();
			objLanding.SuccessLogin.getText().contains("logged in as user \"" + user +"\"");
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
        
	}
	
	public boolean click_forgot_password() {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			wait.until(ExpectedConditions.visibilityOf(objLanding.LoginType("login"))).click();
			wait.until(ExpectedConditions.visibilityOf(objLanding.LoginType("forget"))).click();
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean forgot_password(String email) {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			
			wait.until(ExpectedConditions.visibilityOf(objLanding.inputField("email"))).clear();
			objLanding.inputField("email").sendKeys(email);
			
			wait.until(ExpectedConditions.visibilityOf(objLanding.btnAuthenticate)).click();
			
			return true;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean verify_password_reset() {
		
		LandingPageObjects objLanding = new LandingPageObjects(driver);
		try {
			
			if((objLanding.SuccessReset).isDisplayed()) {
				Reporter.addStepLog("User is successfully able to reset password");
				return true;
			}
			Reporter.addStepLog("Unable to reset password the user due to error");
			PrePostSteps.capture();
			return false;
		}
		catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean click_register_link() {
			
			LandingPageObjects objLanding = new LandingPageObjects(driver);
			try {
				
				wait.until(ExpectedConditions.visibilityOf(objLanding.LoginType("Register"))).click();
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean register_new_account(String login, String email, String password) {
			
			LandingPageObjects objLanding = new LandingPageObjects(driver);
			try {
				
				wait.until(ExpectedConditions.visibilityOf(objLanding.inputField("login"))).isDisplayed();
				objLanding.inputField("login").clear();
				
				objLanding.inputField("login").sendKeys(login);
				objLanding.inputField("email").clear();
				objLanding.inputField("email").sendKeys(email);
				objLanding.inputField("password").sendKeys(password);
				objLanding.inputField("confirmPassword").sendKeys(password);
				
				wait.until(ExpectedConditions.visibilityOf(objLanding.btnAuthenticate)).click();
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		
	public boolean verify_registration_successful() {
			
			LandingPageObjects objLanding = new LandingPageObjects(driver);
			try {
				
				if((objLanding.userRegistrationSuccess).isDisplayed()) {
					Reporter.addStepLog("User is able to register on the website");
					return true;
				}
				Reporter.addStepLog("Unable to register the user due to error");
				PrePostSteps.capture();
				return false;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
	}
	
	public boolean logout() {
			
			LandingPageObjects objLanding = new LandingPageObjects(driver);
			try {
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Account"))).click();
				wait.until(ExpectedConditions.visibilityOf(objLanding.btnOperation("Log out"))).click();
				return true;
			}
			catch(Exception e) {
				e.printStackTrace();
				return false;
			}
		}
}
