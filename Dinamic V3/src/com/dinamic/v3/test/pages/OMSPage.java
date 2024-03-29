package com.dinamic.v3.test.pages;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class OMSPage {

	int count = 0;

	List a = new ArrayList();

	String orderNumberStr;

	String kotNumber1;

	String orderedItemprice[];

	int itemTotal;

	int gSTValue = 5;

	int itemPriceFinal;

	double init = 0;

	Double gst = 5.00;

	int itemCountParsed;

	private WebDriver driver;

	double itemOwnerDiscount = 20.00;

	Double serviceCharge = 10.00;

	double orederDiscount = 20.00;

	By start = By.xpath("(//button[@data-toggle='modal'][normalize-space()='start'])[1]");

	By kOTNumber = By.xpath("//span[@class='ft-8']");

	By pin1 = By.xpath("//button[normalize-space()='1']");

	By pin2 = By.xpath("//button[normalize-space()='1']");

	By pin3 = By.xpath("//button[normalize-space()='1']");

	By pin4 = By.xpath("//button[normalize-space()='1']");

	By numberOfPeople = By.xpath("(//input[@id='people_count'])[3]");

	By emailField = By.id("email");

	By passwordField = By.id("password");

	By loginButton = By.xpath("//div[@class='pos-rel']");

	By orders = By.xpath("//span[normalize-space()='Orders']");

	By startButton = By.xpath("//span[normalize-space()='Start']");

	By floorName = By.xpath("//span[@class='text-primary cursor']");

	By tableName = By.xpath("//a[@class='d-flex align-items-center ng-star-inserted']");

	By itemCards = By
			.xpath("//div[@class=\"oms-container-category__container__content__body__card w-100 p-2 card-ripple\"]");

	By orderedItem = By.xpath("//div[@class='d-flex align-items-center']");

	By orderedItemsPrice = By.xpath("//div[@class='ft-10 prtxt-right text-right doNotPrint']");

	By expand = By.xpath("//i[normalize-space()='expand_more']");

	By itemCountElement = By.cssSelector(

			"body > app-root:nth-child(1) > app-half-layout-navbar:nth-child(2) > main:nth-child(1) > div:nth-child(2) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > app-order-summary:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(4) > div:nth-child(2) > div:nth-child(3) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > span:nth-child(1)");
	By orderNumber = By.cssSelector("span[class='d-flex align-items-center w-100'] span:nth-child(2)");

	By confirmaKOT = By.xpath("//span[normalize-space()='Confirm KOT']");

	By itemPrice1 = By.cssSelector("div[class='mb-2 clearfix no-margin ft-11'] div div[class='text-right'] span");

	By grandTotal = By.xpath("//span[@class='order-foot-total ft-15']");

	By priceOutput = By.xpath("//span[@class='order-foot-total ft-15']");

	By addDiscount = By.xpath("(//button[@type='button'][normalize-space()='Add Discount'])[1]");

	By ownersFriend = By.xpath("//li[1]//div[1]//h6[1]");

	By discountConfirmation = By.xpath("//button[normalize-space()='Confirm']");

	By discountedAmount = By.xpath("//div[@class='ft-10 prtxt-right text-right doNotPrint']");

	By discountItemPrice = By.xpath("//div[@class='ft-10 prtxt-right text-right doNotPrint']");

	By logout = By.id("navbarDropdownMenuLink_2");

	By logout2 = By.xpath("//div //a[normalize-space()='Logout'][1]");

	By orderDiscountButton = By
			.cssSelector("button[class='btn btn-block btn-yellow p-lg-4 p-3 mr-3 ng-star-inserted']");

	By myAccountButtonMain = By.cssSelector(
			"div[class='d-flex align-items-center push-48-t push-48-b msvg'] div span[class='h4 d-block pl-2 mb-0']");

	By cancelOrderButton = By.xpath(
			"//button[@class='btn btn-red-text p-0 d-flex align-items-center justify-content-center ng-star-inserted']");

	By orderDeleteButton = By.cssSelector(
			"button[class='btn btn-red mr-3 d-flex align-items-center justify-content-center'] span[class='ng-star-inserted']");

	By tableCounts = By.xpath("//div[@class='reserve-card ng-star-inserted']");

	By settleBill = By.cssSelector("button[class='btn btn-block btn-green p-lg-4 p-3 mr-3 ng-star-inserted']");

	By viewButtonCount = By.cssSelector(".btn.btn-green.w-100");

	By thridFloor = By.xpath("//span[normalize-space()='Third Floor']");

	double calculatedAmount;

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
		System.out.println("======================================================================================");
		System.out.println("Logged in as " + emailField);
		System.out.println("======================================================================================");
	}

	public void order() {
		System.out.println("======================================================================================");
		driver.findElement(orders).click();

		driver.findElement(pin1).click();
		driver.findElement(pin1).click();
		driver.findElement(pin1).click();
		driver.findElement(pin1).click();

//		driver.findElement(pin2).click();
//		driver.findElement(pin3).click();
//		driver.findElement(pin4).click();

		try {

			Thread.sleep(1000);

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("======================================================================================");
	}

	public void enteringPinForMyAccount() {

		driver.findElement(myAccountButtonMain).click();

		driver.findElement(pin1).click();

		driver.findElement(pin2).click();

		driver.findElement(pin3).click();

		driver.findElement(pin4).click();
	}

	public void ordering() throws InterruptedException {

		Actions action = new Actions(driver);

		System.out.println("Ordering Method Called");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))

				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		WebElement printer = driver.findElement(By.xpath("//span[normalize-space()='Disconnected']")); // printer state
		System.out.println("Printer is in Disconnected State : " + printer.getText());

		wait.until(
				ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='Connected']")));

		for (int i = 0; i < 1; i++) {

			Thread.sleep(2000);

			// ALL FLOOR BUTTON
//			driver.findElement(By.xpath("//a[@id='/orders/table-list/all']")).click();

			driver.findElement(By.xpath("//span[normalize-space()='Floor 1']")).click();

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(start));

			driver.findElement(start).click();

			System.out.println("Table is started");

			driver.findElement(numberOfPeople).click();

			driver.findElement(numberOfPeople).sendKeys("3");

			driver.findElement(startButton).click();

			String floor = driver.findElement(floorName).getText();

			String tableNumber[] = driver.findElement(tableName).getText().split("chevron_right");

			System.out.println("Floor Name : " + floor);

			System.out.println("Table Number : " + tableNumber[1]);

			List<WebElement> allItemsCards = driver.findElements(itemCards);

			for (int j = 0; j < 5; j++) {

				wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemCards));

				action.click(allItemsCards.get(j)).build().perform();

			}

			driver.findElement(confirmaKOT).click();

			System.out.println(driver.getCurrentUrl());

			Thread.sleep(5000);
			String orderID = driver
					.findElement(By.cssSelector("span[class='d-flex align-items-center w-100'] span:nth-child(2)"))
					.getText();
			System.out.println(orderID);
			Thread.sleep(4000);

			driver.findElement(By.xpath("//img[@alt='logo']")).click();
		}
	}

	public void viewButtonOrdering() throws InterruptedException {

		for (int loop = 0; loop < 1; loop++) {

			Actions action = new Actions(driver);

			System.out.println("Ordering Method Called");

			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(120))

					.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
			WebElement printer = driver.findElement(By.xpath("//span[normalize-space()='Disconnected']")); // printer
																											// state
			System.out.println("Printer is in Disconnected State : " + printer.getText());

			wait.until(ExpectedConditions
					.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='Connected']")));

			for (int i = 0; i < 1; i++) {

				Thread.sleep(2000);

				Select tableSelect = new Select(driver.findElement(By.xpath("//select[@name='tableFilter']")));

				tableSelect.selectByIndex(1);

				List<WebElement> viewButton = driver.findElements(By.xpath("//button[contains(text(),'view')]"));

				viewButton.get(i).click();

				String floor = driver.findElement(floorName).getText();

				String tableNumber[] = driver.findElement(tableName).getText().split("chevron_right");

				System.out.println("Floor Name : " + floor);

				System.out.println("Table Number : " + tableNumber[1]);

				List<WebElement> allItemsCards = driver.findElements(itemCards);

				for (int j = 0; j < 5; j++) {

					wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(itemCards));

					action.click(allItemsCards.get(j)).build().perform();

				}

				driver.findElement(confirmaKOT).click();

				Thread.sleep(4000);

				driver.findElement(By.xpath("//img[@alt='logo']")).click();
			}
		}
	}

	public void confirmKOT() {

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		Actions action = new Actions(driver);

		Select tableSelect = new Select(driver.findElement(By.xpath("//select[@name='tableFilter']")));

		tableSelect.selectByIndex(3);

		List<WebElement> listRed = driver
				.findElements(By.xpath("//button[@class='btn btn-red blink text-limit w-100 ng-star-inserted']"));

		System.out.println("Table Count : " + listRed.size());

		for (int i = 0; i < listRed.size(); i++) {

			driver.findElement(By.xpath(
					"(//button[@class='btn btn-red blink text-limit w-100 ng-star-inserted'][normalize-space()='New Order'])[1]"))
					.click();

			driver.findElement(
					By.xpath("//button[@class='btn btn-purple p-lg-4 p-3 d-flex align-items-center ng-star-inserted']"))
					.click();
		}

	}

	public void orderCalculation() {
		System.out.println("======================================================================================");

		System.out.println("Testing Order Calculation without any discount");

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		Actions action = new Actions(driver);

		List<Integer> amount = new ArrayList();

		int calculatedAmount = 0;

		List<WebElement> orderItemsPriceList = driver.findElements(orderedItemsPrice);

		for (int k = 0; k < orderItemsPriceList.size(); k++) {

			String orderd = orderItemsPriceList.get(k).getText();// .split("change_history");

			Integer amountOnItems = Integer.parseInt(orderItemsPriceList.get(k).getText());

			amount.add(amountOnItems);

			calculatedAmount = calculatedAmount + amount.get(k);
		}

		System.out.println("Total Item Amount : " + calculatedAmount);

		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String totalItemPrice[] = driver.findElement(By.xpath("//span[normalize-space()='INR 2,197.00']")).getText()
				.split(" ");

		String dummy = totalItemPrice[1].substring(0, 5);

		String numbers = dummy.replaceAll(",", "");

		Double totalItemAmount = Double.parseDouble(numbers);

		itemPriceFinal = Integer.parseInt(numbers);

		System.out.println("Total Item Price : " + itemPriceFinal);

		String grandTotal1 = driver.findElement(grandTotal).getText();

		System.out.println("Grand Total On Screen : " + grandTotal1);

		Double itemAmount = Double.parseDouble(numbers);

		Double gstAmount;

		Double serviceTax = 0.00;

		System.out.println("Total Amount : " + itemAmount);

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

		System.out.println("======================================================================================");

	}

	public void orderCalculationwithItemDiscount() {
		System.out.println("======================================================================================");
		System.out.println("Testing Calculation with Item Discount, 20% discount applied on all items ordered");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		Actions action = new Actions(driver);

		WebElement downArrow = driver.findElement(expand);
		downArrow.click();
		int size = driver.findElements(By.xpath("//div[@class='oms-main__items__box mtt-1 ng-star-inserted']")).size();
		for (int k = 0; k < size; k++) {
			List<WebElement> ordered1 = driver
					.findElements(By.xpath("//div[@class='oms-main__items__box mtt-1 ng-star-inserted']"));
			ordered1.get(k).click();
			wait.until(ExpectedConditions.visibilityOfElementLocated(addDiscount));
			WebElement addDiscount1 = driver.findElement(addDiscount);
			addDiscount1.click();
			try {
				Thread.sleep(4000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			WebElement ownersFriendDiscount = driver.findElement(ownersFriend);
			ownersFriendDiscount.click();
			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(discountConfirmation));
			WebElement confirmation = driver.findElement(discountConfirmation);
			confirmation.click();
		}
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		List<WebElement> itemPriceAfterDiscount = driver.findElements(discountItemPrice);

		for (int i = 0; i < itemPriceAfterDiscount.size(); i++) {
			a.add(itemPriceAfterDiscount.get(i).getText());
			System.out.println("Price After Discount : " + a.get(i));
		}

		for (int n = 0; n < a.size(); n++) {
			String amount = a.get(n).toString();
			double amountParsed = Double.parseDouble(amount);
			init = init + amountParsed;
		}
		System.err.println("Total item amount after discount on all items : " + init);
		double taxAmount = init * gst / 100;
		System.out.println("CGST : " + taxAmount / 2);
		System.out.println("SGST : " + taxAmount / 2);
		System.out.println("Total Tax Amount on foods  after Discount : " + taxAmount);
		double serviceChargeAmount = init * serviceCharge / 100;
		System.out.println("Service Charge Amount : " + serviceChargeAmount);
		double grandTotalAfterDiscount = init + taxAmount + serviceChargeAmount;
		int price = (int) Math.round(grandTotalAfterDiscount);
		String priceOnScreen[] = driver.findElement(priceOutput).getText().split(" ");
		String billValue = priceOnScreen[1].replace(",", "");
		int billAmount = Integer.parseInt(billValue);
		Assert.assertEquals(billAmount, price);
		System.out.println("======================================================================================");
	}

	public void orderDiscount() {
		System.out.println("======================================================================================");
		System.out.println("Testing Calculation with item discount and Order Discount, 20% discount Applied");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		Actions action = new Actions(driver);
		WebElement oDiscountButton = driver.findElement(orderDiscountButton);
		oDiscountButton.click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		wait.until(ExpectedConditions.visibilityOfElementLocated(ownersFriend));
		WebElement ownerFirendButton = driver.findElement(ownersFriend);
		ownerFirendButton.click();
		driver.findElement(discountConfirmation).click();
		driver.findElement(expand).click();
		wait.until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath("//span[normalize-space()='INR 2,197.00']")));
		String totalItemPrice[] = driver.findElement(By.xpath("//span[normalize-space()='INR 2,197.00']")).getText()
				.split(" ");
		System.out.println("test : " + totalItemPrice[1]);

		String dummy = totalItemPrice[1].substring(0, 5);

		String numbers = dummy.replaceAll(",", "");

		Double totalItemAmount = Double.parseDouble(numbers);

		itemPriceFinal = Integer.parseInt(numbers);

		System.out.println("Total Item Price : " + itemPriceFinal);

		double amountDiscounted = totalItemAmount * orederDiscount / 100;

		System.out.println("Item Discounted Amount " + amountDiscounted);

		double subractedAmount = totalItemAmount - amountDiscounted;

		System.out.println("Cost after Item Discount : " + subractedAmount); // 1756.6

		System.out.println("Order Discount Type : "
				+ driver.findElement(By.xpath("//div[@id='accordionEx']//div[7]//div[2]//div[1]//span[1]")).getText());

		double orderDiscountAmount = subractedAmount * orederDiscount / 100;

		System.out.println("Order Discount Amount : " + orderDiscountAmount);

		double afterDiscount = subractedAmount - orderDiscountAmount;

		System.out.println("Total Cost After Discount : " + afterDiscount); // 1406.08

		double gstAmount = afterDiscount * gst / 100;

		System.out.println("GST Amount" + gstAmount);

		double serviceCharge1 = afterDiscount * serviceCharge / 100;

		Double totalPrice = afterDiscount + gstAmount + serviceCharge1;

		int price = (int) Math.round(totalPrice);

		String priceOnScreen[] = driver.findElement(priceOutput).getText().split(" ");

		String billValue = priceOnScreen[1].replace(",", "");

		int billAmount = Integer.parseInt(billValue);

		System.err.println("Total Price : " + price);

		Assert.assertEquals(price, billAmount);

		System.out.println("======================================================================================");
	}

	// +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

	By tableCount = By.xpath("//div[@class='reserve-card ng-star-inserted']");

	By dinamicLogo = By.xpath("//img[@alt='logo']");

	String floor1 = "First Floor";

	String floor2 = "Second Floor";

	String floor3 = "Third Floor";

	public void cancelOrder() {

		try {

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		driver.findElement(cancelOrderButton).click();
		driver.findElement(orderDeleteButton).click();

	}

	public void tableCount() {
		System.out.println("======================================================================================");
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		Actions action = new Actions(driver);
		wait.until(ExpectedConditions.elementToBeClickable(dinamicLogo));
		driver.findElement(dinamicLogo).click();
		int number = driver.findElements(tableCount).size();
		System.out.println("number of tables in this floor : " + number);
		for (int i = 2; i < 5; i++) {
			By floor = By.xpath("//li[@class='pos-rel ng-star-inserted']" + "[" + i + "]");
			WebElement floorName = driver.findElement(floor);
			String name[] = floorName.getText().split("deck");
			System.out.println("Available Floors : " + name[1]);
		}
		System.out.println("======================================================================================");
	}

	public void settleBill() {

	}

	public void printerCheck() throws InterruptedException {

//		List<WebElement> button = driver.findElements(viewButtonCount);
//	
//
//		System.out.println("View Buttonl Size : " + button.size());
//		
		Actions action = new Actions(driver);

		for (int b = 0; b < 3; b++)

		{

			List<WebElement> lahir = driver.findElements(viewButtonCount);

			Thread.sleep(3000);

			action.click(lahir.get(b)).build().perform();

			Thread.sleep(3000);

			driver.findElement(By.xpath("//span[normalize-space()='Print Bill']")).click();

			driver.findElement(By.xpath("//span[@class='text-primary cursor']")).click();

//			Thread.sleep(4000);

		}

	}

	public void CareCheckThirdFloor() throws InterruptedException {
		List<WebElement> viewElement = driver.findElements(By.xpath("//button[contains(text(),'view')]"));

		int numbers = viewElement.size();

		System.out.println("View Button :" + numbers);

		for (int j = 0; j < numbers; j++) {

			Thread.sleep(3000);

//			driver.findElement(By.xpath("//a[@id='/orders/table-list/all']")).click();

			Select tableSelect = new Select(driver.findElement(By.xpath("//select[@name='tableFilter']")));

			tableSelect.selectByIndex(1);

			driver.findElement(By.xpath("(//button[contains(text(),'view')])[1]")).click();

//			driver.findElement(By.xpath("//button[normalize-space()='New Order']")).click();

//			driver.findElement(By.xpath("//span[normalize-space()='Confirm KOT']")).click();

			Thread.sleep(4000);

			driver.findElement(By.xpath("//button[normalize-space()='Settle Bill']")).click();

			Thread.sleep(4000);

			driver.findElement(By.xpath("//h6[normalize-space()='Total']")).click();

			Thread.sleep(4000);

			driver.findElement(By.xpath("//button[normalize-space()='pay']")).click();

			Thread.sleep(4000);

			driver.findElement(By.xpath("//button[normalize-space()='Confirm']")).click();

			Thread.sleep(4000);

			driver.findElement(By.xpath("//button[normalize-space()='Checkout']")).click();

		}

	}

	public void checkout() throws InterruptedException {

		Actions action = new Actions(driver);

		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);

		Select tableSelect = new Select(driver.findElement(By.xpath("//select[@name='tableFilter']")));

		tableSelect.selectByIndex(1);

		List<WebElement> count = driver.findElements(By.xpath("//button[contains(text(),'view')]"));

		int counts = count.size();

		for (int i = 0; i < counts; i++) {

			wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//button[@id='dropdownMenu1']")));

			List<WebElement> view = driver.findElements(By.xpath("//button[@id='dropdownMenu1']"));

			action.click(view.get(0)).build().perform();

			List<WebElement> quickCheckout = driver
					.findElements(By.xpath("//a[@class='dropdown-item'][normalize-space()='Quick Checkout']"));

			System.out.println("Quick Checkout : " + quickCheckout.size());

			quickCheckout.get(0).click();

			driver.findElement(By.xpath("//div[@id='quick_check_out']//span[contains(text(),'Confirm')]")).click();

			Thread.sleep(5000);

		}

	}

	public void logout() {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10))
				.pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
		Actions action = new Actions(driver);
		try {

			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		WebElement logoutButton = driver.findElement(logout);
		action.click(logoutButton).build().perform();
		WebElement logoutButton2 = driver.findElement(logout2);
		wait.until(ExpectedConditions.elementToBeClickable(logout2));
		action.click(logoutButton2).build().perform();
		System.err.println("Logged out");
	}

}