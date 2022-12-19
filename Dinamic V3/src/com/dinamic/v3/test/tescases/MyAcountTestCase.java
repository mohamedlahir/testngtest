package com.dinamic.v3.test.tescases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dinamic.v3.test.pages.OMSPage;

public class MyAcountTestCase {

	String emailAddress = "admin@kfc.in";
	String password = "Lahir@123";
	String loginPageURL = "https://posv3.dinamic.io/login";

	WebDriver driver;

	@BeforeTest
	public void browserConfiguration() {

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\white\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(loginPageURL);
		driver.manage().window().maximize();
//		driver.manage().deleteAllCookies();
	}

	@Test(enabled = true, priority = 7)
	public void login() {
		OMSPage oPage = new OMSPage(driver);
		oPage.enterUsername(emailAddress);
		oPage.enterPassword(password);
		oPage.clicklogin();

	}

	@Test(enabled = true, priority = 8)
	public void enterPin() {
		OMSPage oPage = new OMSPage(driver);
		oPage.enteringPinForMyAccount();

	}

	@AfterTest
	public void close() {
		driver.quit();
	}

}
