package com.dinamic.v3.test.pages;

import java.time.Duration;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

public class CarePage {

	private JavascriptExecutor js;

	private WebDriver driver;

	String phoneNumber = "9444409275";

	public CarePage(WebDriver driver) {

		this.driver = driver;

	}

	By categories = By.xpath("//h2[@class='item_name mb-0']");

	By addButton1 = By.xpath("(//button[@type='button'])[11]");

	By addButton2 = By.xpath("(//button[@type='button'])[12]");

	By addButton3 = By.xpath("(//button[@type='button'])[13]");

	By addButton4 = By.xpath("(//button[@type='button'])[14]");

	By placeOrder = By.xpath("//span[normalize-space()='Place Order']");

	By confirmOrder = By.xpath("//span[normalize-space()='Confirm Order']");

	By phoneNumberEntry = By.xpath("//input[@id='phone']");

	By continueButton = By.xpath("//button[normalize-space()='Continue']");

	By submitButton = By.xpath("//button[normalize-space()='Submit']");

	OMSPage oPage = new OMSPage(driver);
	
	String loginPageURL[] = { "https://carev3.dinamic.io/#/q/22-TshTCgo", "https://carev3.dinamic.io/#/q/22-2Pg1M*Z",
			"https://carev3.dinamic.io/#/q/22-p4VPLEr", "https://carev3.dinamic.io/#/q/22-TRN4isn" };

	public void placeOrder1() throws InterruptedException {

		for (int i = 0; i < 4; i++) {

			List<WebElement> category = driver.findElements(categories);

			Actions action = new Actions(driver);

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

			action.click(category.get(0)).build().perform();

			System.out.println(addButton1);

			wait.until(ExpectedConditions.elementToBeClickable(addButton1));

			driver.findElement(addButton1).click();

			driver.findElement(addButton2).click();

			driver.findElement(addButton3).click();

			driver.findElement(placeOrder).click();

			driver.findElement(confirmOrder).click();

			driver.findElement(phoneNumberEntry).sendKeys(phoneNumber);

			wait.until(ExpectedConditions.elementToBeClickable(continueButton));

			driver.findElement(continueButton).click();

			WebElement submit = driver.findElement(submitButton);

			Thread.sleep(4000);

			action.click(submit).build().perform();

			Thread.sleep(5000);

			js.executeScript(String.format("window.localStorage.clear();"));

			driver.switchTo().newWindow(WindowType.WINDOW);

			driver.get(loginPageURL[i]);
		}

	}

//	public void placeOrder2() throws InterruptedException {
//
//		driver.get(loginPageURL[0]);
//
//		List<WebElement> category = driver.findElements(categories);
//		Actions action = new Actions(driver);
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//
//		action.click(category.get(0)).build().perform();
//
//		System.out.println(addButton1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(addButton1));
//
//		driver.findElement(addButton1).click();
//
//		driver.findElement(addButton2).click();
//
//		driver.findElement(addButton3).click();
//
//		driver.findElement(placeOrder).click();
//
//		driver.findElement(confirmOrder).click();
//
//		driver.findElement(phoneNumberEntry).sendKeys(phoneNumber);
//
//		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
//
//		driver.findElement(continueButton).click();
//
//		WebElement submit = driver.findElement(submitButton);
//
//		Thread.sleep(4000);
//
//		action.click(submit).build().perform();
//
//		Thread.sleep(5000);
//
//	}
//
//	public void placeOrder3() throws InterruptedException {
//
//		driver.get(loginPageURL[1]);
//
//		List<WebElement> category = driver.findElements(categories);
//		Actions action = new Actions(driver);
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//
//		action.click(category.get(0)).build().perform();
//
//		System.out.println(addButton1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(addButton1));
//
//		driver.findElement(addButton1).click();
//
//		driver.findElement(addButton2).click();
//
//		driver.findElement(addButton3).click();
//
//		driver.findElement(placeOrder).click();
//
//		driver.findElement(confirmOrder).click();
//
//		driver.findElement(phoneNumberEntry).sendKeys(phoneNumber);
//
//		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
//
//		driver.findElement(continueButton).click();
//
//		WebElement submit = driver.findElement(submitButton);
//
//		Thread.sleep(4000);
//
//		action.click(submit).build().perform();
//
//		Thread.sleep(5000);
//
//	}
//
//	public void placeOrder4() throws InterruptedException {
//
//		driver.get(loginPageURL[3]);
//
//		List<WebElement> category = driver.findElements(categories);
//		Actions action = new Actions(driver);
//
//		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
//				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
//
//		action.click(category.get(0)).build().perform();
//
//		System.out.println(addButton1);
//
//		wait.until(ExpectedConditions.elementToBeClickable(addButton1));
//
//		driver.findElement(addButton1).click();
//
//		driver.findElement(addButton2).click();
//
//		driver.findElement(addButton3).click();
//
//		driver.findElement(placeOrder).click();
//
//		driver.findElement(confirmOrder).click();
//
//		driver.findElement(phoneNumberEntry).sendKeys(phoneNumber);
//
//		wait.until(ExpectedConditions.elementToBeClickable(continueButton));
//
//		driver.findElement(continueButton).click();
//
//		WebElement submit = driver.findElement(submitButton);
//
//		Thread.sleep(4000);
//
//		action.click(submit).build().perform();
//
//		Thread.sleep(5000);
//
//	}
	

}
