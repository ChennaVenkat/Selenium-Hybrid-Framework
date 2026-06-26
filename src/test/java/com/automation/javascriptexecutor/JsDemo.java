package com.automation.javascriptexecutor;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class JsDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://example.com");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		
		js.executeAsyncScript("alert('hii')");
	}
}

/*
Basic JavaScriptExecutor
JavaScriptExecutorTest
JavaScriptExecutorDemo
JavaScriptExecutorExamples
JsExecutorBasics
JavaScriptExecutorPractice
Click Operations
JsClickDemo
JavaScriptClickTest
JsExecutorClickExample
ClickUsingJavaScript
JavaScriptButtonClick
Scrolling
JsScrollDemo
ScrollUsingJavaScript
JavaScriptScrollTest
JsScrollIntoViewExample
PageScrollUsingJs
Highlighting Elements
JsHighlightElementDemo
HighlightElementUsingJs
JavaScriptHighlightTest
ElementHighlighter
Entering Text
JsSendKeysDemo
SetValueUsingJavaScript
JavaScriptInputDemo
EnterTextUsingJs
Reading Values
JsGetTitleDemo
JsGetInnerTextDemo
JavaScriptReturnValueTest
ReadElementTextUsingJs
Handling Hidden Elements
HiddenElementUsingJs
JavaScriptHiddenElementDemo
JsHiddenFieldTest
Browser Actions
JsRefreshPageDemo
JsNavigateDemo
BrowserActionsUsingJs
JavaScriptBrowserCommands
Alerts
JsAlertDemo
JavaScriptAlertTest
GenerateAlertUsingJs
Combined Practice Scenarios
JavaScriptExecutorScenarios
JavaScriptExecutorExercises
JavaScriptExecutorTasks
JsExecutorPracticeSuite
JsExecutorExamples
Professional Naming Convention

If you're creating a Selenium framework and want clean naming:

JavaScriptClickTest
JavaScriptScrollTest
JavaScriptAlertTest
JavaScriptInputTest
JavaScriptHighlightTest
JavaScriptNavigationTest
JavaScriptExecutorScenariosTest

A common structure many automation engineers use is:

JavaScriptExecutorBasicsTest
JavaScriptClickTest
JavaScriptScrollTest
JavaScriptInputTest
JavaScriptAlertTest
JavaScriptExecutorAdvancedTest
*/