package com.automation.alerts;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptAlertTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		
		//******  Flow 1  ******
		WebElement jsAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Alert']"));
		jsAlertButton.click();
		
		//switching the cursor control over alert pop-up
		Alert jsAlert= driver.switchTo().alert();
		
		//clicking ok/accept on the popup
		jsAlert.accept();
		/*
		// gets the text on the popup
		String jsAlertText = jsAlert.getText();
		
		String expectedAlertMessage1 = "I am a JS Alert";
		
		// Validation
		if(jsAlertText.equals(expectedAlertMessage1)) {
			System.out.println("Validation1 got passed");
		}else {
			System.out.println("Validation1 got failed");
		}
		*/
		WebElement jsAlertResult = driver.findElement(By.id("result"));
		String expectedJsAlertResult="You successfully clicked an alert";
		if(jsAlertResult.getText().equals(expectedJsAlertResult)) {
			System.out.println("Validation1 got passed ");
		} else {
			System.out.println("Validation1 got failed");
		}
		
		
		//******  Flow 2  ******
		WebElement jsConfirmAlertButton = driver.findElement(By.xpath("//button[text()='Click for JS Confirm']"));
		jsConfirmAlertButton.click();
		
		//switching the cursor control over alert pop-up
		Alert jsConfirmAlert= driver.switchTo().alert();
		
		// clicking cancel/dismiss on the pop-up
		jsConfirmAlert.dismiss();
		
		//capturing the alert result from the html dom
		WebElement jsConfirmAlertResult = driver.findElement(By.id("result"));
		
		String actualtConfirmAlertText = jsConfirmAlertResult.getText();		
		String expectedConfirmAlertResult = "You clicked: Cancel";
		
		//Validation 2
		if(actualtConfirmAlertText.equals(expectedConfirmAlertResult)) {
			System.out.println("Validation2 passed");
		} else {
			System.out.println("Validation2 failed");
		}
		
		
		//******  Flow 3  ******
		WebElement jsPromptAlertButton = driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']"));
		jsPromptAlertButton.click();
		
		//switching the cursor control over alert pop-up
		Alert jsPromptAlert = driver.switchTo().alert();
		
		// entering text to the input field of alert
		jsPromptAlert.sendKeys("Selenium");
		
		
		jsPromptAlert.accept();
		String jsPromptAlertResult = driver.findElement(By.id("result")).getText();
		String expectedPromptAlertResult = "You entered: Selenium";
		
		//Validation 3
		if(jsPromptAlertResult.equals(expectedPromptAlertResult)) {
			System.out.println("Validation3 got passed");
		}else {
			System.out.println("Validation3 got failed");
		}
		driver.quit();
	}

}
