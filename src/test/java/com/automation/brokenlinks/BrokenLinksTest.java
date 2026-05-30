package com.automation.brokenlinks;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		
		int emptyLinks = 0;
		int invalidLinks = 0;
		int validLinks = 0;
		
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		//allLinks.size();
		System.out.println("The total number of links are : "+allLinks.size());
		
		System.out.println();
		
		for(WebElement link:allLinks) {
			
			String hrefValue = link.getAttribute("href");
			
			if(hrefValue == null || hrefValue.isEmpty()) {
				System.out.println("Empty href found ");
				emptyLinks++;
			}else if(hrefValue.contains("javascript:void(0)")){
				System.out.println("Invalid href found : "+hrefValue);
				invalidLinks++;
			}else {
				System.out.println("Valid links are : "+hrefValue);
				validLinks++;
			}
		}
		
		System.out.println("The total number of Empty Links are : "+emptyLinks);
		System.out.println("The total number of invalid Links are : "+invalidLinks);
		System.out.println("The total number of valid links are : "+ validLinks);
		driver.quit();
	}
}
