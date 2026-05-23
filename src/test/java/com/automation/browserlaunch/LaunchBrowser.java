package com.automation.browserlaunch;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().window().maximize();
		
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		
		Thread.sleep(000);
		driver.close();// closes the single browser window
		//driver.quit();// closes all the browser windows
	}

}