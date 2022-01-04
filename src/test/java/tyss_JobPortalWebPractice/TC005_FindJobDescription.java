package tyss_JobPortalWebPractice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.get;

import static io.restassured.RestAssured.responseSpecification;
import static io.restassured.RestAssured.requestSpecification;

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
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import junit.framework.Assert;
public class TC005_FindJobDescription extends BaseTest{
	//RequestSpecification reqSpec;
	
	@BeforeClass
	public void setUp()
	{
		 requestSpecification=given()
				  .baseUri(baseUri)
				  .queryParam("id", 2021)
				  .queryParam("jobTitle", "Automation")
				  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
				  .header("Content-Type","application/json");
		 
		 ResponseSpecBuilder rsb=new ResponseSpecBuilder();
		 rsb.expectStatusCode(200);
		 rsb.log(LogDetail.BODY);
		 responseSpecification= rsb.build();
	}
	
	@Test(description="Finding Perticulor Job Details")
	public void findJobDetails() throws FileNotFoundException, IOException, ParseException
	{
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(jobDetailPath));
		JSONObject jsonObject = (JSONObject) obj;
		
	 
		 get("/auth/webapi/find")
		.then().spec(responseSpecification);

//		try {
//			
//			Assert.assertEquals(resp.getStatusCode(),200);
//			 
//			WebActionUtil.validationinfo("Able to find the job details with jobId "+jsonObject.get("jobId")+" and jobTitle "+jsonObject.get("jobTitle"),"green");
//			WebActionUtil.info("Able to find the job details with jobId "+jsonObject.get("jobId")+" and jobTitle "+jsonObject.get("jobTitle"));
//			
//		} catch (Exception e) {
//			WebActionUtil.fail("Failed to find the job details");
//			Assert.fail("Failed to find the job details");
//		}
	   
		
		
	}  

}
