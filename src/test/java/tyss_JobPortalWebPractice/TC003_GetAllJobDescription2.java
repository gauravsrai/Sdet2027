package tyss_JobPortalWebPractice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.with;
import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.responseSpecification;


import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import junit.framework.Assert;
public class TC003_GetAllJobDescription2 extends BaseTest {
	
	@Test(description="Get All Job Details")
	public void getAllJobDescription()
	{
        requestSpecification=given()
				  .baseUri(baseUri)
				  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
				  .header("Accept","application/json")
				  .header("Content-Type","application/json");
        
        responseSpecification=RestAssured.expect().statusCode(200).log().body();
		
		get("/auth/webapi/all")
		.then();
		   
//		Assert.assertEquals(responseSpecification.getStatusCode(),200);
//		WebActionUtil.validationinfo("Succesully Recieved All The Job Descriptions","green");
//		WebActionUtil.info("Succesully Recieved All The Job Descriptions");
		
		
		
	}

}
