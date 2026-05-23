package com.automation.xpath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AdvancedXPathTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		// search input field
		WebElement searchBox = driver.findElement(By.xpath("//input[contains(@name,'search')]"));
		searchBox.sendKeys("Macbook");
		
		// clicking search button
		driver.findElement(By.xpath("//div[@id='search']//button")).click();
		
		// click on MacBook
		driver.findElement(By.xpath("//div[@class='caption']//a[normalize-space()='MacBook']")).click();
		
		String actualProductHeading = driver.findElement(By.xpath("//div[@class='btn-group']/following-sibling::h1[normalize-space()='MacBook']")).getText();
		if(actualProductHeading.equals("MacBook")) {
			System.out.println("Validation Passed: MacBook heading displayed correctly");
		} else {
			System.out.println("Validation Failed: MacBook heading not displayed");
		}
		
		driver.quit();
	}
}
