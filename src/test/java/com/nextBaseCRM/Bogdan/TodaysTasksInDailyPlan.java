package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class TodaysTasksInDailyPlan {
    public static void main(String[] args) {
        //user can create, cancel, remove today's tasks from daily plan
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("login2.nextbasecrm.com");


    }
}
