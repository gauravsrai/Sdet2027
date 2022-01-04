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
public class TC003_GetAllJobDescription extends BaseTest {
	
	@Test(description="Get All Job Details")
	public void getAllJobDescription()
	{
		
		
		Response resp=given()
		  .baseUri(baseUri)
		  .header("Authorization","Bearer "+WebActionUtil.getTokenValue())
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		.when()
		  .get("/auth/webapi/all")
		.then()
		   .statusCode(200)
		   .log().body()
		   .extract().response();
		
		Assert.assertEquals(resp.getStatusCode(),200);
		WebActionUtil.validationinfo("Succesully Recieved All The Job Descriptions","green");
		WebActionUtil.info("Succesully Recieved All The Job Descriptions");
		
		
		
	}

}
