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
import org.testng.annotations.Test;

public class EditingCompanyDetails {

	String url = "https://posv3.dinamic.io/";
	String email = "admin@kfc.in";
	String password = "Lahir@123";
	String address = "No 3, Guindy, Chennai";

//	List<String> categoryNames = new ArrayList<>();
//	List<Integer> categoryRanks = new ArrayList<>();
	@Test
	public void deletingCategory() {

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
		driver.findElement(By.id("cphone"));
		WebElement addressElement = driver.findElement(By.id("raddress"));

		addressElement.click();
		
		addressElement.clear();

		addressElement.sendKeys(address);

		WebElement saveButton = driver.findElement(By.xpath("//span[normalize-space()='Save']"));
		System.out.println(saveButton.isEnabled());

		if (saveButton.isEnabled()) {

			saveButton.click();
			Assert.assertTrue(true);

		} else {
			Assert.assertTrue(false, "Mandatory fields are missing");
			driver.quit();
		}

	}

}
