package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;
import pages.RestCountriesPage;
import utils.Report;

public class RestCountriesSteps {
	
	@Steps
	Report report;
	
	
	@Given("^Base URI$")
	public void restCountry() {
		RestCountriesPage resCountry  = new RestCountriesPage();
		resCountry.setBaseURI();
		report.info("Base URI Successfully set");
	}
	
	@When("^I get Information of \"(.*)\"$")
	public void getInformation(String country) {
		RestCountriesPage resCountry  = new RestCountriesPage();
		System.out.println("Steps ARG: "+country);
		resCountry.getCountryInfo(country);
		report.info("Information Received");
	}
	
	@Then("^I Verify \"(.*)\" in the response$")
	public void verify(String value) {
		RestCountriesPage resCountry  = new RestCountriesPage();
		System.out.println("Steps ARG: "+value);
		boolean status = resCountry.verifyValue(value);
		report.verifyTrue("Successfully Verified","Verification Failed", status);
	}

}
