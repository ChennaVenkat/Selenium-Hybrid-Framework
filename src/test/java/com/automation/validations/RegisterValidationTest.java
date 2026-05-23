package com.automation.validations;

import java.time.Duration;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class RegisterValidationTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
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
		

		
		//Validation 1
		String validation1 = driver.findElement(By.xpath("//h1[normalize-space()='Your Account Has Been Created!']")).getText();
		if(validation1.contains("Your Account Has Been Created!")) {
			System.out.println("Validation Passed");
		}else {
			System.out.println("Validation Failed");
		}
		
		//Validation 2
		boolean validation2 = driver.getCurrentUrl().contains("success");
		if(validation2) {
			System.out.println("Validation Passed: Current URL contains 'success'");
		}else {
			System.out.println("Validation Failed: Current URL doesn't contains 'success'");
		}
	
		//Validation 3
		boolean rightColumnLogoutOption = driver.findElement(By.linkText("Logout")).isDisplayed();
		if(rightColumnLogoutOption) {
			System.out.println("Logout option is present and Test got passed");
		}else {
			System.out.println("Logout option is not present and Test got failed");
		}
		
		driver.quit();
	}
}
