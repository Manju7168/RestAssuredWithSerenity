package steps;

import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;
import pages.CommonPage;
import utils.Report;

public class CommonSteps {

	@Steps
	Report report;

	@Then("^I Verify Status code \"(.*)\"$")
	public void i_Verify_Status_code(String statusCode) {
		CommonPage commonPage = new CommonPage();
		boolean status = commonPage.verifyStatusCode(statusCode);
		report.verifyTrue("Status Code Verification Successful\n Status Code="+statusCode, "Status Code Verification Failed\n Status code is not equal to"+statusCode, status);

	}

	@Then("^I Verify Staus message \"(.*)\"$")
	public void i_Verify_Staus_message(String statusMsg) {
		CommonPage commonPage = new CommonPage();
		boolean status = commonPage.verifyStatusMsg(statusMsg);
		report.verifyTrue("Status Message Verification Successful\n Status Message contains \""+statusMsg+"\"", "Status Message Verification Failed\n Status message does not contain \""+statusMsg+"\"", status);  
	}


}
