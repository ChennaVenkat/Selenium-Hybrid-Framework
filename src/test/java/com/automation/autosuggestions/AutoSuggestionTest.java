package com.automation.autosuggestions;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AutoSuggestionTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.wikipedia.org/");
		
		WebElement searchBoxElement = driver.findElement(By.id("searchInput"));
		
		searchBoxElement.sendKeys("Selenium");
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@class='suggestions-dropdown']//a//div//h3")));
		List<WebElement> searchSuggestions = driver.findElements(By.xpath("//div[@class='suggestions-dropdown']//a//div//h3"));
		
		for(WebElement suggestion:searchSuggestions) {
			 String suggestionText = suggestion.getText();

	         System.out.println(suggestionText);

	         if (suggestionText.equals("Selenium (software)")) {
	             suggestion.click();
	                break;
	         }
		}
		  // Step 9 - Validation

        String expectedPageHeading = "Selenium (software)";

        wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.id("firstHeading")));

        String actualPageHeading = driver.findElement(
                By.id("firstHeading")).getText();

        if (actualPageHeading.equals(expectedPageHeading)) {
            System.out.println("PASS - Heading matched");
        } else {
            System.out.println("FAIL - Heading not matched");
            System.out.println("Expected: " + expectedPageHeading);
            System.out.println("Actual: " + actualPageHeading);
        }

        driver.quit();
	}
}
