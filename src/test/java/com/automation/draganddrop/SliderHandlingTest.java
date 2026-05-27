package com.automation.draganddrop;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderHandlingTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//  Launch Chrome browser
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/slider/");
		
//		Locate iframe containing slider
		WebElement sliderFrameElement = driver.findElement(By.tagName("iframe"));
		
//		Switch driver focus to iframe
		driver.switchTo().frame(sliderFrameElement);
		
//		Locate slider handle element
		WebElement sliderHandleElement = driver.findElement(By.xpath("//div[@id='slider']//span"));
		
		
//		Create Actions class object for mouse interactions
		Actions actions = new Actions(driver);
		
//		Capture initial slider position
		Point initialSliderLocation = sliderHandleElement.getLocation();
		System.out.println(initialSliderLocation);
		
		// Capture initial slider style (attribute validation)
		String initialStyle = sliderHandleElement.getAttribute("style");
		System.out.println("Before move (style) "+initialStyle);
		
//		Move slider horizontally by 200 pixels
		actions.dragAndDropBy(sliderHandleElement, 200, 0).perform();
		
//		Capture final slider position
		Point finalSliderLocation = sliderHandleElement.getLocation();
		System.out.println(finalSliderLocation);
		
		// Capture final slider style
		String finalStyle = sliderHandleElement.getAttribute("style");
		System.out.println("After move (style) "+finalStyle);
		
		driver.switchTo().defaultContent();
		
		/*
//		Validation: check if slider moved
		if(!initialSliderLocation.equals(finalSliderLocation )) {
			System.out.println("Validation Passed: Slider moved successfully");
		}else {
			System.out.println("Validation Failed: Slider did not move");
		}
		*/
		
		if(initialStyle.equals(finalStyle)) {
			System.out.println("FAIL: Slider did not move (style unchanged)");
		} else {
			System.out.println("PASS: Slider moved successfully (style changed)");
		}
		
		
		driver.quit();
	}
}
