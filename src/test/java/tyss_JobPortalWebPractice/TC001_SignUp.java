package tyss_JobPortalWebPractice;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.apache.tools.ant.filters.TokenFilter.ContainsString;
import org.hamcrest.Matchers;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import junit.framework.Assert;
public class TC001_SignUp extends BaseTest {
	
	@Test(description="Signing into the Job Portal Application")
	public void signUp() throws FileNotFoundException, IOException, ParseException
	{
		
	
		File file=new File(dataPath);
		
//		JSONObject details=new JSONObject();
//		details.put("username", "GAURAV");
//		details.put("password", "gaurav123");
		
		JSONParser parser = new JSONParser();
		Object obj = parser.parse(new FileReader(dataPath));
		JSONObject jsonObject = (JSONObject) obj;
		
		
		RequestSpecification reqSpec=given()
				  .baseUri(baseUri)
				  .header("Accept","application/json")
				  .header("Content-Type","application/json")
				  .body(file);
		
		ResponseSpecification respSpec=RestAssured.expect().statusCode(200).log().body();
	
		
	given(reqSpec)
		.when()
		  .post("/users/sign-up")
		.then()
		   .spec(respSpec);
		
		
//		  try {
//			  Assert.assertEquals((String)resp.body().asString(), jsonObject.get("username")+" register successfully"); 
//			  WebActionUtil.validationinfo(jsonObject.get("username")+" registered successfully", "green");
//			  WebActionUtil.info(jsonObject.get("username")+" registered successfully");
//			  
//			  
//		} catch (AssertionError e) {
//			WebActionUtil.fail("User Failed To Register");
//			Assert.fail("User Failed To Register");
//		}
//		
	}

}
