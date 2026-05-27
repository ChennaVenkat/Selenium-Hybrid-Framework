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
		WebElement draggableElement = driver.findElement(By.id("draggable"));
		
		// Locate droppable target element
		WebElement droppableElement = driver.findElement(By.id("droppable"));
		
		// Scroll until draggable element becomes visible
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView(true);", draggableElement);	
		
		// Wait until source element becomes clickable
		wait.until(ExpectedConditions.visibilityOf(droppableElement));
		
		// Create Actions class object
		Actions actions = new Actions(driver);
		
		// Perform drag and drop action
		actions.dragAndDrop(draggableElement, droppableElement).perform();
		
		String actualMessage = droppableElement.getText();
		String expectedMessage = "Dropped!";
		
		// Validate drag and drop result
		if(actualMessage.equals(expectedMessage)) {
			System.out.println("Drag and Drop operation completed successfully");
		} else {
			System.out.println("Drag and Drop operation failed");
		}
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("arguments[0].scrollIntoView(true);", element);
		driver.quit();
	}

}
