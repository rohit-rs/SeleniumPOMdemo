package com.tricentis.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.utilities.TestListener;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	@Test(description = "Verify home page title")
	public void verifyHomePageTitle() {
		test = extent.createTest("Verify home page title");
		HomePage homePage = new HomePage(driver);
		homePage.openDemoshopUrl();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
	}

	@Test(description = "Verify login page title")
	public void verifyLoginPageTitle() {
		test = extent.createTest("Verify home page title");
		HomePage homePage = new HomePage(driver);
		homePage.openDemoshopUrl();
		homePage.clickOnLoginLink();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
	}

	@Test(description = "Verify that user is able to login with valid credentials")
	public void verifyLoginWithValidCredentials() {
		test = extent.createTest("Verify that user is able to login with valid credentials");
		HomePage homePage = new HomePage(driver);
		homePage.openDemoshopUrl().clickOnLoginLink().enterEmail(BaseTest.config.getProperty("username"))
				.enterPassword(BaseTest.config.getProperty("password")).clickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		Assert.assertEquals(homePage.isLogoutDisplayed(), true);
		Assert.assertEquals(homePage.getLoggedInUser(), BaseTest.config.getProperty("username"));

	}
}