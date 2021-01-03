package com.nextBaseCRM.Zamire.UserStory63;

import com.Utility.AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC84_UsersChooseAllDay extends AutomationTest {
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
        driver.findElement(By.cssSelector("input[placeholder='Event name']")).sendKeys("New Year's Party");

       // driver.findElement(By.xpath("//*[@id=\"feed-cal-from-to-contcal_3Jcl\"]/span[2]/label")).click();
        driver.findElement(By.id("event-full-daycal_3Jcl")).click();
        driver.findElement(By.cssSelector("button#blog-submit-button-save")).click();

        Thread.sleep(2000);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[1]/div[1]/ul/li[7]/a/span[1]")).click();
        driver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td/table/tbody/tr[1]/td[2]/table/tbody/tr[2]/td/div/div[2]/div/div/div[2]/div[3]/div[2]/div/div/div[5]/div[8]/div[4]/div/div")).click();
        String actualResult = driver.findElement(By.className("calendar-right-block-event-info-date")).getText();

        String expectedResult = "all day";

        if(actualResult.contains(expectedResult)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed!");
            System.out.println(actualResult);
            System.out.println(expectedResult);
        }

        driver.close();




    }
}
