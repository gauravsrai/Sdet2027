package com.demo.util;



import static io.restassured.RestAssured.*;

//import static io.restassured.RestAssured.given;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
//import static io.

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.Reporter;

import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.demo.baseutil.BaseTest;
import com.demo.reports.ExtentManager;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

//import io.restassured.response.Response;


/**
 * Description: All the action utilities added in this class e.g
 * 
 * 
 * @author : Sajal, Vikas
 */

public class WebActionUtil {

	public long ETO;

	public WebActionUtil(long ETO) {
		this.ETO = ETO;

	}

	/**
	 * 
	 * Description Method for the info updation in extent Report Report
	 * 
	 * @author Sajal, Vikas
	 */

	public static void pass(String message) {
		ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
	}

	/**
	 * Description Method to provide info in the log,extent reports,testNg reports
	 * 
	 * @author Sajal, Vikas
	 * 
	 */
	public static void info(String message) {
		BaseTest.logger.info(message);

	}

	/**
	 * Description Method to provide info in the extent report
	 * 
	 * @author Sajal, Vikas
	 * 
	 */
	public static void extentinfo(String message) {
		ExtentManager.getTestReport().info(message);

	}

	/**
	 * 
	 * Description Method for the Warning updation in extent Report,Log file,TestNG
	 * Report
	 * 
	 * @author Sajal, Vikas
	 */

	public static void warn(String message) {

		BaseTest.logger.warn(message);
		Reporter.log(message);
	}

	/**
	 * 
	 * Description Method for the error/errorure updation in extent Report
	 * 
	 * @author Sajal, Vikas
	 * 
	 */

	public static void fail(String message) {
		Reporter.log(message);
		ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));

	}

	/**
	 * 
	 * Description Method for the error updation in extent Report
	 * 
	 * @author Sajal, Vikas
	 * 
	 */
	public static void error(String message) {

		BaseTest.logger.error(message);
		Reporter.log(message);

	}

	/**
	 * 
	 * Description Method for the error/errorure updation in extent Report
	 * 
	 * @author Sajal, Vikas
	 * 
	 */

	public static void validationinfo(String message, String color) {
		if (color.equalsIgnoreCase("blue"))

			ExtentManager.getTestReport().info(MarkupHelper.createLabel(message, ExtentColor.BLUE));
		else if (color.equalsIgnoreCase("green"))
			ExtentManager.getTestReport().pass(MarkupHelper.createLabel(message, ExtentColor.GREEN));
		else if (color.equalsIgnoreCase("red"))
			ExtentManager.getTestReport().fail(MarkupHelper.createLabel(message, ExtentColor.RED));
	}

	/**
	 * 
	 * Description Method for fetching of get Current Date Time
	 * 
	 * @author Sajal, Vikas
	 * 
	 */

	public static String getCurrentDateTime() {
		DateFormat customFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
		Date currentDate = new Date();
		return customFormat.format(currentDate);
	}

	/**
	 * 
	 * Description Method to delete the directory
	 * 
	 * @author Sajal, Vikas
	 * @param pathToDeleteFolder
	 */
	public static void deleteDir(String pathToDeleteFolder) {
		File extefolder = new File(pathToDeleteFolder);
		if ((extefolder.exists())) {
			deleteFolderDir(extefolder);
		}
	}

	/**
	 * 
	 * Description Method to delete folder directory
	 * 
	 * @author Sajal, Vikas
	 * @param folderToDelete
	 */
	public static void deleteFolderDir(File folderToDelete) {
		File[] folderContents = folderToDelete.listFiles();
		if (folderContents != null) {
			for (File folderfile : folderContents) {
				if (!Files.isSymbolicLink(folderfile.toPath())) {
					deleteFolderDir(folderfile);
				}
			}

		}
		folderToDelete.delete();
	}

	/**
	 * Description To create the duration of the Test Run
	 * 
	 * @author Sajal, Vikas
	 * @param millis
	 */
	public static String formatDuration(final long millis) {
		long seconds = (millis / 1000) % 60;
		long minutes = (millis / (1000 * 60)) % 60;
		long hours = millis / (1000 * 60 * 60);

		StringBuilder b = new StringBuilder();
		b.append(hours == 0 ? "00" : hours < 10 ? String.valueOf("0" + hours) : String.valueOf(hours));
		b.append(":");
		b.append(minutes == 0 ? "00" : minutes < 10 ? String.valueOf("0" + minutes) : String.valueOf(minutes));
		b.append(":");
		b.append(seconds == 0 ? "00" : seconds < 10 ? String.valueOf("0" + seconds) : String.valueOf(seconds));
		return b.toString();
	}

	/**
	 * Description Method to delete excel file from downloads
	 * 
	 * @author Sajal, Vikas
	 * @param downloadspath
	 */
	public synchronized void deleteXlFilesFromDownloads(String downloadspath) {
		// Delete all files from this directory
		String targetDirectory = downloadspath;
		File dir = new File(targetDirectory);

		// Filter out all log files
		String[] xlFiles = dir.list((d, s) -> {
			boolean fileName = s.startsWith("Claim") && s.endsWith(".xlsx") ? true : false;
			return fileName;
		});
		if (xlFiles.length >= 50) {
			for (String xlFile : xlFiles) {
				String tempXLFile = new StringBuffer(targetDirectory).append(File.separator).append(xlFile).toString();
				File fileDelete = new File(tempXLFile);
				boolean isdeleted = fileDelete.delete();
				// System.out.println("file : " + tempXLFile + " is deleted : " + isdeleted);
			}
		}
	}
	
	
