package com.nextBaseCRM.Zamire.UserStory63;

import com.Utility.AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class TC81_UserSendEventWithEventName extends AutomationTest {
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
        driver.findElement(By.cssSelector("input[placeholder='Event name']")).sendKeys("parameter");

        //send event
        driver.findElement(By.cssSelector("button#blog-submit-button-save")).click();

        String expectedEventName = "parameter";
        String actualEventName = driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr/td/div/div[2]/div/div[3]/div[2]/div[1]/div[1]/div[3]/div[1]/div/div/div[2]/table/tbody/tr[1]/td[2]/a")).getText();

        testResultEquals(expectedEventName, actualEventName);

        driver.close();

    }
}
