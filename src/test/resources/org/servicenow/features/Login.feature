Feature: Login verification and User Registration

  Scenario: An existing user try to login, he should be successfully logged in and shown user details
  	Given User landed on home page
  	And User logs in with username as "admin" and password as "admin"
  	Then User should be logged in as "admin"
  	
  Scenario: A new user tries to register, then he should be able to successfully registered
  	Given User landed on home page
  	And User clicks on Register new Account
  	When User registers with login as "automation", email as "automation@automation.com" and password as "Subodh@26"
  	Then User should be successfully registered
  	
  Scenario: An existing user tries to reset the password, then he should successfully be able to do that
  	Given User landed on home page
  	And User clicks on forgot password
  	When User gives email id as "admin@test.com" to reset the password
  	Then User should get mail about resetting the password