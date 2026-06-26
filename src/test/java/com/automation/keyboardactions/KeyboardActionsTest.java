package com.automation.keyboardactions;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class KeyboardActionsTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/login");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		WebElement userNameElement = driver.findElement(By.id("username"));
		WebElement passwordElement = driver.findElement(By.id("password"));
		
		Actions actions = new Actions(driver);
		actions.click(userNameElement).sendKeys("tomsmith").perform();
		
		//select all the text
		actions.keyDown(Keys.CONTROL)
		.sendKeys("a")
		.keyUp(Keys.CONTROL)
		.perform();
		
		//copy
		actions.keyDown(Keys.CONTROL)
		.sendKeys("c")
		.keyUp(Keys.CONTROL)
		.perform();		//actions.sendKeys(Keys.CONTROL+"c").perform();
		
		// paste text
		actions.click(passwordElement)
		.keyDown(Keys.CONTROL)
		.sendKeys("v")
		.keyUp(Keys.CONTROL)
		.perform();
		System.out.println("Password value = " +
		        passwordElement.getAttribute("value"));
		Assert.assertEquals(passwordElement.getAttribute("value"), "tomsmith");
		
		
		driver.quit();
	}

}
