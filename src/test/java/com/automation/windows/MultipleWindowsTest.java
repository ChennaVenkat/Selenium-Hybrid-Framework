package com.automation.windows;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class MultipleWindowsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch Browser
		WebDriver driver = new ChromeDriver();
		
		// maximize the window
		driver.manage().window().maximize();
		
		// open website
		driver.get("https://the-internet.herokuapp.com/windows");
		
		// capture parent window ID
		String parentWindow = driver.getWindowHandle();
		String childWindow = "";
		
		// click on  Click here link
		WebElement clickHereLink = driver.findElement(By.linkText("Click Here"));
		clickHereLink.click();
		
		Set<String> windows = driver.getWindowHandles();
		
		
		// swtching to handle to new tab
		for(String window:windows) {
			if(!window.equals(parentWindow)) {
				driver.switchTo().window(window);
				break;
			}
		}
		childWindow=driver.getWindowHandle();
		
		String childWindowHeading = driver.findElement(By.tagName("h3")).getText();
		String expectedChildWindowHeading = "New Window";
		
		if(childWindowHeading.equals(expectedChildWindowHeading)) {
			System.out.println("Child Window Heading validation Passed");
		} else {
			System.out.println("Child Window Heading validation failed");
		}
		
		// close child window
		driver.close();
		
		// Switch back to parent window
		driver.switchTo().window(parentWindow);
		
		// Validate parent window heading
		String parentWindowHeading = driver.findElement(By.xpath("//div[@id='content']//h3")).getText();
		String expectedParentWindowHeading = "Opening a new window";
		
		if(parentWindowHeading.equals(expectedParentWindowHeading)) {
			System.out.println("Parent Window Heading validation Passed");
		} else {
			System.out.println("Parent Window Heading validation failed");
		}
		
		// Close browser

		driver.quit();
	}

}
