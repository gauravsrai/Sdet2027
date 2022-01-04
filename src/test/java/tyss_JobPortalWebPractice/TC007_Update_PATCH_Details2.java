package tyss_JobPortalWebPractice;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.requestSpecification;
import static io.restassured.RestAssured.patch;
import static io.restassured.RestAssured.responseSpecification;
import static org.hamcrest.Matchers.equalTo;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.http.client.methods.RequestBuilder;
import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.response.Response;
import junit.framework.Assert;
import net.bytebuddy.implementation.bytecode.assign.Assigner.EqualTypesOnly;
public class TC007_Update_PATCH_Details2 extends BaseTest {
	
	@BeforeClass
	public void setUp()
	{
//		 requestSpecification=given()
//				  .baseUri(baseUri)
//				  .queryParam("id", 2021)
//				  .queryParam("jobTitle", "Automation")
//				  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
//				  .header("Content-Type","application/json");
		
		String updatedJobTitle="SDE Automation";
		String updatedjobDescription="Automation";
		
		RequestSpecBuilder rb=new RequestSpecBuilder();
		rb.setBaseUri(baseUri);
		rb.addQueryParam("id", 2021);
		rb.addQueryParam("jobTitle", updatedJobTitle);
		rb.addQueryParam("jobDescription",updatedjobDescription);
		rb.addHeader("Authorization","Bearer "+WebActionUtil.getTokenValue());
		rb.addHeader("Content-Type","application/json");
		requestSpecification=rb.build();
		
		ResponseSpecBuilder rsb=new ResponseSpecBuilder();
		rsb.expectStatusCode(200);
		rsb.log(LogDetail.BODY);
		rsb.expectBody("jobId",equalTo(null));
		rsb.build();
	}
	
	@Test(description="Partial Updation Of Job Details In Job Portal ")
	public void updateJobDetails()
	{
		String updatedJobTitle="SDE Automation";
		String updatedjobDescription="Automation";
		
		patch("/auth/webapi/update/details")
		.then();
		   
		
//		try {
//			
//			if(responseSpecification.body().asString().contains(updatedJobTitle)&&responseSpecification.body().asString().contains(updatedjobDescription))
//			{
//				WebActionUtil.validationinfo("Job Details Updated Successfully with jobTitle "+updatedJobTitle+" and jobDescription "+updatedjobDescription,"green");
//				WebActionUtil.info("Job Details Updated Successfully with jobTitle "+updatedJobTitle+" and jobDescription "+updatedjobDescription);
//			}
//			else
//				WebActionUtil.fail("Unable to Update the Job Details with jobTitle  "+updatedJobTitle+" and jobDescription "+updatedjobDescription);
		   
//			
//		} catch (Exception e) {
//			WebActionUtil.fail("Failed to Update the job details");
//			Assert.fail("Failed to Update the job details");
//		}
		
		
		
	}

}