//	public synchronized static Object getDataFromJsonFile(String path,Object data) throws FileNotFoundException, IOException, ParseException 
//	{
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader(path));
//		JSONObject jsonObject = (JSONObject) obj;
//		
//		Object value=jsonObject.get(data);
//		return value;
//	}
//	
//	public synchronized static void addDataIntoJsonFile(String path,String key,Object value) throws FileNotFoundException, IOException, ParseException 
//	{
//		JSONParser parser = new JSONParser();
//		Object obj = parser.parse(new FileReader(path));
//		JSONObject jsonObject = (JSONObject) obj;
//		
//		jsonObject.put(key, value);
//	}

	/**
	* Description Method to set Token value
	*
	* @author Sajal, Vikas
	* @param tokenValue
	*/
	public synchronized static void setTokenValue(String tokenValue) 
	{
		// Creating a JSONObject object
		JSONObject jsonObject = new JSONObject();
		// Inserting key-value pairs into the json object
		jsonObject.put("token", tokenValue);
		try {
			FileWriter file = new FileWriter(BaseTest.tokenPath);
			file.write(jsonObject.toJSONString());
			file.close();
			info(tokenValue + " written in token.json file");
		} catch (Exception e) {
			e.printStackTrace();
			error("Unable to write " + tokenValue + " in token.json file");
		}
	}

	/**
	* Description Method to get Token value
	*
	* @author Sajal, Vikas
	*/
	public synchronized static String getTokenValue() 
	{
		// JSON parser object to parse read file
		JSONParser jsonParser = new JSONParser();
		String token = null;
		try 
		{
			FileReader reader = new FileReader(BaseTest.tokenPath);
			// Read JSON file
			Object obj = jsonParser.parse(reader);
			JSONObject jsonObject = (JSONObject) obj;
			token = (String) jsonObject.get("token");
			
				if (token.equals("")) {
					token = null;
					info("Token value not available in token.json file");
				}
				
		} 
		catch (Exception e) {
			
		e.printStackTrace();
		
		}
		
		return token;

	}
	
	public synchronized static RequestSpecification setRequest(String baseUri,File file,String acceptHeader,String contentTypeHeader)
	{
		         return given()
				  .baseUri(baseUri)
				  .header("Accept",acceptHeader)
				  .header("Content-Type",contentTypeHeader)
				  .body(file);
	}
	
	
	public synchronized static RequestSpecification setRequest(String baseUri,String acceptHeader,String contentTypeHeader)
	{
		       return  given()
				  .baseUri(baseUri)
				  .header("Accept",acceptHeader)
				  .header("Content-Type",contentTypeHeader);
	}
	
	
	public synchronized static void signUp(String baseUri,File file,String acceptHeader,String contentTypeHeader,String endPoint)
	{
		try {
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(BaseTest.dataPath));
			JSONObject jsonObject = (JSONObject) obj;
			
			Response response=setRequest(baseUri, file,acceptHeader,contentTypeHeader).when().post(endPoint);
			
			Assert.assertEquals((String)response.body().asString(), jsonObject.get("username")+" register successfully"); 
			WebActionUtil.validationinfo(jsonObject.get("username")+" registered successfully", "green");
			WebActionUtil.info(jsonObject.get("username")+" registered successfully");
			
			Assert.assertEquals(response.statusCode(), 200);
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to Sign Up To The Application");
			Assert.fail("Unable to Sign Up To The Application");
		}
		
	}
	
	public synchronized static void getAuthenticationToken(String baseUri,File file,String acceptHeader,String contentTypeHeader,String endPoint)
	{
		try {
			
			Response response=setRequest(baseUri, file,acceptHeader,contentTypeHeader).when().post(endPoint);
		
			Assert.assertEquals(response.statusCode(), 200);
			
			pass("Token Generated "+response.body().path("token"));
			info("Token Generated "+response.body().path("token"));
			
			setTokenValue(response.body().path("token"));
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to Complete Authentication Process");
			Assert.fail("Unable to Complete Authentication Process");
		}
		
	}
	
	public synchronized static void getAllJobDescription(String baseUri,String acceptHeader,String contentTypeHeader,String endPoint)
	{
		try {
			
			Response response=setRequest(baseUri,acceptHeader,contentTypeHeader).header("Authorization","Bearer "+WebActionUtil.getTokenValue()).get(endPoint);
		
			Assert.assertEquals(response.statusCode(), 200);
			
			info(response.body().asPrettyString());
			pass("All the Job Details Displayed");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to get All Job Description");
			Assert.fail("Unable to get All Job Description");
		}
		
	}
	
	public synchronized static void addJobDeails(String baseUri,File file,String acceptHeader,String contentTypeHeader,String endPoint)
	{
		try {
			
			JSONParser parser = new JSONParser();
			Object obj = parser.parse(new FileReader(BaseTest.jobDetailPath));
			JSONObject jsonObject = (JSONObject) obj;
			
			Response response=setRequest(baseUri,file,acceptHeader,contentTypeHeader).header("Authorization","Bearer "+WebActionUtil.getTokenValue()).post(endPoint);
		
			Assert.assertEquals(response.getStatusCode(),201);

			Assert.assertEquals((String)response.path("jobTitle"), jsonObject.get("jobTitle"));
			WebActionUtil.info("Job Created With Job Title "+jsonObject.get("jobTitle"));
			 
			WebActionUtil.validationinfo("Job Details added Sucessfully","green");
			WebActionUtil.info("Job Details added Sucessfully");
			
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to get All Job Description");
			Assert.fail("Unable to get All Job Description");
		}
		
	}
	
	public synchronized static void findJobDetail(String baseUri,String acceptHeader,String contentTypeHeader,String endPoint,int id,String jobTitle)
	{
		try {
			
			Response response=setRequest(baseUri,acceptHeader,contentTypeHeader).header("Authorization","Bearer "+WebActionUtil.getTokenValue()).queryParam("id", id)
					  .queryParam("jobTitle",jobTitle).get(endPoint);
		
			Assert.assertEquals(response.getStatusCode(),200);
			
			info(response.body().asPrettyString());
			System.out.println(response.body().asString());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to get All Job Description");
			Assert.fail("Unable to get All Job Description");
		}
		
	}
	
	public synchronized static void updateJobDetail(String baseUri,File file,String acceptHeader,String contentTypeHeader,String endPoint)
	{
		try {
			
			Response response=setRequest(baseUri,file,acceptHeader,contentTypeHeader).header("Authorization","Bearer "+WebActionUtil.getTokenValue())
					  .put(endPoint);
		
			Assert.assertEquals(response.getStatusCode(),200);
			
			info(response.body().asPrettyString());
			System.out.println(response.body().asString());
			
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to get All Job Description");
			Assert.fail("Unable to get All Job Description");
		}
		
	}
	
	public synchronized static void modifyPatchJobDetail(String baseUri,String acceptHeader,String contentTypeHeader,String endPoint,int id,String jobTitle,String jobDescription)
	{
		try {
			
			Response response=setRequest(baseUri,acceptHeader,contentTypeHeader).header("Authorization","Bearer "+WebActionUtil.getTokenValue()).queryParam("id", id)
					  .queryParam("jobTitle",jobTitle).queryParam("jobDescription",jobDescription).patch(endPoint);
		
			Assert.assertEquals(response.getStatusCode(),200);
			
			info(response.body().asPrettyString());
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to get All Job Description");
			Assert.fail("Unable to get All Job Description");
		}
		
	}
	
	public synchronized static void deleteJobDetail(String baseUri,String acceptHeader,String contentTypeHeader,String endPoint,int id)
	{
		try {
			
			Response response=setRequest(baseUri,acceptHeader,contentTypeHeader).header("Authorization","Bearer "+WebActionUtil.getTokenValue()).pathParam("id", id)
					  .delete(endPoint);
		
			Assert.assertEquals(response.getStatusCode(),200);
			
			info(response.body().asPrettyString());
		
			
			
		} catch (Exception e) {
			// TODO: handle exception
			error("Unable to get All Job Description");
			Assert.fail("Unable to get All Job Description");
		}
		
	}
	
	public synchronized static void getHeaderValueFromExcel(String excelPath,String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(excelPath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sheet=wb.getSheet(sheetName);
		String headers=sheet.getRow(1).getCell(0).getStringCellValue();
		
		String[] header = headers.split(",");
        
		for(String h:header)
		{
			System.out.println(h);
		}
	}
}
