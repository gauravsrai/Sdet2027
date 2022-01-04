package tyss_JobPortalWeb;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.response.Response;
import junit.framework.Assert;
public class TC004_AddJobDetails extends BaseTest{
	
	
	@Test(description="Add Job Details into Job Portal Application")
	public void addJobDetails() throws FileNotFoundException, IOException, ParseException
	{
//		String [] exp= {"5 years"};
//		String [] project= {
//		JSONObject details=new JSONObject();
//		details.put("experience",exp);
//		details.put("jobDescription", "SDET");
//		details.put("jobId", "1995");
//		details.put("jobTitle", "Software eng");
		
//		String body="{\r\n"
//				+ "  \"experience\": [\r\n"
//				+ "    \"5 Years\"\r\n"
//				+ "  ],\r\n"
//				+ "  \"jobDescription\": \"SDET\",\r\n"
//				+ "  \"jobId\": 1996,\r\n"
//				+ "  \"jobTitle\": \"Manual\",\r\n"
//				+ "  \"project\": [\r\n"
//				+ "    {\r\n"
//				+ "      \"projectName\": \"HCL\",\r\n"
//				+ "      \"technology\": [\r\n"
//				+ "        \"selenium\"\r\n"
//				+ "      ]\r\n"
//				+ "    }\r\n"
//				+ "  ]\r\n"
//				+ "}";	
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(jobDetailPath));
		JSONObject jsonObject = (JSONObject) obj;
		
		
		File file=new File(jobDetailPath);
		
		Response resp=given()
		  .baseUri(baseUri)
		  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .body(file)
		.when()
		  .post("/auth/webapi/add")
		.then()
		   .statusCode(201)
		   .extract().response();
		
		try {
			
			Assert.assertEquals(resp.getStatusCode(),201);
			
//			Assert.assertEquals((int)resp.path("jobId"),jsonObject.get("jobId") );
//			WebActionUtil.info("Job Created With ID "+jsonObject.get("jobId"));
			
			Assert.assertEquals((String)resp.path("jobTitle"), jsonObject.get("jobTitle"));
			WebActionUtil.info("Job Created With Job Title "+jsonObject.get("jobTitle"));
			 
			WebActionUtil.validationinfo("Job Details added Sucessfully","green");
			WebActionUtil.info("Job Details added Sucessfully");
			
		} catch (Exception e) {
			WebActionUtil.fail("Failed to Add Job Details");
			Assert.fail("Failed to Add Job Details");
		}
		
	   
		 
		
		
		
	}

}
