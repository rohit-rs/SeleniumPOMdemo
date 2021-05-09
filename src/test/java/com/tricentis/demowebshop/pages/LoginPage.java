package com.tricentis.demowebshop.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import static com.tricentis.demowebshop.tests.BaseTest.test;
import com.tricentis.demowebshop.tests.BaseTest;
import com.tricentis.demowebshop.utilities.UiUtils;

public class LoginPage extends BasePage {

	@FindBy(id = "Email")
	private WebElement email;

	@FindBy(id = "Password")
	private WebElement password;

	@FindBy(css = "[value='Log in']")
	private WebElement login;

	public LoginPage(WebDriver driver) {
		super(driver);
	}

	public LoginPage enterEmail(String data) {
		log.info("Enter email id in Email field: " + data);
		test.info("Enter email id in Email field: " + data);
		UiUtils.enterDataInTextField(email, UiUtils.getDecryptedString(data));
		return this;
	}

	public LoginPage enterPassword(String data) {
		log.info("Enter password in Password field: " + data);
		test.info("Enter password in Password field: " + data);
		UiUtils.enterDataInTextField(password, UiUtils.getDecryptedString(data));
		return this;
	}

	public HomePage clickOnLoginButton() {
		log.info("Click on login button");
		test.info("Click on login button");
		UiUtils.clickOnWebelement(login);
		return new HomePage(driver);
	}

}
