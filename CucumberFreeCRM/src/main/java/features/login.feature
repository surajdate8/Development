Feature: Testing FREECRM login functionality

Scenario: Test login 
	Given user in on login page
	When user will enter user id and password
	Then user hit login button
	Then user will landed to HOME page