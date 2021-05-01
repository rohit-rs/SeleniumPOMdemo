package com.tricentis.demowebshop.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.tricentis.demowebshop.tests.BaseTest;

public class BasePage {

	protected WebDriver driver;
	protected WebDriverWait wait = BaseTest.wait;
	protected Logger log = LogManager.getLogger(getClass());

	public BasePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public <T> T isPageLoaded() {
		return null;
	}

}
