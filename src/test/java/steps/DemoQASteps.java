package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.DemoQAPage;
import utils.Report;

public class DemoQASteps {

	@Steps
	Report report;
	
	@Given("^Base URI for DemoQA$")
	public void demoQAURI() {
		DemoQAPage demoQAPage = new DemoQAPage();
		demoQAPage.setBaseURI();
	}
	@Given("^I add \"([^\"]*)\" as \"([^\"]*)\"$")
	public void i_add_as(String value, String key) {
		
		DemoQAPage demoQAPage = new DemoQAPage();
		demoQAPage.setReqBody(key, value);
		report.verifyTrue(key+"="+value, "Preparing Request Body Failed", true);
	   
	}

	@When("^I Request POST Method$")
	public void i_Request_POST_Method() {
	    // Write code here that turns the phrase above into concrete actions
		DemoQAPage demoQAPage = new DemoQAPage();
		demoQAPage.addCustomerInfo();
		report.info("Post Request sent Successfully");
	}
}
