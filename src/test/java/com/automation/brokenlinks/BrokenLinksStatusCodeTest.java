package com.automation.brokenlinks;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinksStatusCodeTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver(); 
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		
		  // Capture all anchor (<a>) tag elements from the page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		// Print total number of links found on the page
		System.out.println(links.size());
		
		// Counters for tracking link status
		int valid = 0;
		int broken = 0;
		int serverError = 0;
		
		// Iterate through each link
		for (WebElement link:links) {
			
			// get the href attribute value
			String href = link.getAttribute("href");
			
			// Skip links that are null, empty or JavaScript links
			if(href == null || href.isEmpty() || href.contains("javascript:void(0)")) {
				continue;
			}
			
			// create URL object from href
			URL url=new URL(href);
			
			// open HTTP connection
			HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
			
			// Use HEAD request to fetch only response headers
            // (faster than GET request)
			httpURLConnection.setRequestMethod("HEAD");
			
			// Establish connection
			httpURLConnection.connect();
			
		    // Get HTTP response status code
			int statusCode = httpURLConnection.getResponseCode();
			
			// Check if link is valid
			if(statusCode == 200) {
				System.out.println(href+" --> "+statusCode+" --> Valid");
				valid++;
			}
			
			// Check if link is broken (4xx client errors)
			else if(statusCode >=400 || statusCode <= 500 ){
				System.out.println(href+ " --> "+statusCode+" --> broken");
				broken++;
			}
			
			// Check if server-side error (5xx)
			else if(statusCode > 500) {
				System.out.println(href+" --> "+statusCode+" --> server error");
				serverError++;
			}
			
			 // Close HTTP connection
			httpURLConnection.disconnect();
			
			  // Print final execution summary
			System.out.println("Final Summary");
			System.out.println("Total number of valid links are : "+valid);
			System.out.println("Total number of broken links are : "+broken);
			System.out.println("Total number of server error links are : "+serverError);
			
			
		}
		 
		driver.quit();
	}

}
