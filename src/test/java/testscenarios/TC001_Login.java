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
		boolean result = new LoginPage()
			.enterUserName("mathan@credosystemz.sanbox")
			.enterPassword("Mylearning$4")
			.clickOnLogin()
			.verifyHomeElement()
			.clickUserImg()
			.clickLogout()
			.verifyLoginElements();
		Assert.assertTrue(result);
	}
	
	@Test(priority = 3)
	public void loginWithInValidCredential() {
		boolean result = new LoginPage()
		.enterUserName("mathan@credosystemz.sanbox")
		.enterPassword("Mylearning$5")
		.clickOnLoginWithInvalidCredential()
		.validateErrorMsg();
		Assert.assertTrue(result);
	}

}
