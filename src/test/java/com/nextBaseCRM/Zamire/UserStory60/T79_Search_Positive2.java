package com.nextBaseCRM.Zamire.UserStory60;

import com.Utility.AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class T79_Search_Positive2 extends AutomationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver("chrome");
        driver.get("https://login2.nextbasecrm.com");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing3@cybertekschool.com" + Keys.TAB);
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");

        driver.findElement(By.className("login-btn")).click();

        driver.findElement(By.cssSelector("#search-textbox-input")).sendKeys("Asiya");

        Thread.sleep(4000);

        List<WebElement> searchOptions = driver.findElements(By.className("search-title-top-item-text"));
        String expectedResults = "Asiya";

        List<String> actualResults = new ArrayList<String>();
        for(WebElement each: searchOptions){
            actualResults.add(each.getText());
        }
        Thread.sleep(7000);
        if(actualResults.contains(expectedResults)){
            System.out.println("Test passed!");
        }else {
            System.out.println("Test failed!");
            System.out.println(expectedResults);
            System.out.println(actualResults);
        }

        driver.close();

    }

}
