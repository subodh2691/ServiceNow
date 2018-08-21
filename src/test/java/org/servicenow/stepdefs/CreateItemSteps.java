package org.servicenow.stepdefs;

import org.servicenow.actions.CreateItemActions;
import org.servicenow.actions.LoginPageActions;
import org.servicenow.objectrepo.LandingPageObjects;
import org.servicenow.resources.PrePostSteps;

import com.mongodb.operation.CreateCollectionOperation;

import cucumber.api.Scenario;
import cucumber.api.java.en.*;
import junit.framework.Assert;

public class CreateItemSteps 
{
	private PrePostSteps prePostSteps;
	public Scenario scenario;
//	public CreateTestReport testReport;
	
	public CreateItemSteps (PrePostSteps prePostSteps){
		this.prePostSteps = prePostSteps;
	}
	
	@Given("^User selects Branch from Entities Dropdown$")
	public void select_branch_menu()
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("Unable to select branch from menu",branch.click_branch());
	}
	
	@Given("^User selects Staff from Entities Dropdown$")
	public void select_staff_menu()
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("Unable to select branch from menu",branch.click_staff());
	}
	
	@When("^User creates a new branch with name as \"([^\"]*)\" and code as \"([^\"]*)\"$")
	public void create_branch(String name, String code)
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("User unable to create new branch",branch.createBranch(name, code));
	}
	
	@When("^User creates a new staff with name as \"([^\"]*)\" and branch as \"([^\"]*)\"$")
	public void create_staff(String name, String Branch)
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("User unable to create new branch",branch.createStaff(name, Branch));
	}
	
	@When("^User search for a (branch|staff) with name \"([^\"]*)\"$")
	public void search_branch_staff(String ignore, String name)
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("User unable to search for a branch or staff",branch.search(name));
	}
	
	@When("^User wants to view details of a (branch|staff) with name as \"([^\"]*)\" and (code|branch) as \"([^\"]*)\"$")
	public void view_details(String ignore, String name,String ignore1, String code)
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("User unable to view the created branch",branch.viewDetails(name, code));
	}
	
	@When("^User wants to edit details of a (branch|staff) \"([^\"]*)\" with new name as \"([^\"]*)\" and (code|branch) as \"([^\"]*)\"$")
	public void edit_details(String ignore, String name, String newName, String ignore1, String code)
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("User unable to edit the created branch",branch.editBranchOrStaff(name, newName, code));
	}
	
	@When("^User wants to delete a (branch|staff) with name as \"([^\"]*)\"$")
	public void delete_item(String ignore, String name)
	{
		CreateItemActions branch = new CreateItemActions(prePostSteps);
		Assert.assertTrue("User unable to delete the created branch",branch.deleteItem(name));
	}
}
