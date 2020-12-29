package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ClockInOut {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);


        driver.findElement(By.id("timeman-container")).click();
        Thread.sleep(2000);
        String actualText = driver.findElement(By.id("timeman-status")).getText();

        if (actualText.equalsIgnoreCase("CLOCKED OUT")) {
            driver.findElement(By.className("tm-popup-button-handler")).click();
            Thread.sleep(2000);
        }


        String expectedTextWhenClockedIn = "Working";
        actualText = driver.findElement(By.id("timeman-status")).getText();

        if (expectedTextWhenClockedIn.equalsIgnoreCase(actualText)) {
            System.out.println("Clock in verified");
        } else {
            System.out.println("Clock in not verified, you are already clocked in");
        }
        System.out.println(actualText);


        Thread.sleep(2000);

        driver.findElement(By.className("tm-popup-button-handler")).click();

        //driver.close();


    }
}
