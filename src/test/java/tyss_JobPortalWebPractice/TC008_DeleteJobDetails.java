package tyss_JobPortalWebPractice;

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
public class TC008_DeleteJobDetails extends BaseTest {
	
	
	@Test(description="Deleting job details in the Job Portal Application")
	public void deleteJobDetails()
	{
		
		Response resp=given()
		  .baseUri(baseUri)
		  .pathParam("id", 2021)
		  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
		  .header("Content-Type","application/json")
		.when()
		  .delete("/auth/webapi/remove/{id}")
		.then()
		   .statusCode(200)
		   .extract().response();
		
		System.out.println(resp.body().asString());
	   
		 
		
		
		
	}

}
