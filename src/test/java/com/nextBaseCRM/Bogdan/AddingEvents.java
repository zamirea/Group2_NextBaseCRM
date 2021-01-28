package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class AddingEvents {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser" + Keys.ENTER);

        driver.findElement(By.id("timeman-container")).click();

        driver.findElement(By.xpath("//input[contains(@class,'tm-popup-event-form')]")).sendKeys("Meeting XX");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[contains(@class,'tm-popup-event')]")).click();

        String expectedNameOfEvent = "Meeting XX";
        String actualNameOfEvent = driver.findElement(By.xpath("//span[contains(@class,'tm-popup-event-text')]")).getText();


        if (expectedNameOfEvent.equalsIgnoreCase(actualNameOfEvent)) {
            System.out.println("User can create Events");
        } else {
            System.out.println("User cant create Events");
        }

        System.out.println(actualNameOfEvent);

        driver.close();

       // driver.findElement(By.className("tm-popup-event-start-time-textbox_am_pm")).click();


        //driver.findElement(By.xpath("//input[contains(@title, 'Hours')]")).sendKeys("10");

        //driver.findElement(By.xpath("//input[contains(@class,'tm-popup-event-form')]")).sendKeys("Meeting XX");


        // driver.findElement(By.className("bxc-cus-sel-tbl")).click();

//        ArrayList<WebElement> timeBList = new ArrayList<WebElement>(driver.findElements(By.xpath("//td[@rowspan='2']")));
//        timeBList.get(0).click();
        //driver.findElement(By.xpath("//input[contains(@title, 'Hours')]")).click();
        //choose start time

        //driver.findElement(By.xpath("//span[@id='Select']")).click();
        //click select button

    }
}
