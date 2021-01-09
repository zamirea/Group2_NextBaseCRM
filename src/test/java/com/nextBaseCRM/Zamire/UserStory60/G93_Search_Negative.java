package com.nextBaseCRM.Zamire.UserStory60;

import com.Utility.AutomationTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class G93_Search_Negative extends AutomationTest {
    public static void main(String[] args) {
        WebDriver driver = getDriver("chrome");
        driver.get("http://login2.nextbasecrm.com");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("marketing3@cybertekschool.com" + Keys.TAB + "UserUser"+ Keys.ENTER);

        WebElement searchBox = driver.findElement(By.id("search-textbox-input"));

        searchBox.sendKeys("*40");

        List<String> expectedResults = new ArrayList<String>(Arrays.asList("Activity Stream", "Tasks", "Calendar", "Bitrix24.Drive", "Sites", "My workflows"));



        List<WebElement> searchOptions = driver.findElements(By.className("search-title-top-list-wrap"));

        List<String> actualResults = new ArrayList<String>();

        for(WebElement each: searchOptions){
            actualResults.add(each.getText());
        }

        // if nothing but default setting search module displayed. That means no other search results were displayed

        testResultEquals(expectedResults, actualResults);

        driver.close();
    }

}
