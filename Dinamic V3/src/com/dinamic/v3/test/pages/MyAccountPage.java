package com.dinamic.v3.test.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class MyAccountPage {

	By positionsButtion = By.xpath("//span[normalize-space()='Positions']");

	By membersButton = By.xpath("//span[normalize-space()='Members']");

	By dashboardButton = By.cssSelector("body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > "
			+ "main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > "
			+ "section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > "
			+ "div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > "
			+ "div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > "
			+ "div:nth-child(1) > span:nth-child(2)");

	By orderHistory = By.cssSelector(
			"body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");

	By taxRates = By.xpath(
			"body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");

	By paymentMethods = By.cssSelector(
			"body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");

	By availablePostions = By
			.xpath("//div[@class=\"w-40 w-sm-100 breakword pb-lg-0 pb-2 order_2 cat-name text-limit\"]");

	By myAccount = By.cssSelector(
			"div[class='d-flex align-items-center push-48-t push-48-b msvg'] div span[class='h4 d-block pl-2 mb-0']");

	By members = By.xpath("//div[@class=\"w-15 w-sm-100 breakword pb-lg-0 pb-2 order_2 cat-name text-limit\"]");

	By backButton = By.xpath("//i[normalize-space()='arrow_back']");

	By addPositionButton = By.xpath("//button[@type='button'] //span[@class='ng-star-inserted']");

	By addPositionsTextBox = By.xpath("//div[@class='col-lg-8 col-md-8 col-12']//input[@id='position']");

	By tableFunctions = By.xpath("//label[@for='item_1_0']//span[@class='slider round']");

	By addPositionsAllToggleSwitch = By.xpath("//label[@for='item_1_1_0']//span[@class='slider round']");

	By addPositionsSaveButton = By.cssSelector(
			"body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-positions:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > button:nth-child(1) > span:nth-child(2)");

	By pin1 = By.xpath("//button[@class='pin-button ng-star-inserted'][normalize-space()='1']");

	By pin2 = By.xpath("//button[@class='pin-button ng-star-inserted'][normalize-space()='2']");
	By pin3 = By.xpath("//button[@class='pin-button ng-star-inserted'][normalize-space()='3']");
	By pin4 = By.xpath("//button[@class='pin-button ng-star-inserted'][normalize-space()='4']");

	private WebDriver driver;

	public MyAccountPage(WebDriver driver) {

		this.driver = driver;
	}

	public void getAvailablePositions() {

		System.out.println("===================================================================");
		driver.findElement(positionsButtion).click();

		List<WebElement> availablePositionElement = driver.findElements(availablePostions);
		System.out.println("Available Positions listed below");
		for (int i = 0; i < availablePositionElement.size(); i++) {

			System.out.println(availablePositionElement.get(i).getText());
		}

	}

	public void addPositions() {
		System.out.println("===================================================================");
		driver.findElement(addPositionButton).click();
		driver.findElement(addPositionsTextBox).sendKeys("Automated Positions");
		driver.findElement(tableFunctions).click();
		driver.findElement(addPositionsAllToggleSwitch).click();
		driver.findElement(addPositionsSaveButton).click();
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();
		System.out.println("Position is created");
	}

	public void getMembers() {
		System.out.println("===================================================================");
		
		driver.findElement(backButton).click();
		driver.findElement(membersButton).click();
		List<WebElement> availableMembers = driver.findElements(members);
		System.out.println("Available Staff : ");
		for (int i = 0; i < availableMembers.size(); i++) {
			System.out.println(availableMembers.get(i).getText());

		}

	}

}
