package Scripts;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Steps {
	
	
	@Given("^open in chrome browser and url of the application$")
	public void open_in_chrome_browser_and_url_of_the_application() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("chrome browser is opened and url of the appln is opened");
	}

	@When("^entering the username and password$")
	public void entering_the_username_and_password() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	   System.out.println("username and password is entered"); 
	}

	@Then("^login is successful$")
	public void login_is_successful() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	    System.out.println("Success");
	}



}