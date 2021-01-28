package com.nextBaseCRM.Sofia;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class sendMessage {
    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        driver.get("https://nextbasecrm.com/" );
        driver.manage().window().maximize();

        driver.get("https://login2.nextbasecrm.com" );
        driver.findElement(By.name("USER_LOGIN" )).sendKeys("helpdesk3@cybertekschool.com" );
        driver.findElement(By.name("USER_PASSWORD" )).sendKeys("UserUser" + Keys.ENTER);

        driver.findElement(By.xpath("\"//span[text()='Message']\""));

        driver.findElements(By.id("blog-submit-button-save\">Send</button>"));

        // comment



    }
}
