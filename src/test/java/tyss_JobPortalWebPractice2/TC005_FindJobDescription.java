package tyss_JobPortalWebPractice2;

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
public class TC005_FindJobDescription extends BaseTest{
	
	
	@Test(description="Finding Perticulor Job Details")
	public void findJobDetails() throws FileNotFoundException, IOException, ParseException
	{
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader(jobDetailPath));
//		JSONObject jsonObject = (JSONObject) obj;
	
		WebActionUtil.findJobDetail(prop.getProperty("baseUrl"), prop.getProperty("acceptHeader"), prop.getProperty("contentHeader"), prop.getProperty("endPointFindProject"),2021,"Automation");
		
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
//	   
		
		
	}  

}
