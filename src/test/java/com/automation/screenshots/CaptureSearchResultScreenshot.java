package com.automation.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureSearchResultScreenshot {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		WebElement searchBox = driver.findElement(By.name("search"));
		
		searchBox.sendKeys("iPhone");
		
		WebElement searchButton = driver.findElement(By.xpath("//button[@class='btn btn-default btn-lg']"));
		
		searchButton.click();
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		//searchResult
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		File destinationFile = new File("./screenshots/searchResult.png");
		
		FileUtils.copyFile(sourceFile, destinationFile);
		
		driver.quit();
	}

}
