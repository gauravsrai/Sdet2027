package com.demo.testscripts;

import static io.restassured.RestAssured.*;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import com.demo.baseutil.BaseTest;
import com.demo.util.WebActionUtil;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class TC2_GetToken extends BaseTest{
	@Test
	public void userSignUpTest()
	{
		
		JSONObject obj=new JSONObject();
		
		Response resp=given()
			.baseUri("https://jobapplicationjwt.herokuapp.com")
			.contentType(ContentType.JSON)
			.and()
			.body(obj)
		.when()
			.post("/users/authenticate")
		.then()
			.assertThat().statusCode(200)
			.log().all().extract().response();
//		Object token = resp.getBody().path("token");
		
		
//		 token = resp.getBody().path("token").toString();
//		 
//		 WebActionUtil.info(token +" Token is generated");
//		 WebActionUtil.pass(" Token is generated");
	}

}