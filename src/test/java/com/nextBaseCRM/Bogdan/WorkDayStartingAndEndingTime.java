package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WorkDayStartingAndEndingTime {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser" + Keys.ENTER);

        driver.findElement(By.id("timeman-container")).click();

        driver.findElement(By.className("tm-popup-notice-pencil")).click();



        //driver.findElement(By.xpath("(//div[contains(@class, 'bx-tm-popup-clock-wnd-report')])[2]")).sendKeys("Clock out");
        //driver.findElement(By.xpath("(//td[@rowspan = '2'])[1]")).click();
        //driver.findElement(By.className("bxc-cus-sel-tbl")).click();
        //driver.findElement(By.xpath("(//input[contains(@class,'bxc-cus')])[1]")).sendKeys("9");
        //driver.findElement(By.xpath("(//td[contains(@class, 'bxc-pointer')])[1]")).click();

    }
}
