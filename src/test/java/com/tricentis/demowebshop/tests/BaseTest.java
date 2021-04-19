package com.tricentis.demowebshop.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import io.restassured.response.Response;

public class BaseTest {
	public static WebDriver driver;
	public static WebDriverWait wait;
	public static Properties config;
	public static ExtentReports extent;
	public static ExtentSparkReporter avent;
	public static ExtentTest test;
	public static Response response;

	@BeforeSuite
	public static void setExtentReport() {
		avent = new ExtentSparkReporter("./extent-report.html");
		avent.config().setTheme(Theme.STANDARD);
		extent = new ExtentReports();
		extent.attachReporter(avent);
	}

	@BeforeTest
	public static void initialize() {
		config = new Properties();
		try {
			FileInputStream selectors = new FileInputStream(System.getProperty("user.dir")
					+ "/src/test/java/com/tricentis/demowebshop/config/config.properties");
			config.load(selectors);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@BeforeTest
	public static void launchBrowser() {
		if (config.getProperty("isUITest").equals("true")) {
			//test.info("Open browser...");
			System.setProperty("webdriver.chrome.driver", "resources\\chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 60);
		}
	}

	@AfterTest
	public static void tearDown() {
		if (config.getProperty("isUITest").equals("true")) {
			//test.info("Close browser...");
			driver.close();
			driver.quit();
		}

	}

	@AfterSuite
	public static void generateReport() {
		extent.flush();
	}

	/*
	 * @BeforeTest
	 * 
	 * @Parameters({ "testtype", "browser" }) public void launchBrowser(String
	 * testtype, String browser) { if (testtype.equals("ui") &&
	 * browser.equals("chrome")) { System.setProperty("webdriver.chrome.driver",
	 * "resources\\chromedriver.exe"); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); wait = new
	 * WebDriverWait(driver, 60); } if (testtype.equals("ui") &&
	 * browser.equals("firefox")) { System.setProperty("webdriver.geco.driver",
	 * "resources\\gecodriver.exe"); driver = new ChromeDriver();
	 * driver.manage().window().maximize();
	 * driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS); wait = new
	 * WebDriverWait(driver, 60); }
	 * 
	 * }
	 */

	/*
	 * @AfterTest
	 * 
	 * @Parameters({ "testtype", "browser" }) public void tearDown(String testtype,
	 * String browser) { if (testtype.equals("ui") && browser.equals("chrome")) {
	 * driver.close(); driver.quit(); } }
	 */

}
