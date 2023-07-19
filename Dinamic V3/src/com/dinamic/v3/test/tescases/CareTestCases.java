package com.dinamic.v3.test.tescases;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.html5.LocalStorage;
import org.openqa.selenium.html5.WebStorage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.dinamic.v3.test.pages.CarePage;

public class CareTestCases {

	String loginPageURL[] = { "https://carev3.dinamic.io/#/q/22-cfRTcMZ", "https://carev3.dinamic.io/#/q/22-TshTCgo",
			"https://carev3.dinamic.io/#/q/22-2Pg1M*Z", "https://carev3.dinamic.io/#/q/22-p4VPLEr",
			"https://carev3.dinamic.io/#/q/22-TRN4isn" };

	WebDriver driver;

	@BeforeTest
	public void browserConfiguration() throws InterruptedException {

		ChromeOptions options = new ChromeOptions();
		options.addArguments("incognito");
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\white\\Downloads\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver(options);
		LocalStorage local = ((WebStorage) driver).getLocalStorage();
		local.setItem("scannedQR", "265-^zlNpeu");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(loginPageURL[0]);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
	}

//	@Test(enabled = true, priority = 0)
//	public void login() throws InterruptedException {
//		CarePage carePage = new CarePage(driver);
//		carePage.placeOrder1();
//
//	}
//
//	@Test(enabled = true, priority = 1)
//	public void order2() throws InterruptedException {
//		CarePage carePage = new CarePage(driver);
//
//		carePage.placeOrder2();
//
//	}
//
//	@Test(enabled = true, priority = 2)
//	public void order3() throws InterruptedException {
//		CarePage carePage = new CarePage(driver);
//
//		carePage.placeOrder3();
//
//	}
//
//	@Test(enabled = true, priority = 3)
//	public void order4() throws InterruptedException {
//		CarePage carePage = new CarePage(driver);
//		carePage.placeOrder4();
//	}

//	@AfterTest
//	public void close() {
//		driver.quit();
//	}
}
