package com.dinamic.v3.test.pages;

import org.openqa.selenium.By;

public class MyAccountPage {

	By positionsButtion = By.xpath("//span[normalize-space()='Positions']");

	By membersButton = By.xpath("//span[normalize-space()='Members']");

	By dashboardButton = By.cssSelector(
			"body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > "
			+ "main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > "
			+ "section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > "
			+ "div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > "
			+ "div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > "
			+ "div:nth-child(1) > span:nth-child(2)");

	By orderHistory = By.cssSelector("body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");
	
	By taxRates = By.xpath("body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(2) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");

	By paymentMethods = By.cssSelector("body > app-root:nth-child(1) > app-sidebar-layout:nth-child(2) > main:nth-child(1) > app-home:nth-child(4) > main:nth-child(1) > div:nth-child(1) > section:nth-child(1) > div:nth-child(1) > div:nth-child(2) > div:nth-child(2) > div:nth-child(1) > div:nth-child(2) > div:nth-child(1) > div:nth-child(1) > div:nth-child(3) > a:nth-child(1) > div:nth-child(1) > div:nth-child(1) > span:nth-child(2)");
	
	By availablePostions = By.xpath("//div[@class=\"w-40 w-sm-100 breakword pb-lg-0 pb-2 order_2 cat-name text-limit\"]");
	
	By myAccount = By.cssSelector("div[class='d-flex align-items-center push-48-t push-48-b msvg'] div span[class='h4 d-block pl-2 mb-0']");
	
	
}
