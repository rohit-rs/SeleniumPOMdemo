package com.tricentis.demowebshop.utilities;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.tricentis.demowebshop.tests.BaseTest;

public class UiUtils extends BaseTest {

	public static void clickOnWebelement(WebElement element) {
		wait.until(ExpectedConditions.visibilityOf(element)).click();
	}

	public static void enterDataInTextField(WebElement element, String data) {
		wait.until(ExpectedConditions.visibilityOf(element)).clear();
		element.sendKeys(data);
	}

}
