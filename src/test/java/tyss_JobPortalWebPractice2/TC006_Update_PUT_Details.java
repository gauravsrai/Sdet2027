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
public class TC006_Update_PUT_Details extends BaseTest{
	
	
	@Test(description="Updating The Job Details in Job Portal Application")
	public void updateJobDetails()
	{
		
		WebActionUtil.updateJobDetail(prop.getProperty("baseUrl"), new File(UpdateDetailsPath),prop.getProperty("acceptHeader"), prop.getProperty("contentHeader"), prop.getProperty("endPointUpdateProject"));
	
	}

}
