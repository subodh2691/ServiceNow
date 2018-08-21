Feature: Create, View, Edit and Delete the Branch

  Scenario: An existing logs in and tries to create a branch, then he should be able to create a new branch
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Branch from Entities Dropdown
  	Then User creates a new branch with name as "servicenow" and code as "SERVICENOW"
  	
  Scenario: An existing logs in and tries to search for a branch, then he should be able to see search results
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Branch from Entities Dropdown
  	Then User search for a branch with name "servicenow"
  	
  Scenario: An existing logs in and tries to view details of a branch, then he should be able to see the branch details
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Branch from Entities Dropdown
  	Then User wants to view details of a branch with name as "servicenow" and code as "SERVICENOW"
  	
  Scenario: An existing logs in and tries to edit details of a branch, then he should be able to edit branch details
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Branch from Entities Dropdown
  	Then User wants to edit details of a branch "servicenow" with new name as "servicesubodh" and code as "SERVNOW1"
  	
  Scenario: An existing logs in and tries to delete a branch, then he should be able to delete it
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Branch from Entities Dropdown
  	Then User wants to delete a branch with name as "servicesubodh"