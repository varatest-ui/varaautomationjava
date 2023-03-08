package com.coreengine;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

public class BaseClass {

	public WebDriver driver;

	static ThreadLocal<WebDriver> tl = new ThreadLocal<WebDriver>();

	public WebDriver getDriver() {
		return tl.get();
	}

	@BeforeSuite
	public void nn() {
		System.out.println("Before Suite...");
	}

	@AfterSuite
	public void nn1() {
		System.out.println("After Suite...");
	}

	@AfterTest
	public void hh1() {
		System.out.println("After Text.............");
	}

	@BeforeTest
	public void hh() {

		System.out.println("Before Text.............");

	}

	@AfterClass
	public void afClss() {
		System.out.println("After Class Exectuion...");
	}

	@BeforeClass
	public void bfClss() {
		System.out.println("Before Class Exectuion...");
	}

	@Parameters({ "Browser", "Environment" })
	@BeforeMethod
	public void before(String browserName, String Environment) {

		String bn = browserName.toUpperCase();

		switch (bn) {
		case "CHROME":
			System.setProperty("webdriver.chrome.driver",
					"C:\\Users\\MATEEQ\\Downloads\\chromedriver_win32 (1)\\chromedriver.exe");
			driver = new ChromeDriver();

			tl.set(driver);
			break;

		case "FIREFOX":
			System.setProperty("webdriver.gecko.driver",
					"C:\\Users\\MATEEQ\\Downloads\\New folder (5)\\geckodriver.exe");
			driver = new FirefoxDriver();
			tl.set(driver);
			break;

		case "EDGE":
			System.setProperty("webdriver.edge.driver",
					"C:\\Users\\MATEEQ\\Downloads\\New folder (5)\\msedgedriver.exe");
			driver = new EdgeDriver();
			tl.set(driver);
			break;

		default:
			System.out.println("We Do not support this browser..");
			break;
		}

		String en = Environment.toUpperCase();
		switch (en) {
		case "UAT":
			getDriver().get("https://www.google.com");
			break;

		case "SIT":
			getDriver().get("https://www.yahoo.com");
			break;

		case "DEV":
			getDriver().get("https://www.amazon.com");
			break;

		default:
			System.out.println("We Do not support this Environemnt..");
			break;
		}

	}

	@AfterMethod
	public void after() {
		getDriver().quit();
	}

}
