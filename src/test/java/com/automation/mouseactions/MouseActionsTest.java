package com.automation.mouseactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MouseActionsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/buttons");
		// Add implicit wait to handle synchronization issues
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

		
		//  Create Actions class object to perform mouse actions
		Actions action = new Actions(driver);
		
		// =========================================================
        // FLOW 1 — DOUBLE CLICK ACTION
        // =========================================================
		
		// Locate 'double click me' button
		WebElement doubleClickButton = driver.findElement(By.id("doubleClickBtn"));
		//action.doubleClick(doubleClickButton).build().perform();
		
		((org.openqa.selenium.JavascriptExecutor) driver)
        .executeScript("arguments[0].scrollIntoView(true);", doubleClickButton);
		
		
		// perform double click action on the button
		action.doubleClick(doubleClickButton).perform();
		
		//  Capture actual success message displayed after double click
		//String actualDoubleClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
		String actualDoubleClickMessage=wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("doubleClickMessage"))).getText();
		String expectedDoubleClickMessage = "You have done a double click";
		
		 // Validate actual message with expected message
		if(actualDoubleClickMessage.equals(expectedDoubleClickMessage)) {
			System.out.println("Validation Passed - Double Click action is successful");
		} else {
			System.out.println("Validation Failed - Double Click action is unsuccessful");
		}
		
		
		System.out.println();
		// =========================================================
        // FLOW 2 — RIGHT CLICK ACTION
        // =========================================================
		
		  // Locate the "Right Click Me" button
		WebElement rightClickButton = driver.findElement(By.id("rightClickBtn"));
		
		// Scroll into view (IMPORTANT FIX)
		((org.openqa.selenium.JavascriptExecutor) driver)
		        .executeScript("arguments[0].scrollIntoView(true);", rightClickButton);
		
	     // Perform right click action on the button
		action.contextClick(rightClickButton).perform();
		
		  // Capture actual success message displayed after right click
		//String actualRightClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
		String actualRightClickMessage =wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("rightClickMessage"))).getText();
		
		  // Define expected success message
		String expectedRightClickMessage = "You have done a right click";
		
		  // Validate actual message with expected message
		if(actualRightClickMessage.equals(expectedRightClickMessage)) {
			System.out.println("Validation Passed - Right Click action is successful");
		} else {
			System.out.println("Validation Failed - Right Click action is unsuccessful");
		}
		
		// =========================================================
        // FLOW 3 — DYNAMIC CLICK ACTION
        // =========================================================
		
		  // Locate the "Click Me" button using XPath
		WebElement clickMeBtn = driver.findElement(By.xpath("//button[normalize-space()='Click Me']"));
		
		  // Perform normal click action
		action.click(clickMeBtn).perform();
		
	    // Capture actual success message displayed after dynamic click
		WebElement clickMessage = driver.findElement(By.id("dynamicClickMessage"));
		String expectedClickMessage = "You have done a dynamic click";
		
		 // Validate actual message with expected message
		if(clickMessage.getText().equals(expectedClickMessage)) {
			System.out.println("Validation Passed - Dynamic Click action is successful");
		} else {
			System.out.println("Validation Failed - Dynamic Click action is unsuccessful");
		}
		
		driver.quit();
	}
}


