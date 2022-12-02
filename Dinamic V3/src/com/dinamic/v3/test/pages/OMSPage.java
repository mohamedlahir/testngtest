package com.dinamic.v3.test.pages;

import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OMSPage {

	private WebDriver driver;

	public OMSPage(WebDriver driver) {

		this.driver = driver;

	}

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
		String pin[] = { "1", "2", "3", "4" };
		By pin1 = By.xpath("//button[normalize-space()='1']");
		By pin2 = By.xpath("//button[normalize-space()='2']");
		By pin3 = By.xpath("//button[normalize-space()='3']");
		By pin4 = By.xpath("//button[normalize-space()='4']");
		driver.findElement(pin1).click();
		driver.findElement(pin2).click();
		driver.findElement(pin3).click();
		driver.findElement(pin4).click();	
	}
	
	public void ordering() {
		By start = By.xpath("(//button[@class='btn btn-view start-btn w-100 ng-star-inserted'][normalize-space()='start'])[1]");
		driver.findElement(start).click();
		By numberOfPeople = By.id("people_count");
		driver.findElement(numberOfPeople).sendKeys("7");
		By startButton = By.xpath("//button[@class='btn btn-purple mr-3 d-flex align-items-center justify-content-center ng-star-inserted']//span[@class='material-symbols-outlined pr-2'][normalize-space()='check_circle']");
		driver.findElement(startButton).click();	
		System.out.println("orderinggg completed");
	}
}
