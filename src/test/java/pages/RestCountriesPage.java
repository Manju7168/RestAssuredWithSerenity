package pages;

import utils.BaseMethods;

public class RestCountriesPage extends BaseMethods{
	public static String body;

	public void setBaseURI() {
		reqSpec = requestSpec(getProperty("RestCountryURI"));
	}

	public void getCountryInfo(String country) {
		//reqSpec = requestSpec(getProperty("RestCountryURI"));
		response = getRequest(reqSpec, getProperty("RestCountryBasePath"), country);
		body = response.getBody().asString();
		System.out.println("RESPONSE BODY: "+body);
	}

	public boolean verifyValue(String value) {
		System.out.println("Body :"+body);
		System.out.println("value&&&&"+value);
		return body.contains(value);
	}

}
