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
public class TC008_DeleteJobDetails extends BaseTest {
	
	
	@Test(description="Deleting job details in the Job Portal Application")
	public void deleteJobDetails()
	{
		
		WebActionUtil.deleteJobDetail(prop.getProperty("baseUrl"), prop.getProperty("acceptHeader"), prop.getProperty("contentHeader"), prop.getProperty("endPointDeleteProject"),2021);
		
	}

}
