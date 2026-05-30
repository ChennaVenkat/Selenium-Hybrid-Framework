package com.automation.screenshots;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenshotTest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;

		// capture screenshot using TakesScreenshot
		File sourceFile = screenshot.getScreenshotAs(OutputType.FILE);
		
		// creating screenshots folder if not exists
		File screenshotsDir  = new File("./screenshots");
		if(!screenshotsDir .exists()) {
			screenshotsDir .mkdir();
		}
		
		// Destination file path
		File destinationFile = new File("./screenshots/homepage2.png");
		
		// Copy screenshot to destination
		FileUtils.copyFile(sourceFile, destinationFile);
		
		System.out.println("Screenshot successfully capture");
		
		driver.quit();
	}
}