package testscenarios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import base.BaseClass;
import libraries.FakerDataFactory;
import pages.LoginPage;

public class TC02_CreateLeads extends BaseClass{
	
	@BeforeTest
	public void setUp() {
		excelFileName = "TC02";
	}
	
	@Test(priority = 1,dataProvider = "TestCaseData")
	public void createSalesLeadWithmandatoryFields(String userName,String password) {
		boolean result = new LoginPage(driver)
		.enterUserName(userName)
		.enterPassword(password)
		.clickOnLogin()
		.verifyHomeElement()
		.clickOnAppLauncher()
		.clickOnViewAll()
		.clickOnSales()
		.clickOnLeadsLink()
		.clickOnNewButton()
		.enterLastName(FakerDataFactory.getLastName())
		.enterCompanyName(FakerDataFactory.getCompanyName())
		.clickAndSelectLeadStatus()
		.clickOnSaveButton()
		.clickUserImg()
		.clickLogout()
		.verifyLoginElements();
		
		Assert.assertTrue(result);
	}

}
