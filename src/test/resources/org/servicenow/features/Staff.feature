Feature: Create, View, Edit and Delete the Staff

  Scenario: An existing logs in and tries to create a staff, then he should be able to create a new staff
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Staff from Entities Dropdown
  	Then User creates a new staff with name as "servicenow" and branch as "testing"
  	
  Scenario: An existing logs in and tries to search for a staff, then he should be able to see search results
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Staff from Entities Dropdown
  	Then User search for a staff with name "servicenow"
  	
  Scenario: An existing logs in and tries to view details of a staff, then he should be able to see the staff details
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Staff from Entities Dropdown
  	Then User wants to view details of a staff with name as "servicenow" and branch as "testing"
  	
  Scenario: An existing logs in and tries to edit details of a staff, then he should be able to edit staff details
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Staff from Entities Dropdown
  	Then User wants to edit details of a staff "servicenow" with new name as "servicesubodh" and code as "testingbranch"
  	
  Scenario: An existing logs in and tries to delete a staff, then he should be able to delete it
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	And User should be logged in as "admin"
  	When User selects Staff from Entities Dropdown
  	Then User wants to delete a staff with name as "servicesubodh"