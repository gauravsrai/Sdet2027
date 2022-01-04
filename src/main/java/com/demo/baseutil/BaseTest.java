package com.demo.baseutil;

import java.io.FileInputStream;
import java.lang.reflect.Method;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentTest;
import com.demo.commonutils.FileOperation;
import com.demo.reports.Extent;
import com.demo.reports.ExtentManager;
import com.demo.util.WebActionUtil;

/***********************************************************************
 * Description : Implements Application Precondition and Postcondition.
 * 
 * @author : Sajal, Vikas
 * @BeforeSuite: Creates all the folder structure for Extent Reports
 * @BeforeClass : Sets extent report.
 * @BeforeMethod : Creates node for extent report.
 * 
 */
public class BaseTest {
	public static Properties prop;
	public static Logger logger = LoggerFactory.getLogger(BaseTest.class);
	public static final String CONFIGPATH = System.getProperty("user.dir") + "./src/main/resources/data/Data/config.properties";
	public static WebActionUtil actionUtil;
	
	public static final int ITO = 10;
	public static final int ETO = 30;
	public static final String dataPath = System.getProperty("user.dir") + "./src/main/resources/data/Data/credentials.json";
	public static final String jobDetailPath = System.getProperty("user.dir") + "./src/main/resources/data/Data/jobDetails.json";
	public static final String UpdateDetailsPath = System.getProperty("user.dir") + "./src/main/resources/data/Data/UpdateDetails.json";
	public static final String tokenPath = System.getProperty("user.dir") + "./src/main/resources/data/Data/token.json";

	//public static String token;
	public static String baseUri="https://jobapplicationjwt.herokuapp.com";

	static {
		try {
			prop = new Properties();
			FileInputStream fis = new FileInputStream(CONFIGPATH);
			prop.load(fis);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	/**
	 * Description : Creates folder structure for Extent reports.
	 * 
	 * @author:Sajal, Vikas
	 */
	@BeforeSuite(alwaysRun = true)
	public synchronized void createFiles() {
		try {
			logger.info("Folder creation for Extent");
			FileOperation fileOperation = new FileOperation();
			fileOperation.CreateFiles();
		} catch (Exception e) {
			logger.error("Exception while report inititation");
		}

	}

	/**
	 * Description: sets extent report
	 * 
	 * @author:Sajal, Vikas
	 * 
	 */

	@BeforeClass
	public void setExtentReport() {
		ExtentTest parentExtentTest = Extent.createTest(getClass().getSimpleName());
		ExtentManager.setParentReport(parentExtentTest);

	}

	/**
	 * Description: Creates node for extent report.
	 * 
	 * @author Sajal, Vikas
	 * @param: methodName
	 */
//	@Parameters("browserName")
	@BeforeMethod
	public void createNode(Method methodName) {
		try {
			String description = methodName.getAnnotation(Test.class).description();
			ExtentTest testReport = ExtentManager.getParentReport().createNode(methodName.getName(), description);
			ExtentManager.setTestReport(testReport);
			logger = LoggerFactory.getLogger(getClass().getName());
			actionUtil = new WebActionUtil(ETO);

		} catch (Throwable e) {
			WebActionUtil.error("Unable to creates node for extent report");
			Assert.fail("Unable to creates node for extent report");
		}

	}

}
