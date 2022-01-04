package tyss_JobPortalWebPractice2;

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
		
//		JSONObject details=new JSONObject();
//		details.put("username", "GAURAV");
//		details.put("password", "gaurav123");
			
	WebActionUtil.getAuthenticationToken(prop.getProperty("baseUrl"), new File(dataPath),prop.getProperty("acceptHeader"), prop.getProperty("contentHeader"), prop.getProperty("endPointAuthenticate"));
		
		
	}

}
