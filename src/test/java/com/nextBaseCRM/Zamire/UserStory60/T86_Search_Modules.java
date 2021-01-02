package com.nextBaseCRM.Zamire.UserStory60;

import com.Utility.AutomationTest;
import com.sun.xml.internal.fastinfoset.util.StringArray;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class T86_Search_Modules extends AutomationTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = getDriver("chrome");
        driver.get("http://login2.nextbasecrm.com");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing3@cybertekschool.com" + Keys.TAB + "UserUser"+ Keys.ENTER);

        WebElement searchBox = driver.findElement(By.id("search-textbox-input"));


        //@ parameter "Marufjon"

        searchBox.sendKeys("Marufjon");

        String expectedResult = "Marufjon";
        Thread.sleep(2000);
        String actualResult = driver.findElement(By.xpath("/html/body/div[6]/div/div[1]/div[2]/div/div/a/span[2]/span")).getText();
        Thread.sleep(2000);
        testResultEquals(expectedResult, actualResult);

        searchBox.clear();


    driver.close();
    }
}
