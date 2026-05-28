package com.automation.filehandling;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUploadTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		WebElement fileUploadElement = driver.findElement(By.id("file-upload"));
		fileUploadElement.sendKeys("C:\\Users\\schen\\OneDrive\\Pictures\\Screenshots\\eclipse.png");
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		uploadButton.click();
		
		String fileUploadedText = driver.findElement(By.xpath("//div[@id='content']//h3")).getText();
		if(fileUploadedText.equals("File Uploaded!")) {
			System.out.println("Validation Passed : File uploaded successfully");
		} else {
			System.out.println("Validation Failed : File not uploaded");
		}
		driver.quit();
	}
}