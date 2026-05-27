package com.automation.webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTable {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
		// Print all Table headers
		List<WebElement> allHeaders = driver.findElements(By.xpath("//table//thead//th"));
		
		System.out.println(" === Table headers === ");
		for(WebElement header:allHeaders) {
			System.out.println(header.getText());
		}
		System.out.println();
		
//		Print last row data
		System.out.println(" === last row data === ");
		 List<WebElement> lastRowElements = driver.findElements(By.xpath("//table//tbody//tr[last()]//td"));
		for(WebElement element:lastRowElements) {
			System.out.println(element.getText());
		}
		System.out.println();

		// Print middle row data (any one row except first and last)
		System.out.println(" === Printing middle row data ===");
		List<WebElement> middleRowElement = driver.findElements(By.xpath("//table//tbody//tr[5]//td"));
		 for( WebElement element: middleRowElement) {
			System.out.println(element.getText());
		 }
		 System.out.println();
		 
		 // total number of rows in a table
		 List<WebElement> totalRows = driver.findElements(By.xpath("//table//tbody//tr"));
		 System.out.println("Total number of rows in a table are : "+ totalRows.size());
		 
		 // total number of columns in a table
		 List<WebElement> totalColumns = driver.findElements(By.xpath("//table//thead//th"));
		 System.out.println("Total number of columns in a table are : "+ totalColumns.size());
		 
		 // total cells in table
		 List<WebElement> totalCells = driver.findElements(By.xpath("//table//tbody//tr//td"));
		 System.out.println("Total number of cells in a table are : "+ totalCells.size());
		 
		 WebElement firstRowFourthColumnElement = driver.findElement(By.xpath("//table//tbody//tr[1]//td[4]"));
		 String actualText = firstRowFourthColumnElement.getText();
		 
		 if(actualText.equals("Definiebas0")) {
			 System.out.println("PASS: 'Definiebas0' is present in table");
		 } else {
			 System.out.println("FAIL: 'Definiebas0' is not present in table");
		 }
		 
		 
		 //flow 4
		for(int i=1;i<=totalRows.size();i++) {
			List<WebElement> columnsInRow = driver.findElements(By.xpath("//table//tbody//tr["+i+"]//td"));
			for(int j=0;j<columnsInRow.size();j++) {
				System.out.print(columnsInRow.get(j).getText() +" | ");
				//System.out.print(driver.findElement(By.xpath("//table//tbody//tr["+i+"]//td["+j+"]")).getText()+ " | ");
			}
			System.out.println();
		}
		 
		 driver.quit();
	}

}
