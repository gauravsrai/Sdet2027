package tyss_JobPortalWeb;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.response.Response;
import junit.framework.Assert;
public class TC002_Authentication extends BaseTest{
	
	//public static String token;
	@Test(description="Get Token to Perform different action on application")
	public void authentication() throws FileNotFoundException, IOException, ParseException
	{
		
		JSONObject details=new JSONObject();
		details.put("username", "GAURAV");
		details.put("password", "gaurav123");
			
				
		
		Response resp=given()
		  .baseUri(baseUri)
		  .header("Accept","application/json")
		  .header("Content-Type","application/json")
		  .body(details)
		.when()
		  .post("/users/authenticate")
		.then()
		   .statusCode(200)
		   .extract().response();
		
		//System.out.println(resp.body().asString());
	   
		 String actualToken=(String)resp.body().path("token");
		 
		 WebActionUtil.setTokenValue(actualToken);
		
		
		 
		
		
		
	}

}
