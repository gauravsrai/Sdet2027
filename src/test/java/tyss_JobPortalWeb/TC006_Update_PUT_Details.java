package tyss_JobPortalWeb;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.response.Response;
import junit.framework.Assert;
public class TC006_Update_PUT_Details extends BaseTest{
	
	
	@Test(description="Updating The Job Details in Job Portal Application")
	public void updateJobDetails()
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
		
		Response resp=given()
		  .baseUri(baseUri)
		  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
		  .header("Content-Type","application/json")
		  .body(body)
		.when()
		  .put("/auth/webapi/update")
		.then()
		   .statusCode(200)
		   .extract().response();
		
		System.out.println(resp.body().asString());
	   
		 
		
		
		
	}

}
