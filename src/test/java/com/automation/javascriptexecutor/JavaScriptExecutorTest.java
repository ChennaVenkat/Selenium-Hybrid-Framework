package com.automation.javascriptexecutor;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutorTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/infinite_scroll");

		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		for(int i=0;i<3;i++) {
			js.executeScript("window.scrollBy(0,500)");
			Thread.sleep(1000);
		}
		driver.quit();
		
		
		
	}
}
