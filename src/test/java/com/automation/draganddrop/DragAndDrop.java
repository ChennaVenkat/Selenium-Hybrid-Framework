package com.automation.draganddrop;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DragAndDrop {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://testautomationpractice.blogspot.com/");
		
		// Create explicit wait object
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		// Locate draggable source element
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		
		// Locate droppable target element
		WebElement targetElement = driver.findElement(By.id("droppable"));
		
		// Scroll until draggable element becomes visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", sourceElement);	
		
		// Wait until source element becomes clickable
		wait.until(ExpectedConditions.visibilityOf(sourceElement));
		
		// Create Actions class object
		Actions actions = new Actions(driver);
		
		// Perform drag and drop action
		actions.dragAndDrop(sourceElement, targetElement).perform();
		
		String actualDropMessage = targetElement.getText();
		String expectedDropMessage = "Dropped!";
		
		// Validate drag and drop result
		if(actualDropMessage.equals(expectedDropMessage)) {
			System.out.println("Drag and Drop operation completed successfully");
		} else {
			System.out.println("Drag and Drop operation failed");
		}
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.quit();
	}

}
