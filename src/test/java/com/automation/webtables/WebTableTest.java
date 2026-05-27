package com.automation.webtables;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebTableTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/challenging_dom");
		
		// =========================================
				// FLOW 1 — PRINT TABLE DATA
		// =========================================

		List<WebElement> tableHeaders = driver.findElements(By.xpath("//table//thead//th"));
		System.out.println("==== Table headers ==== ");
		
		// Print all table headers
		for(WebElement header:tableHeaders) {
			System.out.println(header.getText());
		}
		System.out.println("Total number of Header: "+tableHeaders.size());
		System.out.println();

		// Locate first row data
		List<WebElement> firstRowData = driver.findElements(By.xpath("//table//tbody//tr[1]//td"));

		// Print first row data
		System.out.println("=== First row DATA ===");
		for(WebElement data :firstRowData) {
			System.out.println(data.getText());
		}
		
		System.out.println("Total number of data cells in first row : "+firstRowData.size());
		
		System.out.println();

		// =========================================
				// FLOW 2 — ROW COUNT & COLUMN COUNT
		// =========================================
		
		// Locate all rows
		List<WebElement> totalRows = driver.findElements(By.xpath("//table//tbody//tr"));
		System.out.println("Total number of rows are : "+totalRows.size());
		
		// Locate all columns
		List<WebElement> totalColumns = driver.findElements(By.xpath("//table//thead//th"));
		System.out.println("Total number of columns are : "+totalColumns.size());
		
		System.out.println();
		
		// =========================================
				// FLOW 3 — VALIDATION
		// =========================================
		 WebElement firstRowFirstColumnElement  = driver.findElement(By.xpath("//tbody//tr[1]//td[1]"));
		 String actualText = firstRowFirstColumnElement .getText();

		 if(actualText.equals("Iuvaret0")) {
		 	System.out.println("PASS: 'Iuvaret0' is present in table");
		 } else {
		 	System.out.println("FAIL: 'Iuvaret0' is not present in table");
		 }
		driver.quit();
	}
}
