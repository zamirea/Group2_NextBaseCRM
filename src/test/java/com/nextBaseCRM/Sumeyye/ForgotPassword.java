package com.nextBaseCRM.Sumeyye;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ForgotPassword {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://login2.nextbasecrm.com/");

        driver.findElement(By.name("USER_LOGIN")).sendKeys("helpdesk3@cybertekschool.com");
       // driver.findElement(By.name("USER_PASSWORD")).sendKeys("UserUser");
        Thread.sleep(2000);

        driver.findElement(By.xpath("//a[@class='login-link-forgot-pass']")).click();
        if(driver.getCurrentUrl().contains("forgot_password")){
            System.out.println("FORGOT YOUR PASSWORD? link is working properly. PASSED!");
        }else{
            throw new RuntimeException("\"FORGOT YOUR PASSWORD? link is NOT working properly. ERROR\"");
        }

    }
}
