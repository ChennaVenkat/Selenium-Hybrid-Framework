package com.automation.robotclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class RobotClassFileUploadTest {

	public static void main(String[] args) throws AWTException, InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://the-internet.herokuapp.com/upload");
		
		WebElement chooseFileButton = driver.findElement(By.id("file-upload"));
		WebElement uploadButton = driver.findElement(By.id("file-submit"));
		
		uploadButton.click();
		
		String filePath = "C:\\Users\\schen\\OneDrive\\Pictures\\Screenshots\\robot.png";
		//chooseFileButton.sendKeys("");
		
		StringSelection selection = new StringSelection(filePath);
		
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		
		Robot robot = new Robot();
		
        Thread.sleep(2000);

        // CTRL + V

        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);

        Thread.sleep(1000);

        // ENTER

        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(2000);

        // Click Upload button
        driver.findElement(By.id("file-submit")).click();

        // Validation

        String expectedText = "File Uploaded!";

        String actualText =
                driver.findElement(By.tagName("h3")).getText();

        if(actualText.equals(expectedText)) {

            System.out.println("PASS");
            System.out.println("File uploaded successfully");

        } else {

            System.out.println("FAIL");
            System.out.println("Expected : " + expectedText);
            System.out.println("Actual   : " + actualText);
        }

        driver.quit();
	}
}