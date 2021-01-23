package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WorkDayStartingAndEndingTime {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser" + Keys.ENTER);

        driver.findElement(By.id("timeman-container")).click();

        driver.findElement(By.className("tm-popup-notice-pencil")).click();




        //driver.findElement(By.className("popup-window-button popup-window-button-link popup-window-button-link-cancel")).click();
        //driver.findElement(By.xpath("//input[contains(@class,'bx-tm-report-edit')]")).sendKeys("5");
        //driver.findElement(By.xpath("(//td[@rowspan = '2'])[1]")).click();
        Thread.sleep(5000);
        WebDriverWait wait = new WebDriverWait(driver, 8);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("(//input[@title='Hours'])[1]"))));
       WebElement element= driver.findElement(By.xpath("(//input[@title='Hours'])[1]"));
       element.clear();



        element.sendKeys(Keys.BACK_SPACE);


        element.sendKeys("7");

        Thread.sleep(3000);

        WebElement element2= driver.findElement(By.xpath("(//input[@title='Hours'])[2]"));

        element2.clear();

        Thread.sleep(3000);

        element2.sendKeys(Keys.BACK_SPACE);

        element2.sendKeys("11");


        Thread.sleep(3000);

        WebElement reasonBox = driver.findElement(By.xpath("//div[@class='bx-tm-popup-clock-wnd-report'][2]/textarea"));
        Thread.sleep(3000);

        reasonBox.sendKeys("Forgot to clock out");
        Thread.sleep(3000);

        WebElement saveButton = driver.findElement(By.xpath("(//div[@class='popup-window-buttons']/span)[1]"));

        Thread.sleep(3000);

        saveButton.click();
    }
}
