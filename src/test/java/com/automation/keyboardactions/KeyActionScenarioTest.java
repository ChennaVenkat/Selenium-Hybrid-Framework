package com.automation.keyboardactions;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class KeyActionScenarioTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		
		WebElement userNameField = driver.findElement(By.id("username"));
		WebElement passwordField = driver.findElement(By.id("password"));
		
		// scenario 1 - copy & paste
		userNameField.sendKeys("tomsmith");
		userNameField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		userNameField.sendKeys(Keys.chord(Keys.CONTROL,"c"));
		

		passwordField.click();
		passwordField.sendKeys(Keys.chord(Keys.CONTROL,"v"));
		
		String passwordValue = passwordField.getAttribute("value");
		
		System.out.println(	"Password is : "+passwordValue);
		Assert.assertEquals(passwordValue,
				"tomsmith", 
				"Copied text was not pasted correctly."
		);
		
		// scenario 2 - CTRL+A + DELETE
		
		passwordField.sendKeys(Keys.chord(Keys.CONTROL,"a"));
		passwordField.sendKeys(Keys.DELETE);

		String passwordValueAfterDelete = passwordField.getAttribute("value");
		System.out.println(	"Password after delete : "+ passwordValueAfterDelete);
		
		Assert.assertTrue(passwordValueAfterDelete.isEmpty());
		System.out.println();
		 System.out.println("Both scenarios passed.");
		 
		 
		 //scenario 3
		 userNameField.clear();
		 userNameField.sendKeys("tomsmith");
		 userNameField.sendKeys(Keys.TAB);
		 WebElement activeElement = driver.switchTo().activeElement();

		 Assert.assertEquals(passwordField, activeElement, "Focus did not move to password field after TAB");
		 
		driver.quit();
	}

}
