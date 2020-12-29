package com.Utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.List;

public class AutomationTest {

    public static WebDriver getDriver(String browserType) {
        if (browserType.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            return new ChromeDriver();
        } else if (browserType.equalsIgnoreCase("safari")) {
            return new SafariDriver();
        } else if (browserType.equalsIgnoreCase("fire fox")) {
            WebDriverManager.firefoxdriver().setup();
            return new FirefoxDriver();
        } else if (browserType.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            return new EdgeDriver();
        } else if (browserType.equalsIgnoreCase("internet explorer")) {
            WebDriverManager.iedriver().setup();
            return new InternetExplorerDriver();
        }
        return null;
    }

    public static void testResultEquals(String expectedResult, String actualResult) {
        if (actualResult.equals(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
            System.out.println("Test Failed!");
        }
    }

    public static void testResultEquals(List<String> expectedResult, List<String> actualResult) {
        if (actualResult.equals(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
            System.out.println("Test Failed!");
        }
    }

    public static void testResultContains(String expectedResult, String actualResult) {
        if (actualResult.contains(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
            System.out.println("Test Failed!");
        }
    }
    public static void testResultContains(List<String> expectedResult, List<String> actualResult) {
        if (actualResult.contains(expectedResult)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("expectedResult = " + expectedResult);
            System.out.println("actualResult = " + actualResult);
            System.out.println("Test Failed!");
        }
    }
}
