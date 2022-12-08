package com.dinamic.v3.test.tescases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dinamic.v3.test.pages.OMSPage;

public class OrdersTestCase {
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
		driver.manage().deleteAllCookies();
	}
//
	@Test(enabled = true, priority = 0)
	public void log() {
		OMSPage oPage = new OMSPage(driver);
		oPage.enterUsername(emailAddress);
		oPage.enterPassword(password);
		oPage.clicklogin();

	}

	@Test(enabled = true, priority = 1)
	public void ordersEntry() {
		OMSPage oPage = new OMSPage(driver);
		oPage.order();
		oPage.ordering();
		
	}
	
	
	@Test(testName = "No Discount",priority = 2,enabled = true)
	public void withoutItemDiscountPrice() {
		OMSPage oPage = new OMSPage(driver);
		
		oPage.orderingItems();

		oPage.orderCalculation();
	}
	
	@Test(testName = "with item discount",priority = 3,enabled = false)
	public void withItemDiscount() {
		OMSPage oPage = new OMSPage(driver);
		oPage.orderCalculationwithItemDiscount();
	}

	@Test(testName = "logout",priority = 4,enabled = false)
	public void logout() {
		OMSPage oPage = new OMSPage(driver);


	}
	
	@AfterTest
	public void close() {
		driver.quit();
	}
}
