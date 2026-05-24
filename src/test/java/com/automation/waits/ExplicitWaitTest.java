package com.automation.waits;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1?utm_source=chatgpt.com");
		WebElement startButtonElement = driver.findElement(By.xpath("//div[@id='start']//button"));
		startButtonElement.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		WebElement helloWorldElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='finish']//*[text()='Hello World!']")));
		String helloWorldMessage = helloWorldElement.getText();
		String expectedMessage= "Hello World!";
		if(helloWorldMessage.equals(expectedMessage)) {
			System.out.println("Validation got passed");
		}else {
			System.out.println("Validation got failed");
		}
		driver.quit();
	}
}
