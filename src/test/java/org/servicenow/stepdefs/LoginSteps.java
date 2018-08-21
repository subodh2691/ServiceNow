package org.servicenow.stepdefs;

import org.servicenow.actions.LoginPageActions;
import org.servicenow.objectrepo.LandingPageObjects;
import org.servicenow.resources.PrePostSteps;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class LoginSteps 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public LoginSteps (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}

	@Given("^Wait for (\\d+) milli-seconds$")
	public void wait_app(int milliSec)
	{

		try {
			Thread.sleep(milliSec);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@Given("^User landed on home page$")
	public void click_home()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("User unable to click on home",login.clickHome());
	}
	
	@When("^User logs in with username as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void login_user_with_credentials(String username, String password)
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to login with given credentials",login.login(username, password));
	}
	
	@Then("^User should be logged in as \"([^\"]*)\"$")
	public void login_verify(String user)
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("User logged in with different user",login.login_verify(user));
	}
	
	@After
	@And("^User clicks on logout link$")
	public void click_logout()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("User unable to logout",login.logout());
	}
	
	@When("^User clicks on Register new Account$")
	public void register_new_account()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to click on register",login.click_register_link());
	}
	
	@And("^User registers with login as \"([^\"]*)\", email as \"([^\"]*)\" and password as \"([^\"]*)\"$")
	public void register_account(String user, String email, String password)
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to register new user",login.register_new_account(user, email, password));
	}
	
	@Then("^User should be successfully registered$")
	public void verify_registration()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to Register",login.verify_registration_successful());
	}
	
	@Given("^User clicks on forgot password$")
	public void click_forget_passord()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to click on forget password",login.click_forgot_password());
	}
	
	@When("^User gives email id as \"([^\"]*)\" to reset the password$")
	public void enter_email(String email)
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to enter mail id",login.forgot_password(email));
	}
	
	@Then("^User should get mail about resetting the password$")
	public void verify_reset()
	{
		LoginPageActions login = new LoginPageActions(prePostSteps);
		Assert.assertTrue("Unable to Reset password due to an error",login.verify_password_reset());
	}
}
