package tyss_JobPortalWebPractice2;

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
public class TC007_Update_PATCH_Details extends BaseTest {
	
	
	@Test(description="Partial Updation Of Job Details In Job Portal ")
	public void updateJobDetails()
	{
		WebActionUtil.modifyPatchJobDetail(prop.getProperty("baseUrl"), prop.getProperty("acceptHeader"), prop.getProperty("contentHeader"), prop.getProperty("endPointPatchProject"),2021,"Automation","SDET Automation Engineer");
		
//		try {
//			
//			if(resp.body().asString().contains(updatedJobTitle)&&resp.body().asString().contains(updatedjobDescription))
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
