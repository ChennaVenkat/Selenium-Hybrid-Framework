package com.automation.locators;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterAccountTest {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://tutorialsninja.com/demo/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		//my account
		driver.findElement(By.xpath("//span[text()='My Account']")).click();
		
		// register button
		driver.findElement(By.linkText("Register")).click();
		
		//first name
		driver.findElement(By.id("input-firstname")).sendKeys("Ran");
		
		//lastname
		driver.findElement(By.id("input-lastname")).sendKeys("Vijay");
		
		//email Id
		String email = "ranvijay" + System.currentTimeMillis() + "@gmail.com";
		driver.findElement(By.id("input-email")).sendKeys(email);
		
		//Telephone number
		driver.findElement(By.xpath("//input[@placeholder='Telephone']")).sendKeys("123123123");
		
		//Password
		driver.findElement(By.id("input-password")).sendKeys("123456");
		
		//confirm password
		driver.findElement(By.name("confirm")).sendKeys("123456");
		
		//Privacy policy check box
		driver.findElement(By.xpath("//input[@name='agree']")).click();
		
		//continue button
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		Thread.sleep(5000);
		driver.quit();
		
	}

}
