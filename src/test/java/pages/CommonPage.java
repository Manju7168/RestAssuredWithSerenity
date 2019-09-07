package pages;

import net.thucydides.core.annotations.Steps;
import utils.BaseMethods;
import utils.Report;

public class CommonPage extends BaseMethods {
	@Steps
	Report report;

	public boolean verifyStatusCode(String expectedCode) {
		boolean status = verifyStatusCode(response, expectedCode);
		return status;
	}

	public boolean verifyStatusMsg(String expectedMsg) {
		boolean status = verifyStatusMsg(response, expectedMsg);
		return status;
	}
}
