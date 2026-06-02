package com.automation.cookies;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CookiesHandlingTest {

    public static void main(String[] args) {

        // Flow 1 - Launch Browser & Open Website
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://tutorialsninja.com/demo/");

        // Flow 2 - Print All Cookies

        System.out.println("===== EXISTING COOKIES =====");

        Set<Cookie> allCookies = driver.manage().getCookies();

        for (Cookie cookie : allCookies) {

            System.out.println("Cookie Name  : " + cookie.getName());
            System.out.println("Cookie Value : " + cookie.getValue());
            System.out.println("--------------------------------");
        }

        // Flow 3 - Print Total Cookie Count

        System.out.println("Total Cookies : " + allCookies.size());

        // Flow 4 - Add Custom Cookie

        Cookie testCookie = new Cookie("Framework", "Hybrid");

        driver.manage().addCookie(testCookie);

        System.out.println("\nCustom Cookie Added");

        // Flow 5 - Validate Cookie Exists

        Cookie addedCookie =
                driver.manage().getCookieNamed("Framework");

        if (addedCookie != null) {

            System.out.println("PASS - Cookie Added Successfully");
            System.out.println("Cookie Name  : " + addedCookie.getName());
            System.out.println("Cookie Value : " + addedCookie.getValue());

        } else {

            System.out.println("FAIL - Cookie Not Added");
        }

        // Flow 6 - Delete Cookie

        driver.manage().deleteCookieNamed("Framework");

        System.out.println("\nCookie Deleted");

        // Flow 7 - Validate Cookie Deleted

        Cookie deletedCookie =
                driver.manage().getCookieNamed("Framework");

        if (deletedCookie == null) {

            System.out.println("PASS - Cookie Deleted Successfully");

        } else {

            System.out.println("FAIL - Cookie Still Exists");
        }

        driver.quit();
    }
}