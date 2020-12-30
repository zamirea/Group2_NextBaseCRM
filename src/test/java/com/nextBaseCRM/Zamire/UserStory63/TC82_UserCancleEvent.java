package com.nextBaseCRM.Zamire.UserStory63;

import com.Utility.AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TC82_UserCancleEvent extends AutomationTest {
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
        driver.findElement(By.cssSelector("button#blog-submit-button-cancel")).click();

        String expectedTitle = "Portal";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

      if(actualTitle.contains(expectedTitle)){
          System.out.println("Test Passed!");
      } else {
          System.out.println("Test Failed!");
          System.out.println(actualTitle);
          System.out.println(expectedTitle);
      }

      driver.close();

    }
}
