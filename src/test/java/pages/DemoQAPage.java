package pages;

import java.util.ArrayList;
import java.util.HashMap;

import io.restassured.http.ContentType;
import utils.BaseMethods;

public class DemoQAPage extends BaseMethods{


	static ArrayList<String>  keyValues = new ArrayList<>();
	static HashMap<String,String> data = new HashMap<>();

	public void setBaseURI() {
		reqSpec = requestSpec(getProperty("DemoQAURI"), ContentType.JSON);
	}

	public void setReqBody(String key, String value) {
		keyValues.add(key);
		data.put(key, value);
	}

	public void addCustomerInfo() {
		String body = prepareJsonBody(data, keyValues);
		response = postRequest(reqSpec, body, getProperty("DemoQABasePath"), getProperty("DemoQAResourceID"));
	}


}
