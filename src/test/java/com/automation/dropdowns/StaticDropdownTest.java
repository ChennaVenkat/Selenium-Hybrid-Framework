package com.automation.dropdowns;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class StaticDropdownTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Launch Browser
		WebDriver driver = new ChromeDriver();
		
		//Maximize browser
		driver.manage().window().maximize();
		
		// open website
		driver.get("https://demoqa.com/select-menu");
		
		// *******  FLOW 1 — SELECT DROPDOWN  *******
		// Locate Old Style Select Menu dropdown
		WebElement colorDropdown = driver.findElement(By.id("oldSelectMenu"));
		
		
		// Create Select class object
		Select colorDropdownSelect = new Select(colorDropdown);		
		// print all the options in dropdown
		List<WebElement> allColorOptions = colorDropdownSelect.getOptions();
		for(WebElement  color :  allColorOptions) {
			System.out.println(color.getText());
		}
		
		// select purple 
		colorDropdownSelect.selectByVisibleText("Purple");		
		String selectedColor = colorDropdownSelect.getFirstSelectedOption().getText();
		if(selectedColor.equals("Purple")) {
			System.out.println("Purple selected successfully");
		} else {
			System.out.println("Purple selection failed");
		}
		
		/*
		for(WebElement color: colors) {
			if(color.getText().equals("Purple")){
				color.click();
			}
		}
		*/
		System.out.println();
		
		
		// *******  FLOW 2 — MULTI SELECT DROPDOWN  *******
		// Locate Standard Multi Select dropdown
		WebElement standardMultiSelectDropDown = driver.findElement(By.id("cars"));
		
		// Create Select class object
		Select standarMultiSelectDropDownSelect = new Select(standardMultiSelectDropDown);
		
		// Select Volv, but try to use always visibleText or value because index may changes
		standarMultiSelectDropDownSelect.selectByIndex(0);
		
		// Select Opel
		standarMultiSelectDropDownSelect.selectByValue("opel");
		
		// Get all selected options
		List<WebElement> allCarOptions = standarMultiSelectDropDownSelect.getAllSelectedOptions();
		
		// printing the selectec cars
		for(WebElement car : allCarOptions) {
			System.out.println(car.getText());
		}
		
		driver.quit();
	}
}
