package com.demo.testscripts;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.response.Response;

public class TC1_Reqres_SingleUser extends BaseTest {
	
	
	@Test
	public void listSingleUser()
	{
		  Response response =  given()
		        .baseUri("https://reqres.in")
		    .when()
		       .get("/api/users/2")
		    .then()
		      .assertThat().statusCode(200)
		      .body("data.id", equalTo(2))
		      .body("data.first_name",containsString("Jan"))
		      .log().body().extract().response();
		  
		  WebActionUtil.info("--------------");
		  
		  WebActionUtil.info(response.getBody().asString());
		  WebActionUtil.info(""+(Integer)response.path("data.id"));
		  WebActionUtil.info((String)response.path("data.email"));
		  
		
		  try {
			  Assert.assertEquals((int)response.path("data.id"), 2);
			  Assert.assertEquals((String)response.path("data.email"), "janet.weaver@reqres.in"); 
			  
			  WebActionUtil.info((response.asPrettyString()+" Response is macthing"));
			  WebActionUtil.pass(response.asPrettyString()+" Response is macthing");
			  
		} catch (AssertionError e) {
			WebActionUtil.fail("Response is not macthing");
			Assert.fail("Response is not macthing");
		}
	}

	
}
