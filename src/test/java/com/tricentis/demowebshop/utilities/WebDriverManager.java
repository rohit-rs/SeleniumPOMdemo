package com.tricentis.demowebshop.utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverManager {

	static WebDriver driver;

	public static WebDriver launchBrowser() {
		Properties configs = UiUtils.loadPropertiesFile(
				System.getProperty("user.dir") + "/src/test/java/com/tricentis/demowebshop/config/config.properties");
		if (configs.getProperty("isUITest").equals("true")) {
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		}
		return driver;
	}

}
