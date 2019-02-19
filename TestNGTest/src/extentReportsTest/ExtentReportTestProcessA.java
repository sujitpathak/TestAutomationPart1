package extentReportsTest;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;



public class ExtentReportTestProcessA {
	
	ExtentHtmlReporter reporter;
	ExtentReports extent;
	
	@BeforeTest
	public void startReport()
	{
		reporter = new ExtentHtmlReporter(System.getProperty("user.dir")+"/ExtentTest/myTestExecutionSummary.html");
		extent.attachReporter(reporter);
	}
	
	@Test
	public void LoginSuccess()
	{
		extent.createTest("LoginSuccess");
		System.out.println("Login Successful");
	} 
	
	@Test
	public void LoginFailed()
	{
		extent.createTest("LoginFail");
		System.out.println("Login Failed");
	}

}
