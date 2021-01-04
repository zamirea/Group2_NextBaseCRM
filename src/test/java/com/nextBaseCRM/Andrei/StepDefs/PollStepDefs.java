package com.nextBaseCRM.Andrei.StepDefs;

import com.Utility.AutomationTest;
import com.nextBaseCRM.Andrei.PageObject.Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PollStepDefs extends Page {
    public WebDriver driver;

    @Given("I go to  {string} page")
    public void iGoToPage(String page) {

        switch (page) {
            case "nextBaseCRM":
                driver = AutomationTest.getDriver("chrome");
                driver.get("https://login2.nextbasecrm.com/");
                break;
            default:
                throw new RuntimeException("Undefined page");
        }

    }


    @Then("I logIn as {string} user")
    public void iLogInAsUser(String user) {
        if (user.equalsIgnoreCase("marketing")) {
            driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("marketing3@cybertekschool.com");
            driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
            driver.findElement(By.cssSelector("input[value='Log In']")).click();
        }
    }

    @And("I create a poll")
    public void iCreateAPoll() throws InterruptedException {
        driver.findElement(By.xpath("//span[contains(text(),'Poll')]")).click();
        driver.switchTo().frame(0);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//body")).sendKeys("Test");

        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#question_0")).sendKeys("Quest1");
        driver.findElement(By.cssSelector("#answer_0__0_")).sendKeys("Answerd1");
        driver.findElement(By.cssSelector("#answer_0__1_")).sendKeys("Answerd2");
        driver.findElement(By.cssSelector("#blog-submit-button-save")).click();


    }
}
