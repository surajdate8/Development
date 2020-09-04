package stepDefination;
import io.cucumber.java.en.*;

public class StepDefination {

	@Given("User is on netbanking landing page")
	public void user_is_on_netbanking_landing_page() {
		System.out.println("navigated to login url");
	}

	@When("^User loing into app using \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_loing_into_app_using_something_and_something(String strArg1, String strArg2) throws Throwable {
		System.out.println(strArg1+strArg2);
	}

	@Then("Home is poppulated")
	public void home_is_poppulated() {
		System.out.println("populated on home page");
	}
	
	@Then("Cards are displayed")
	public void cards_are_displayed() {
		System.out.println("card displayed");
	}


}
