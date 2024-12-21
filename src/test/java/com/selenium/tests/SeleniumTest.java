package com.selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SeleniumTest {
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
		Thread.sleep(1000);
		Assert.assertTrue(button.isDisplayed(),
				"Element is not visible after interaction.");
	}

	@AfterClass
	public void teardown() {
		driver.quit();
	}
}
