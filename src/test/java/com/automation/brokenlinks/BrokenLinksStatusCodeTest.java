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
		
		List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		// prints total number of links
		System.out.println(links.size());
		
		int valid = 0;
		int broken = 0;
		int serverError = 0;
		
		for (WebElement link:links) {
			String href = link.getAttribute("href");
			if(href == null || href.isEmpty() || href.contains("javascript:void(0)")) {
				continue;
			}
			
			URL url=new URL(href);
		}
		 
		driver.quit();
		/*
		List<WebElement> links = driver.findElements(By.tagName("a"));
	
		System.out.println("Total number of links are : "+ 	links.size());
		
		int valid = 0;
		int broken = 0;
		int serverError = 0;
		
		
		for(WebElement link:links) {
			String hrefValue = link.getAttribute("href");
			
			
			if(hrefValue == null || hrefValue.isEmpty() || hrefValue.contains("javascript:void(0)")) {
				continue;
			}
			
				URL url = new URL(hrefValue);
				
				HttpURLConnection conn = (HttpURLConnection) url.openConnection();
				
				conn.setRequestMethod("GET");
				
				conn.connect();
				
				int code = conn.getResponseCode();
				
				if(code == 200) {
					System.out.println(hrefValue +" -> "+ code +" ->valid");
					valid++;
				} else if(code >= 400 && code <=500) {
					System.out.println(hrefValue + " -> "+code+" -> broken");
					broken++;
				} else if (code >= 500) {
					System.out.println(hrefValue + " -> "+code+" -> server error");
					serverError++;
				}
		}
		
		System.out.println("Final Summary");
		System.out.println("Valid links : "+valid);
		System.out.println("broken links : "+ broken);
		System.out.println("server errors : "+serverError);
		
		driver.quit();
		
//		HttpURLConnection httpURLConnection = new HttpURLConnection(links);
/// */
	}

}
