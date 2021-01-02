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

WebElement frame = driver.findElement(By.xpath("//*[starts-with(@id,'iframe')]"));
driver.switchTo().frame(frame);
     WebElement el =   driver.findElement(By.xpath("//a[contains(@class,'button edit')]"));

        System.out.println(el.getText());
        System.out.println(el.getAttribute("href"));
        System.out.println("##################################");
        el.click();
        Thread.sleep(5000);

        WebElement inputHeadline = driver.findElement(By.xpath("//input[contains(@data-bx-id,'task-edit-title')]"));


        inputHeadline.sendKeys(" Cybertek school");

        driver.findElement(By.xpath("(//input[contains(@data-bx-id, 'datepicker-display')])[1]")).click();

        driver.findElement(By.xpath("(//span[contains(@class,'bx-calendar-button-text')])[1]")).click();

        driver.findElement(By.xpath("//button[contains(@data-bx-id,'task-edit-submit')]")).click();

        String actualTxt = driver.findElement(By.xpath("//span[contains(@id,'pagetitle')]")).getText();

        String expectedTxt = "New tasks Cybertek school";

        if (actualTxt.equalsIgnoreCase(expectedTxt)) {
            System.out.println("User is able to edit the tasks");
        } else  {
            System.out.println("User is not able to edit tasks");
        }

        Thread.sleep(2000);

        driver.switchTo().defaultContent();

        driver.findElement(By.xpath("(//span[contains(@class,'side-panel-close')])[1]")).click();

        //driver.switchTo().defaultContent();
        //to get outside of the frame




       // driver.findElement(By.xpath("//a[contains(@class,'task-view-button edit ui-btn ui-btn-link')]")).click();



       // driver.findElement(By.xpath("//a[contains(@href, '/company/personal/user/493/tasks/task/edit/2773')]")).click();

      //  driver.findElement(By.className("side-panel-close-inner")).click();

//
//        WebElement editButton = driver.findElement(By.xpath("//a[contains(@class,'task-view-button')]"));
//
//        editButton.click();


//
//        ArrayList<WebElement> taskRemovebutton = new ArrayList<WebElement>(driver.findElements(By.xpath("//span[contains(@class,'menu-popup')]")));
//
//        taskRemovebutton.get(taskRemovebutton.size()-1).click();


    }
}
