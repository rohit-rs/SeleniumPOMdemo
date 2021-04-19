package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.tricentis.demowebshop.tests.BaseTest;
import com.tricentis.demowebshop.utilities.UiUtils;

public class HomePage extends BasePage {

	@FindBy(css = "[class='ico-login']")
	private WebElement login;

	@FindBy(css = "[class='ico-logout']")
	private WebElement logout;

	@FindBy(xpath = "//div[@class='header-links']//a[@href='/customer/info']")
	private WebElement loggedInUser;

	public HomePage(WebDriver driver) {
		super(driver);
	}

	public HomePage openDemoshopUrl() {
		log.info("Open demo shop URL: " + BaseTest.config.getProperty("demoShopURL"));
		BaseTest.test.info("Open demo shop URL: " + BaseTest.config.getProperty("demoShopURL"));
		driver.get(BaseTest.config.getProperty("demoShopURL"));
		return this;
	}

	public LoginPage clickOnLoginLink() {
		log.info("Click on Login link");
		BaseTest.test.info("Click on Login link");
		UiUtils.clickOnWebelement(login);
		return new LoginPage(driver);
	}

	public boolean isLogoutDisplayed() {
		log.info("Check if Logout button is displayed=> " + logout.isDisplayed());
		BaseTest.test.info("Check if Logout button is displayed=> " + logout.isDisplayed());
		return logout.isDisplayed();
	}

	public String getLoggedInUser() {
		String user = loggedInUser.getText();
		log.info("Get the logged in user id=> " + user);
		BaseTest.test.info("Get the logged in user id=> " + user);
		return user;
	}

}
