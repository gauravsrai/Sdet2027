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
public class TC004_AddJobDetails extends BaseTest{
	
	
	@Test(description="Add Job Details into Job Portal Application")
	public void addJobDetails() throws FileNotFoundException, IOException, ParseException
	{

		WebActionUtil.addJobDeails(prop.getProperty("baseUrl"), new File(jobDetailPath),prop.getProperty("acceptHeader"), prop.getProperty("contentHeader"), prop.getProperty("endPointCreateProject"));
		
	}

}
