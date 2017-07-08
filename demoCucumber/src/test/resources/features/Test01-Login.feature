Feature: Gmail Login

Scenario: Successful Login With Valid Login Credentials
	Given User Could Browse Gmail URL
	When User Navigates To The Login Page
	Given User Has Gmail Account
	And User Enters Valid User Id And Password 
	And Clicks On Sign In
	Then Gmail Home Page Should Appear

	
	Scenario: Unsuccessful Login With InValid Login Credentials 
	Given User Could Browse Gmail URL
	When User Navigates To The Login Page
	Given User Has Gmail Account
	And User Enters Valid User Id And InValid Password 
	And Clicks On Sign In
	Then Gmail Home Page Should Not Appear
	