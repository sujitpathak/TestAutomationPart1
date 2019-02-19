package extentReportsTest;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.ITestRunnerFactory2;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import freemarker.template.SimpleDate;

public class ExtentReportTesting {
	
	ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
	ExtentTest test;
	
	@BeforeTest
	public void setExtent()
	{
		htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentTest/myReport.html");
		
		htmlReporter.config().setDocumentTitle("Automation Test Report");
		htmlReporter.config().setReportName("Functional Test Status");;
		htmlReporter.config().setTheme(Theme.DARK);
		
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
		
		//Add some System level variable
		extent.setSystemInfo("OS", "Windows10");
		extent.setSystemInfo("Browser", "Chrome");
		extent.setSystemInfo("TesterName", "Sujit");	
	}
	
	@AfterTest 
	public void tearDown()
	{
		extent.flush();
	}
	
	
	@BeforeMethod
	public void setUp()
	{
		
		/*System.setProperty("webdriver.chrome.driver", "E:\\Automation\\browsers\\chromedriver.exe");
		driver = new Chrome
		*/
		System.out.println("Browser Setup is Done");
	}
	
	
	@Test
	public void myTest1()
	{
		test = extent.createTest("Login with Valid data");
		String s1 = "Success";
		Assert.assertEquals(s1, "Success");
		
	}
	
	
	@Test
	public void myTest2()
	{
		test = extent.createTest("Login with Invalid Data");
		String s1 = "Failed";
		Assert.assertEquals(s1, "Failed");
    }
	
	
	@Test
	public void myTest3()
	{
		test = extent.createTest("Login with Blank Data");
		String s1 = "Success";
		Assert.assertEquals(s1,  "Success");
		String dateFormat = new SimpleDateFormat("ddMMMyyyy_hhmmss").format(new Date());
		System.out.println(dateFormat);
	}

	@AfterMethod
	public void TetsReport(ITestResult result)
	{
		if(result.getStatus() == ITestResult.FAILURE )
		{
			test.log(Status.FAIL, "TestCase: " + result.getName());  // add name in Extent Report
			test.log(Status.FAIL, "Test Failed Log is: "+ result.getThrowable()); // Add additional Log in the Extent Report
		}
		
		else if(result.getStatus() == ITestResult.SUCCESS)
		{
			test.log(Status.PASS, "Test Case: "+ result.getName());
		}
		else if(result.getStatus() == ITestResult.SKIP)
		{
			test.log(Status.SKIP, "TestCase: " + result.getName());
		}
	}
	
}
