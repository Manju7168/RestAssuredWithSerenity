package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.json.simple.JSONObject;

import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import net.serenitybdd.rest.SerenityRest;

public class BaseMethods {

	public static RequestSpecification reqSpec;
	public static Response response;

	public PreemptiveBasicAuthScheme basicAuth(String userName, String token) {
		PreemptiveBasicAuthScheme authentication = new PreemptiveBasicAuthScheme();
		authentication.setUserName(userName);
		authentication.setPassword(token);
		return authentication;
	}


	public RequestSpecification requestSpec(String baseUri,ContentType contentType, PreemptiveBasicAuthScheme auth) {
		RequestSpecBuilder reqSpeBuilder = new RequestSpecBuilder();
		reqSpeBuilder.setBaseUri(baseUri);
		reqSpeBuilder.setAuth(auth);
		reqSpeBuilder.setContentType(contentType);
		return reqSpeBuilder.build();
	}

	public RequestSpecification requestSpec(String baseUri, ContentType contentType) {
		RequestSpecBuilder reqSpeBuilder = new RequestSpecBuilder();
		reqSpeBuilder.setBaseUri(baseUri);
		reqSpeBuilder.setContentType(contentType);
		return reqSpeBuilder.build();
	}

	public RequestSpecification requestSpec(String baseUri) {
		RequestSpecBuilder reqSpeBuilder = new RequestSpecBuilder();
		reqSpeBuilder.setBaseUri(baseUri);
		return reqSpeBuilder.build();
	}

	public Response getRequest(RequestSpecification reqSpec, String basePath, String resourceId) {
		Response response = SerenityRest.rest().given().spec(reqSpec).basePath(basePath).get("/"+resourceId);
		return response;
	}

	@SuppressWarnings("unchecked")
	public String prepareJsonBody(HashMap<String, String> data, ArrayList<String> value) {
		JSONObject p = new JSONObject();
		for(int i =0; i<value.size();i++) {
			p.put(value.get(i), data.get(value.get(i)));
		}
		return p.toJSONString();
	}

	public Response postRequest(RequestSpecification reqSpec, String body, String basePath, String resourceId) {
		Response response = SerenityRest.rest().given().spec(reqSpec).body(body).basePath(basePath).post("/"+resourceId);
		return response;

	}

	public boolean verifyStatusCode(Response res, String expectedCode) {
		boolean status = (res.getStatusCode()+"").equals(expectedCode);
		return status;
	}

	public boolean verifyStatusMsg(Response res, String expectedMsg) {
		boolean status = res.getBody().asString().contains(expectedMsg);
		return status;
	}

	public String getProperty(String key){
		Properties prop = new Properties();
		File file = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testData\\data.properties");
		FileInputStream fi = null;
		try {
			fi = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			prop.load(fi);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return prop.getProperty(key);
	}

}
