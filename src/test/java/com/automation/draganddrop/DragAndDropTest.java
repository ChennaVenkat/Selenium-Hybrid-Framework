package com.automation.draganddrop;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://jqueryui.com/droppable/");
		
		//WebElement iFrameElement = driver.findElement(By.xpath("//div[@id='content']//iframe"));
		WebElement dragDropFrame = driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(dragDropFrame);
		
		WebElement sourceElement = driver.findElement(By.id("draggable"));
		WebElement targetElement = driver.findElement(By.id("droppable"));
		
		Actions actions = new Actions(driver);
		actions.dragAndDrop(sourceElement, targetElement).perform();
		
		// Get updated text AFTER drop
		String actualDropMessage = targetElement.getText();

		String expectedDropMessage = "Dropped!";

		if (actualDropMessage.equals(expectedDropMessage)) {

		    System.out.println("Validation Passed - Drag and Drop successful");

		} else {

		    System.out.println("Validation Failed - Drag and Drop failed");
		}
		
		driver.switchTo().defaultContent();
		driver.quit();
	}
}
