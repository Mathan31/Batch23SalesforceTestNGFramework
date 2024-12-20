package testscenarios;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseClass;
import pages.LoginPage;

public class TC001_Login extends BaseClass{
	
	@Test(priority = 1)
	public void loginFieldValidation() {
		boolean result = new LoginPage()
		.verifyLoginElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 2)
	public void loginWithValidCredential() {
		
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		
	}

}
