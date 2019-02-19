package extentReportsTest;

import org.testng.annotations.Test;

public class PrintTest {
	
	
	@Test
	public void d()
	{
		System.out.println(System.getProperty("user.dir") + "/ExtentTest/abc.html");
	}

}
