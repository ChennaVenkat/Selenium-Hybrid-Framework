package com.automation.javascriptexecutor;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class JavaScriptExecutorDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://automationexercise.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
		
		JavascriptExecutor js= (JavascriptExecutor) driver;
		
		// Flow 1 — Scroll Down
		// opens the website and scroll to the bottom using JavaScript
		//js.executeScript("window.scrollBy(0,document.body.scrollHeight)");
		
		// flow 3 - Scroll element into view
		
		// Locate the Subscription section at the bottom and scroll that element into view.
		WebElement subscriptionElement = driver.findElement(By.xpath("//footer[@id='footer']//h2"));
		
		js.executeScript("arguments[0].scrollIntoView(true);", subscriptionElement);
	
		WebElement emailInput = driver.findElement(By.id("susbscribe_email"));
	
		js.executeScript("arguments[0].click()", emailInput);
		
		
		js.executeScript("arguments[0].value='seleniumj@gmail.com';", emailInput);
		
		js.executeScript("arguments[0].style.border='3px solid red'", emailInput);
		
		js.executeScript("history.go(0)");
		
		js.executeAsyncScript("history.go(0)");
		
		js.executeScript("location.reload()");
		
		String actualEmail = emailInput.getAttribute("value");
		
		Assert.assertEquals(actualEmail, "susbscribe_email");
		
		
		
		
	}

}
