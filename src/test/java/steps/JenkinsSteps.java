package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.JenkinsPage;
import utils.Report;

public class JenkinsSteps {

	@Steps
	Report report;

	@Given("^Base URI for Jenkins$")
	public void base_URI_for_Jenkins() {
		JenkinsPage jenkinsPage = new JenkinsPage();
		jenkinsPage.setBaseURI();
		report.info("Jenkins Base URI set successfully");
	}

	@When("^I login jenkins with valid Credentials$")
	public void i_login_jenkins_with_as() {
		JenkinsPage jenkinsPage = new JenkinsPage();
		jenkinsPage.loginJenkinswithValidCred();
		report.info("Logged in with valid Credentials");
	}

	@When("^I login jenkins with Invalid Credentials$")
	public void loginWthInvalidred() {
		JenkinsPage jenkinsPage = new JenkinsPage();
		jenkinsPage.loginJenkinswithInValidCred();
		report.info("Logged in with Invalid Credentials");
	}

}
