package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BreakFunctionality {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser" + Keys.ENTER);


        String actualTxt = driver.findElement(By.xpath("(//span[contains(@id,'timeman-status')])[2]")).getText();
        driver.findElement(By.id("timeman-container")).click();
        Thread.sleep(2000);

        if (actualTxt.equalsIgnoreCase("CLOCKED OUT")) {
            driver.findElement(By.xpath("//div[@class = 'tm-popup-button-handler']")).click();
            Thread.sleep(3000);
            driver.findElement(By.xpath("//td[contains(@class,'tm-popup-timeman-layout')][1]")).click();
        } else if (actualTxt.equalsIgnoreCase("WORKING")) {
            driver.findElement(By.xpath("//td[contains(@class,'tm-popup-timeman-layout')][1]")).click();
        } else {
            System.out.println("You are already on the break");
        }

        Thread.sleep(3000);


        String actualTxt2 = driver.findElement(By.xpath("(//span[contains(@id,'timeman-status')])[2]")).getText();
        String expectedTxt = "ON BREAK";
        System.out.println(actualTxt2);
        if (actualTxt2.equalsIgnoreCase(expectedTxt)) {
            System.out.println("Functionality Verified!");
        } else {
            System.out.println("Not Verified!");
        }
        driver.close();
    }
}
