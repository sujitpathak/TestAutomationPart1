package listenerTest;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {
	
	@Test
	public void loginByemail()
	{
		System.out.println("This is Login by Email");
		Assert.assertEquals("Sujit", "Sujit");
	}

	
	@Test
	public void loginByfacebook()
	{
		System.out.println("This is Login by facebook");
		Assert.assertEquals("Sujit", "Kumar");
	}
	
	
	@Test(enabled = false)
	public void loginBytwitter()
	{
		System.out.println("This is Login by twitter");
	}
	
	
}
