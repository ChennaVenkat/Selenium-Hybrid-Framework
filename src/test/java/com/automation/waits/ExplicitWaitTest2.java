package com.automation.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_controls");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		WebElement removeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='checkbox']/following-sibling::button[text()='Remove']")));
		removeButton.click();
		WebElement itsGoneElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
		String actualMessage = itsGoneElement.getText();
		String expectedMessage = "It's gone!";
		if(actualMessage.equals(expectedMessage)) {
			System.out.println("Validation passed");
		} else {
			System.out.println("Validation Failed");
		}
		
		WebElement addButtonElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//form[@id='checkbox-example']//button")));
		addButtonElement.click();
		
		WebElement itsBackElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//form[@id='checkbox-example']//p[@id='message']")));
		
		String actualMessage2 = itsBackElement.getText();
		String expectedMessage2 = "It's back!";
		
		if(actualMessage2.equals(expectedMessage2)) {
			System.out.println("Validation2 passed");
		}else {
			System.out.println("Validation2 Failed");
		}
		
		driver.quit();
	}

}
