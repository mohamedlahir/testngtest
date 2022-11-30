package com.dinamic.v3.test;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class ServiceCharge {

	String url = "https://posv3.dinamic.io/";
	String email = "admin@kfc.in";
	String password = "Lahir@123";
	String address = "No 3, Guindy, Chennai";

	String serviceCharge = "10";
	
	@BeforeTest
	public void beforTestMethod() {
		
	}

	@Test
	public void enableServiceCharge() {
		// a[normalize-space()='SERVICE CHARGE']

		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\white\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Action object

		driver.manage().window().maximize();
		// Fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		WebElement user = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		action.moveToElement(user).click().build().perform();
		user.sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//div[@class='pos-rel']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='1']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='2']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='3']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='4']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Details']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='SERVICE CHARGE']")).click();
		WebElement element = driver.findElement(By.id("cservice"));
		element.clear();
		element.sendKeys(serviceCharge);

		driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();


		driver.findElement(By.xpath(
				"//div[@class='row m-0 w-100 p-lg-4 justify-content-lg-start justify-content-center']//div[1]//button[1]"))
				.click();
		
		driver.quit();
	}
	
	@Test
	public void seviceChargeAdd() {
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\white\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Action object

		driver.manage().window().maximize();
		// Fluent wait
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("email")));
		WebElement user = driver.findElement(By.xpath("//input[@placeholder='Email']"));
		action.moveToElement(user).click().build().perform();
		user.sendKeys(email);
		driver.findElement(By.id("password")).sendKeys(password);
		driver.findElement(By.xpath("//div[@class='pos-rel']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='My Account']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='1']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='2']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='3']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='4']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='Details']")).click();
		driver.findElement(By.xpath("//a[normalize-space()='SERVICE CHARGE']")).click();
		WebElement charge =  driver.findElement(By.id("cservice"));
		charge.clear();
		charge.sendKeys(serviceCharge);
		WebElement serviceChargeRemovalButton = driver.findElement(By.xpath("//label[@for='servicechrg_tax']//span[@class='slider round']"));
		WebElement serviceChargeslider = driver
				.findElement(By.xpath("//label[@for='servicechrg_remove']//span[@class='slider round']"));
		serviceChargeRemovalButton.click();
		serviceChargeslider.click();
		driver.findElement(By.xpath("//span[normalize-space()='Save']")).click();
		driver.quit();
		
	}

}