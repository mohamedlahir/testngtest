package com.dinamic.v3.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class OMSPage {
	
	int count = 0;

	private WebDriver driver;

	public OMSPage(WebDriver driver) {

		this.driver = driver;

	}
//	Actions action = new Actions(driver);

	By emailField = By.id("email");
	By passwordField = By.id("password");
	By loginButton = By.xpath("//div[@class='pos-rel']");
	By orders = By.xpath("//span[normalize-space()='Orders']");

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
		By pin1 = By.xpath("//button[normalize-space()='1']");
		By pin2 = By.xpath("//button[normalize-space()='2']");
		By pin3 = By.xpath("//button[normalize-space()='3']");
		By pin4 = By.xpath("//button[normalize-space()='4']");
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

		By start = By.xpath(
				"(//button[@class='btn btn-view start-btn w-100 ng-star-inserted'][normalize-space()='start'])[1]");
		driver.findElement(start).click();
		System.out.println("Start Button is clicked");
		By numberOfPeople = By.xpath("(//input[@id='people_count'])[3]");
		driver.findElement(numberOfPeople).click();
		driver.findElement(numberOfPeople).sendKeys("3");

		By startButton = By.xpath("//span[normalize-space()='Start']");

		driver.findElement(startButton).click();
		By floorName = By.xpath("//span[@class='text-primary cursor']");
		By tableName = By.xpath("//a[@class='d-flex align-items-center ng-star-inserted']");
		String floor = driver.findElement(floorName).getText();
		String tableNumber[] = driver.findElement(tableName).getText().split("chevron_right");
		System.out.println("Floor Name : " + floor);
		System.out.println("Table Number : " + tableNumber[1]);
	}

	public void orderingItems() {

//		By allCategoryItemsName = By.xpath("//p[@class=\"text-limit mb-0 item-name\"]");
//
//		By allCategoryItemsPrice = By.xpath("//p[@class=\"mb-0 item-price\"]");
//		// span[@class="ng-star-inserted"]
//
//		By allCategoryItemsCategory = By.xpath("//span[@class='ng-star-inserted']");
//
//		List<WebElement> allCategoryItemsList = driver.findElements(allCategoryItemsName);
//		List<WebElement> allCategoryItemsPriceList = driver.findElements(allCategoryItemsPrice);
//		List<WebElement> allCategoryItemsCategoryList = driver.findElements(allCategoryItemsCategory);
//
//		for (int i = 0; i < allCategoryItemsList.size(); i++) {
//			System.out.println("Item Name : " + allCategoryItemsList.get(i).getText());
//			System.out.println("Item Price : " + allCategoryItemsPriceList.get(i).getText());
//			System.out.println("Item Category : " + allCategoryItemsCategoryList.get(i).getText());
//
//		}
//		System.out.println("Printing only first 20 items as the page has PAGINATION Concept implemented");
//		System.out.println("Item Count : " + allCategoryItemsList.size());
		By itemCards = By
				.xpath("//div[@class='oms-container-category__container__content__body__card p-2 card-ripple']");

		List<WebElement> allItemsCards = driver.findElements(itemCards);
		for (int j = 0; j < 5; j++) {
			allItemsCards.get(j).click();
		}

		By confirmaKOT = By.xpath("//span[normalize-space()='Confirm KOT']");
		driver.findElement(confirmaKOT).click();
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		By orderedItem = By.xpath("//div[@class='d-flex align-items-center']");
		List<WebElement> orderedItems = driver.findElements(orderedItem);
		By orderedItemsPrice = By.xpath("//div[@class='ft-10 prtxt-right text-right doNotPrint']");
		List<WebElement> orderItemsPriceList = driver.findElements(orderedItemsPrice);
//		System.out.println(orderedItems);
		
		for (int k = 0; k < orderedItems.size(); k++) {
			String orderd[] = orderedItems.get(k).getText().split("change_history");
//			System.out.println("Ordered Items : " + orderedItems.get(k).getText());
			count++;

			System.out.println("Ordered Items : " + orderd[1]);
			System.out.println("Rs : " + orderItemsPriceList.get(k).getText());
		}
		System.err.println("Number of items orderd : " + count);
		By expand = By.xpath("//i[normalize-space()='expand_more']");
		WebElement expandButton = driver.findElement(expand);
		expandButton.click();
		
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String itemCount;
		By itemCountElement = By.cssSelector("div[class='mb-2 clearfix ft-11 ng-star-inserted'] div div[class='text-right'] span");
		
		itemCount = driver.findElement(itemCountElement).getText();
		System.out.println("itemCount"+itemCount);
		int itemCountParsed;
		 itemCountParsed =Integer.parseInt(itemCount);
		 System.out.println("itemCountParsed : "+itemCountParsed);
		Assert.assertEquals(count, itemCountParsed);
		
		}
	}


