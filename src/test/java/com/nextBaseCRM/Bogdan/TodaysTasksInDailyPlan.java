package com.nextBaseCRM.Bogdan;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;

public class TodaysTasksInDailyPlan {
    public static void main(String[] args) throws InterruptedException {
        //user can create, cancel, remove today's tasks from daily plan
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();


        driver.get("https://login2.nextbasecrm.com/");
        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
        driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser"+ Keys.ENTER);
        driver.findElement(By.className("timeman-wrap")).click();

        Thread.sleep(2000);
        driver.findElement(By.className("tm-popup-task-form-textbox")).sendKeys("New tasks");
        Thread.sleep(2000);
        driver.findElement(By.className("tm-popup-task-form-submit")).click();

        Thread.sleep(2000);
        ArrayList<WebElement> tasksList = new ArrayList<WebElement>(driver.findElements(By.xpath("//a[contains(@class,'tm-task')]")));

        tasksList.get(tasksList.size()-1).click();
        String expectedNameOfNewTask = "New tasks";
        String actualName = tasksList.get(tasksList.size()-1).getText();
        if (expectedNameOfNewTask.equalsIgnoreCase(actualName)) {
            System.out.println("User is able to create tasks");
        } else {
            System.out.println("User is not able to create tasks");
        }

        Thread.sleep(2000);

        driver.findElement(By.className("side-panel-close-inner")).click();

//
//        WebElement editButton = driver.findElement(By.xpath("//a[contains(@class,'task-view-button')]"));
//
//        editButton.click();



        ArrayList<WebElement> taskRemovebutton = new ArrayList<WebElement>(driver.findElements(By.xpath("//span[contains(@class,'menu-popup')]")));

        taskRemovebutton.get(taskRemovebutton.size()-1).click();


    }
}
