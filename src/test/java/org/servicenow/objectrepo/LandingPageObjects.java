package org.servicenow.objectrepo;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPageObjects {

	WebDriver driver;
	
	public LandingPageObjects (WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
//	@FindBy(xpath="//a[contains(text(),'Register a new account')]")
//	public WebElement newAccount;
//	
//	@FindBy(xpath="//a[contains(text(),'login')]")
//	public WebElement login;
	
	String menuItem = "//span[text()='Menu']";
	public WebElement MenuItem(String item) {
        return driver.findElement(By.xpath(menuItem.replace("Menu", item)));
	}
	
	String button = "//span[contains(text(),'Type')]/..";
	public WebElement btnOperation(String operation) {
        return driver.findElement(By.xpath(button.replace("Type", operation)));
	}
	
	@FindBy(id="username")
	public WebElement userName;
	
	@FindBy(id="password")
	public WebElement password;
	
	@FindBy(xpath="//button[@type='submit']")
	public WebElement btnAuthenticate;
	
	
	@FindBy(id="rememberMe")
	public WebElement rememberMe;
	
	@FindBy(xpath="//div[@translate='main.logged.message']")
	public WebElement SuccessLogin;
	
	@FindBy(xpath="//div[contains(@class,'success')]")
	public WebElement SuccessReset;
	
	String elemAccount="//a[contains(text(),'loginType')]";
	public WebElement LoginType(String type) {
        return driver.findElement(By.xpath(elemAccount.replace("loginType", type)));
	}
	
	@FindBy(xpath="//div[@ng-show='success']")
	public WebElement userRegistrationSuccess;
	
	@FindBy(id="searchQuery")
	public WebElement srchQuery;
	
	@FindBy(xpath="//select[@name='related_branch']")
	public WebElement slctBranch;
	
	@FindBy(xpath="//table//tr//td[2]")
	public List <WebElement> tableData;
	
	String elemDataButton="//table//tr//td[text()='Data']/following-sibling::td//span[text()='Button']/..";
	public WebElement DataButton(String Input, String Operation) {
		elemDataButton = elemDataButton.replace("Data", Input);
		return driver.findElement(By.xpath(elemDataButton.replace("Button", Operation)));
	}
	
	String elemInputValue="//table//tr//td[contains(.,'InputType')]/following-sibling::td/input";
	public WebElement InputValue(String Input) {
		return driver.findElement(By.xpath(elemInputValue.replace("InputType", Input)));
	}
	
	String elemInputField="//input[@name='Input']";
	public WebElement inputField(String type) {
        return driver.findElement(By.xpath(elemInputField.replace("Input", type)));
	}

}
