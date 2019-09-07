package utils;

import org.junit.Assert;

import net.thucydides.core.annotations.Step;

public class Report {


	@Step("{0}")
	public void info(String arg) {}

	public void verifyTrue(String successMsg,String failureMsg, boolean value) {
		if(value)
			info(successMsg);
		else
			info(failureMsg);
		Assert.assertTrue(value);
	}

}
