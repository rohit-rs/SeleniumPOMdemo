package com.tricentis.demowebshop.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.tricentis.demowebshop.listeners.TestListener;
import com.tricentis.demowebshop.pages.HomePage;
import com.tricentis.demowebshop.utilities.UiUtils;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

	@Test(description = "Verify home page title")
	public void verifyHomePageTitle() {
		test = extent.createTest("Verify home page title");
		HomePage homePage = new HomePage(driver);
		homePage.openDemoshopUrl().isPageLoaded();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
	}

	@Test(description = "Verify login page title")
	public void verifyLoginPageTitle() {
		test = extent.createTest("Verify home page title");
		HomePage homePage = new HomePage(driver);
		homePage.openDemoshopUrl().isPageLoaded().clickOnLoginLink();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop. Login");
	}

	@Test(description = "Verify that user is able to login with valid credentials")
	public void verifyLoginWithValidCredentials() {
		test = extent.createTest("Verify that user is able to login with valid credentials");
		HomePage homePage = new HomePage(driver);
		homePage.openDemoshopUrl().clickOnLoginLink().enterEmail(BaseTest.config.getProperty("username"))
				.enterPassword(BaseTest.config.getProperty("password")).clickOnLoginButton();
		Assert.assertEquals(driver.getTitle(), "Demo Web Shop");
		Assert.assertTrue(homePage.isLogoutDisplayed());
		Assert.assertEquals(homePage.getLoggedInUser(), UiUtils.getDecryptedString(BaseTest.config.getProperty("username")));

	}
}
