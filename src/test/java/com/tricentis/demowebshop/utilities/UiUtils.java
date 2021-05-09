package com.tricentis.demowebshop.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Base64;
import java.util.Properties;

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

	public static String getDecryptedString(String encryptedString) {
		String decryptedString;
		byte[] decryptedStringBytes = Base64.getDecoder().decode(encryptedString);
		decryptedString = new String(decryptedStringBytes);
		return decryptedString;
	}

	public static Properties loadPropertiesFile(String filepath) {
		Properties properties = new Properties();
		try {
			FileInputStream file = new FileInputStream(filepath);
			properties.load(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties;
	}

}
