package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest2 {
	WebDriver driver;

	@BeforeClass
	public void setup() {
		driver = new ChromeDriver();
		driver.get("https://artoftesting.com/samplesiteforselenium");
		driver.manage().window().maximize();
	}

	@Test
	public void testUIElements() throws InterruptedException {
		
		WebElement textbox = driver.findElement(By.id("fname"));
		textbox.sendKeys("Selenium");
		Thread.sleep(1000);
		WebElement button = driver.findElement(By.id("idOfButton"));
		button.click();
		Assert.assertTrue(button.isDisplayed(),
				"Element is not visible after interaction.");
	}

	@Test
	public void testUIElements2() throws InterruptedException {
		WebElement radioButton = driver.findElement(By.id("male"));
		radioButton.click();
		Thread.sleep(1000);
		WebElement radiofButton = driver.findElement(By.id("female"));
		radiofButton.click();
		WebElement dropdown = driver.findElement(By.id("testingDropdown"));
		Select select = new Select(dropdown);
		select.selectByVisibleText("Automation Testing");
		Assert.assertTrue(dropdown.isDisplayed(), "Element is not visible after interaction.");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
