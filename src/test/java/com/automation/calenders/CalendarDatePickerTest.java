package com.automation.calenders;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalendarDatePickerTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/datepicker/");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	
		WebElement iFrameElement = driver.findElement(By.xpath("//iframe[@class='demo-frame']"));
		driver.switchTo().frame(iFrameElement);
		WebElement calenderElement = driver.findElement(By.id("datepicker"));
		wait.until(ExpectedConditions.visibilityOf(calenderElement));
		
		calenderElement.click();
		WebElement PrevButton = driver.findElement(By.xpath("//span[text()='Prev']"));

		WebElement nextButton = driver.findElement(By.xpath("//span[text()='Next']"));
		
	
		String requiredMonth = "December";
		String requiredYear = "2026";
		String requiredDate = "15";
		
		
		while(true) {
			String currentMonth = driver.findElement(By.xpath("//span[@class='ui-datepicker-month']")).getText();
			
			String currentYear = driver.findElement(By.xpath("//span[@class='ui-datepicker-year']")).getText();
		   

		    if(currentMonth.equals(requiredMonth)
		            && currentYear.equals(requiredYear)) {

		        break;
		    }

		    driver.findElement(
		            By.xpath("//span[text()='Next']"))
		            .click();
		}
		
		List<WebElement> dates =
				driver.findElements(
				By.xpath("//table[@class='ui-datepicker-calendar']//td"));
		
		for(WebElement date:dates) {
			System.out.println(date.getText());
		}
		for(WebElement date:dates) {
			if(date.getText().equals(requiredDate)) {
				date.click();
				break;
			}
		}
		driver.quit();
		
	}

}
