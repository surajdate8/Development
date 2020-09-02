Feature: Application login

Scenario: Home page default login
	Given User is on netbanking landing page
	When User loing into app using "jin" and "123" 
	Then Home is poppulated
	And Cards are displayed
	
	Scenario: Home page default login
	Given User is on netbanking landing page
	When User loing into app using "jin111" and "123" 
	Then Home is poppulated
	And Cards are displayed
	
