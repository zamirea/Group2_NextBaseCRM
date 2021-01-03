package com.nextBaseCRM.Zamire.UserStory63;

import com.Utility.AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class T83_UsersCheckTimers extends AutomationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com/");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing3@cybertekschool.com");
        driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
        driver.findElement(By.cssSelector("input.login-btn")).click();

        Thread.sleep(2000);
// find event tab and click
        driver.findElement(By.xpath("//*[@id=\"feed-add-post-form-tab-calendar\"]/span")).click();
        Thread.sleep(2000);
        //find eventName and send keys
        driver.findElement(By.cssSelector("input[placeholder='Event name']")).sendKeys("Team Lunch");
// find set reminder and check
    //    driver.findElement(By.linkText("Set reminder")).click();

        WebElement timerBox = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[2]/div/div[1]/div/div/div[3]/div/div/form/div[2]/div[4]/div/div[3]/div[3]/span/input"));
        timerBox.click();
        timerBox.clear();
        timerBox.sendKeys("24");

        driver.findElement(By.xpath("//*[@id=\"event-remind_typecal_3Jcl\"]/option[2]")).click();


        driver.findElement(By.cssSelector("button#blog-submit-button-save")).click();

       driver.get("https://login2.nextbasecrm.com/company/personal/user/594/calendar/?EVENT_ID=9366&EVENT_DATE=12/30/2020");
        //driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[1]/div[3]/div[2]/a[1]/span[2]/span")).click();

        String expectedResult = "24 hour(s) before";

       String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div/div/div/div[2]/div[1]/div[2]/div[2]/div[2]/span")).getText();

       testResultContains(expectedResult,actualResult);

      driver.close();

    }
}
