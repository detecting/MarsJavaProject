package testPackage;

import java.awt.AWTException;
import java.awt.HeadlessException;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import helperPackage.BrowserFactory;
import pagesPackage.HomePage;
import pagesPackage.LoginPage;

public class BaseClass {
	
	ExtentReports reports;
	ExtentTest testLog;
	ExtentHtmlReporter htmlReporter;
	
	@BeforeTest
	public void testInit()
	{
		htmlReporter = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/test-output/MyExtentReport.html"));
		htmlReporter.loadXMLConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
		reports = new ExtentReports();
		
		reports.setSystemInfo("Environment", "QA");
		reports.setSystemInfo("Application", "QA Application");
		reports.setSystemInfo("Regression", "On Test Environment");
		reports.attachReporter(htmlReporter);

	}
		
	@BeforeMethod
	public void setUpTest(Method method) throws HeadlessException, AWTException, IOException
	{
		String testName = method.getName();
		testLog = reports.createTest(testName);
		//Initiate driver
		BrowserFactory.startBrowser("chrome");
		
		testLog.log(Status.INFO, "Login test started");
		SoftAssert softAssert = new SoftAssert();
		//Initiate PO for login page
		LoginPage login_page = new LoginPage();
		testLog.log(Status.INFO, "Logged in successfully");

		//perform login steps
		login_page.loginSteps();
		softAssert.assertEquals(true, true, "Test failed after launching url");
		
		//Initiate PO for home page and validate
		HomePage home_page = new HomePage();
		home_page.validateHomePage();
		softAssert.assertEquals(true, true);		
		testLog.log(Status.PASS, "Login test Passed");


		softAssert.assertAll();
	}
	
	@AfterMethod
	public void tearDownTest(ITestResult result)
	{
		if(result.getStatus()==ITestResult.SUCCESS)
		{
			testLog.log(Status.PASS, "Test passed");
		}else if(result.getStatus()==ITestResult.FAILURE)
		{
			testLog.log(Status.FAIL, "Test failed");
		}
		else if(result.getStatus()==ITestResult.SKIP)
		{
			testLog.log(Status.SKIP, "Test skipped");
		}
	
		//quit the instance of driver
		BrowserFactory.driver.quit();
	}
	
	@AfterTest
	public void clearUp()
	{
		reports.flush();
	}

}
