package tyss_JobPortalWebPractice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class TC006_Update_PUT_Details extends BaseTest{
	
  //RequestSpecification reqSpec;
	//NOTE:Here we are not creating variable for RequestSpecification
	//We are directly importing the variable
	
	@BeforeClass
	public void setUp()
	{
		String body="{\r\n"
				+ "  \"experience\": [\r\n"
				+ "    \"3 Years\"\r\n"
				+ "  ],\r\n"
				+ "  \"jobDescription\": \"SDET\",\r\n"
				+ "  \"jobId\": 2021,\r\n"
				+ "  \"jobTitle\": \"Manual Engineer\",\r\n"
				+ "  \"project\": [\r\n"
				+ "    {\r\n"
				+ "      \"projectName\": \"HCL CAT\",\r\n"
				+ "      \"technology\": [\r\n"
				+ "        \"selenium\"\r\n"
				+ "      ]\r\n"
				+ "    }\r\n"
				+ "  ]\r\n"
				+ "}";	
		
		 requestSpecification=given()
				 .baseUri(baseUri)
				  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
				  .header("Content-Type","application/json")
				  .body(body);
	}
	
	@Test(description="Updating The Job Details in Job Portal Application")
	public void updateJobDetails()
	{
		
		
		
		Response resp=given(requestSpecification)
		 
		.when()
		  .put("/auth/webapi/update")
		.then()
		   .statusCode(200)
		   .extract().response();
		
		System.out.println(resp.body().asString());
	   
		 
		
		
		
	}

}
