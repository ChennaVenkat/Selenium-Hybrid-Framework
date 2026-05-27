package com.automation.frames;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class IFrameHandlingTest {

	public static void main(String[] args) {
	
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/iframe");
		
		// Switch into iframe
		driver.switchTo().frame("mce_0_ifr");

		// Locate editor
		WebElement iFrameEditor = driver.findElement(By.id("tinymce"));

		// Clear existing text
		iFrameEditor.sendKeys(Keys.CONTROL + "a");
		iFrameEditor.sendKeys(Keys.DELETE);

		// Enter new text
		iFrameEditor.sendKeys("Learning Selenium Frames");

		// Switch back to main page
		driver.switchTo().defaultContent();

		// Validate heading
		String actualHeading = driver.findElement(By.tagName("h3")).getText();

		String expectedHeading = "An iFrame containing the TinyMCE WYSIWYG Editor";

		if(actualHeading.equals(expectedHeading)) {
			System.out.println("Heading validation passed");
		}
		else {
			System.out.println("Heading validation failed");
		}

		driver.quit();
	}
}