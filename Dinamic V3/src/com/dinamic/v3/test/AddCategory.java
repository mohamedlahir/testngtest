package com.dinamic.v3.test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.Test;

public class AddCategory {
	//
	String url = "https://web.dinamic.io/";
	String email = "ops@thepumphouse.in";
	String password = "TPH@dinamic02";

	List<String> categoryNames = new ArrayList<>();
	List<Integer> categoryRanks = new ArrayList<>();

	@Test
	public void categoryAdding() throws InterruptedException {
//
		for (int n = 0; n <= 20; n++) {
			categoryRanks.add(n);
			categoryNames.add(categoryRanks.get(n) + " Category");

		}

		System.out.println("Number of Ranks :" + categoryRanks.size());
//
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\white\\Downloads\\chromedriver_win32 (4)\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://pos.dinamic.io");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		// Action object

		driver.manage().window().maximize();
		driver.get(url);

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
		driver.findElement(By.xpath("//div[@class='d-flex align-items-center push-48-t push-48-b msvg']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='7']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='6']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='0']")).click();
		driver.findElement(By.xpath("//button[normalize-space()='0']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Staff']")).click();

		driver.findElement(By.xpath("//a[normalize-space()='Categories']")).click();
		driver.findElement(By.xpath("//a[@href='/management/menu/categories']")).click();
		System.out.println();
		for (int j = 1; j < categoryNames.size(); j++) {
			Thread.sleep(2000);
			driver.findElement(By.xpath("//a[normalize-space()='ADD CATEGORY']")).click();
			Thread.sleep(1000);
			WebElement enteringString = driver.findElement(By.xpath("//input[@id='category_name']"));
			WebElement enteringRank = driver.findElement(By.xpath("//input[@id='category_rank']"));
			action.moveToElement(enteringString).click().build().perform();
			enteringString.sendKeys(categoryNames.get(j));
			Thread.sleep(1000);
			action.moveToElement(enteringRank).click().build().perform();
			// Default value is present, Default value is iterating

			Thread.sleep(2000);
			enteringRank.clear();
			enteringRank.sendKeys("2");
			driver.findElement(By.xpath("//span[normalize-space()='NEXT']")).click();
			Thread.sleep(1000);
			driver.findElement(By.xpath("//span[normalize-space()='DONE']")).click();
			Thread.sleep(1000);
		}
		driver.quit();
	}

}
