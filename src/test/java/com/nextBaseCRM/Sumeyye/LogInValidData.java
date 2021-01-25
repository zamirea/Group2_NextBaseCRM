package com.nextBaseCRM.Sumeyye;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LogInValidData {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(2000);

        driver.findElement(By.xpath("//span[.='Log out']")).click();

        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk4@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(2000);




        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(2000);



        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing4@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(2000);



        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(2000);




        driver.findElement(By.name("USER_LOGIN")).sendKeys("hr4@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        Thread.sleep(2000);









    }

}
