package com.dinamic.v3.test.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class OMSPage {

	int count = 0;

	String orderNumberStr;
	String kotNumber1;
	String orderedItemprice[];
	int itemTotal;
	int gSTValue = 5;
	int serviceCharge = 10;
	int itemPriceFinal;

	int itemCountParsed;
	private WebDriver driver;

	By start = By
			.xpath("(//button[@class='btn btn-view start-btn w-100 ng-star-inserted'][normalize-space()='start'])[1]");
	By kOTNumber = By.xpath("//span[@class='ft-8']");
	By pin1 = By.xpath("//button[normalize-space()='1']");
	By pin2 = By.xpath("//button[normalize-space()='2']");
	By pin3 = By.xpath("//button[normalize-space()='3']");
	By pin4 = By.xpath("//button[normalize-space()='4']");
	By numberOfPeople = By.xpath("(//input[@id='people_count'])[3]");

	By emailField = By.id("email");
	By passwordField = By.id("password");
	By loginButton = By.xpath("//div[@class='pos-rel']");
	By orders = By.xpath("//span[normalize-space()='Orders']");
	By startButton = By.xpath("//span[normalize-space()='Start']");
	By floorName = By.xpath("//span[@class='text-primary cursor']");
	By tableName = By.xpath("//a[@class='d-flex align-items-center ng-star-inserted']");
	By itemCards = By.xpath("//div[@class='oms-container-category__container__content__body__card p-2 card-ripple']");
	By orderedItem = By.xpath("//div[@class='d-flex align-items-center']");
	By orderedItemsPrice = By.xpath("//div[@class='ft-10 prtxt-right text-right doNotPrint']");
	By expand = By.xpath("//i[normalize-space()='expand_more']");
	By itemCountElement = By
			.cssSelector("div[class='mb-2 clearfix ft-11 ng-star-inserted'] div div[class='text-right'] span");
	By orderNumber = By.cssSelector("span[class='d-flex align-items-center w-100'] span:nth-child(2)");
	By confirmaKOT = By.xpath("//span[normalize-space()='Confirm KOT']");
	By itemPrice = By
			.xpath("//div[@class='mb-2 clearfix no-margin ft-11 ng-star-inserted'] //div[@class='text-right'] //span");
	By grandTotal = By.xpath("//span[@class='order-foot-total ft-15']");

	By priceOutput = By.xpath("//span[@class='order-foot-total ft-15']");

	By addDiscount = By.xpath(
			"(//button[@type='button'][normalize-space()='Add Discount'])[1]");
	By ownersFriend = By.xpath("//li[1]//div[1]//h6[1]");

	By discountConfirmation = By.xpath("//button[normalize-space()='Confirm']");

	public OMSPage(WebDriver driver) {

		this.driver = driver;

	}

	public void enterUsername(String user) {
		driver.findElement(emailField).sendKeys(user);
	}

	// Method to enter password
	public void enterPassword(String pass) {
		driver.findElement(passwordField).sendKeys(pass);
	}

	public void clicklogin() {

		driver.findElement(loginButton).click();
		System.out.println("pro");

	}

	public void order() {

		driver.findElement(orders).click();

		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();

		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void ordering() {

		driver.findElement(start).click();
		System.out.println("Start Button is clicked");

		driver.findElement(numberOfPeople).click();
		driver.findElement(numberOfPeople).sendKeys("3");

		driver.findElement(startButton).click();

		String floor = driver.findElement(floorName).getText();
		String tableNumber[] = driver.findElement(tableName).getText().split("chevron_right");
		System.out.println("Floor Name : " + floor);
		System.out.println("Table Number : " + tableNumber[1]);
	}

	// Only Ordering Items not settling the bill.

	public void orderingItems() {

		List<WebElement> allItemsCards = driver.findElements(itemCards);
		for (int j = 0; j < 12; j++) {
			allItemsCards.get(j).click();
		}

		driver.findElement(confirmaKOT).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> orderedItems = driver.findElements(orderedItem);

		List<WebElement> orderItemsPriceList = driver.findElements(orderedItemsPrice);
//		System.out.println(orderedItems);

		for (int k = 0; k < orderedItems.size(); k++) {
			String orderd = orderedItems.get(k).getText();// .split("change_history");
//			System.out.println("Ordered Items : " + orderedItems.get(k).getText());
			count++;

			System.out.println("Ordered Items : " + orderd);
			System.out.println("Rs : " + orderItemsPriceList.get(k).getText());
		}
		System.err.println("Number of items orderd : " + count);

		WebElement expandButton = driver.findElement(expand);
		expandButton.click();

//		try {
//			Thread.sleep(4000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		String itemCount;

		itemCount = driver.findElement(itemCountElement).getText();
		System.out.println("itemCount" + itemCount);
		int itemCountParsed;
		itemCountParsed = Integer.parseInt(itemCount);
		System.out.println("itemCountParsed : " + itemCountParsed);
		Assert.assertEquals(count, itemCountParsed);

		orderNumberStr = driver.findElement(orderNumber).getText();
		System.out.println("OrderNumber : " + orderNumberStr);

		kotNumber1 = driver.findElement(kOTNumber).getText();
		System.out.println("KOT Number : " + kotNumber1);
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
	}

	public void orderCalculation() {

		System.out.println(" ");
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		System.out.println("**********************************************************************");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.visibilityOfElementLocated(itemPrice));
		String totalItemPrice[] = driver.findElement(itemPrice).getText().split(" ");
		String grandTotal1 = driver.findElement(grandTotal).getText();
		String numbers = totalItemPrice[1].replaceAll(",", "");
		Double totalItemAmount = Double.parseDouble(numbers);
//		itemPriceFinal= Integer.parseInt(numbers);
		Double itemAmount = totalItemAmount;
		Double gst = 5.00;
		Double gstAmount;
		Double serviceCharge = 10.00;
		Double serviceTax = 0.00;
		System.out.println("Total Amount : S" + itemAmount);
		gstAmount = itemAmount * gst / 100;
		System.out.println("GST Amount : " + gstAmount);
		Double amountWithAddedGST = itemAmount + gstAmount;
		System.out.println("Amount with added GST :" + "(" + gst + ")" + amountWithAddedGST);
		Double serviceChargeAmount = itemAmount * serviceCharge / 100;
		System.out.println("Service Charge Amount " + serviceChargeAmount);
		Double afterAddingdServiceCharge = serviceChargeAmount + itemAmount;
		Double serviceTaxAmount = serviceChargeAmount * serviceTax / 100;
		Double totalPrice = itemAmount + gstAmount + serviceChargeAmount + serviceTaxAmount;
		int price = (int) Math.round(totalPrice);
		System.out.println("Total Price : " + price);
		String priceOnScreen[] = driver.findElement(priceOutput).getText().split(" ");
		String billValue = priceOnScreen[1].replace(",", "");
		int billAmount = Integer.parseInt(billValue);
		Assert.assertEquals(price, billAmount);

	}

	public void orderCalculationwithItemDiscount() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		Actions action = new Actions(driver);
		
		int size1 = driver.findElements(orderedItem).size();
		for (int k = 0; k < size1; k++) {
			List<WebElement> ordered = driver.findElements(orderedItem);
			System.out.println(ordered.get(k));
			ordered.get(k).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(addDiscount));
			WebElement addDiscount1 = driver.findElement(addDiscount);

			addDiscount1.click();
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			wait.until(ExpectedConditions.visibilityOfElementLocated(ownersFriend));
			WebElement ownersFriendDiscount = driver.findElement(ownersFriend);
			ownersFriendDiscount.click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(discountConfirmation));
			WebElement confirmation = driver.findElement(discountConfirmation);
			confirmation.click();
		}

	}

}
