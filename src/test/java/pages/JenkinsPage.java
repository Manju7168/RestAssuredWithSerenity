package pages;

import io.restassured.http.ContentType;
import utils.BaseMethods;

public class JenkinsPage extends BaseMethods{

	public void setBaseURI() {
		reqSpec = requestSpec(getProperty("JenkinsBaseURI"));
	}

	public void loginJenkinswithValidCred() {
		reqSpec = requestSpec(getProperty("JenkinsBaseURI"),ContentType.JSON,basicAuth(getProperty("validUName"), getProperty("validPassWord")));
		response = getRequest(reqSpec, "", getProperty("JenkinsResourceID"));
	}

	public void loginJenkinswithInValidCred() {
		reqSpec = requestSpec(getProperty("JenkinsBaseURI"),ContentType.JSON,basicAuth(getProperty("validUName"), getProperty("InvalidPassword")));
		response = getRequest(reqSpec, "",getProperty("JenkinsResourceID") );
	}

}
