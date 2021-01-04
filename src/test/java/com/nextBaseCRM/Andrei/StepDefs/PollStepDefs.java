package com.nextBaseCRM.Andrei.StepDefs;

import com.Utility.AutomationTest;
import com.nextBaseCRM.Andrei.PageObject.Page;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.LocalTime;

import static com.Utility.AutomationTest.*;
import static org.assertj.core.api.Assertions.assertThat;

public class PollStepDefs {

    @Given("I go to {string} page")

    public void iGoToPage(String page) {
        switch (page) {
            case "nextBaseCRM":
                driver.get("https://login2.nextbasecrm.com/");
                break;
            default:
                throw new RuntimeException("Undefined page");
        }

    }

    @Then("I logIn as {string} user")
    public void iLogInAsUser(String user) {
        switch (user.toLowerCase()) {
            case "marketing":
                driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("marketing3@cybertekschool.com");
                driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
                driver.findElement(By.cssSelector("input[value='Log In']")).click();
                break;
            case "hr":
                driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("hr4@cybertekschool.com");
                driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
                driver.findElement(By.cssSelector("input[value='Log In']")).click();
                break;
            case "helpdesk":
                driver.findElement(By.cssSelector("input[name='USER_LOGIN']")).sendKeys("helpdesk3@cybertekschool.com");
                driver.findElement(By.cssSelector("input[name='USER_PASSWORD']")).sendKeys("UserUser");
                driver.findElement(By.cssSelector("input[value='Log In']")).click();
                break;
            default:
                throw new RuntimeException("Undefined user");
        }
    }

    @And("I create a poll")
    public void iCreateAPoll() throws InterruptedException {
        LocalTime t1 = LocalTime.now();
        driver.findElement(By.xpath("//span[contains(text(),'Poll')]")).click();
        Thread.sleep(1000);
        driver.switchTo().frame(0);
        driverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("//body")));
        driver.findElement(By.xpath("//body")).sendKeys("Test " + t1);
        driver.switchTo().defaultContent();

        driver.findElement(By.cssSelector("#question_0")).sendKeys("Quest123");
        driver.findElement(By.cssSelector("#answer_0__0_")).sendKeys("Answerd1");
        driver.findElement(By.cssSelector("#answer_0__1_")).sendKeys("Answerd2");
        driverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.cssSelector("#blog-submit-button-save")));
        driver.findElement(By.cssSelector("#blog-submit-button-save")).click();
    }

    @Then("I select the first answer")
    public void iSelectTheFirstAnswer() throws InterruptedException {

        driverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@name,'vote_radio')])[1]/following-sibling::span")));
        WebElement checkBox = driver.findElement(By.xpath("(//input[contains(@name,'vote_radio')])[1]/following-sibling::span"));
        checkBox.click();
        driver.findElement(By.xpath("(//button[contains(text(),'Vote')])[2]")).click();

    }

    @And("I verify that first answer should be selected")
    public void iVerifyThatFirstAnswerShouldBeSelected() throws InterruptedException {
        driverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-bx-vote-result])[1]")));
        WebElement container = driver.findElement(By.xpath("(//a[@data-bx-vote-result])[1]"));
        if (container.getText().equals("1")) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail" + container.getText());
        }
        System.out.println(container.getText());
    }


    @When("I click Vote again")
    public void iClickVoteAgain() {
        driver.findElement(By.xpath("(//button[contains(text(),'Vote again')])[1]")).click();
        driverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[contains(@name,'vote_radio')])[2]/following-sibling::span")));

    }

    @Then("I select the second answer")
    public void iSelectTheSecondAnswer() throws InterruptedException {
        WebElement checkBox = driver.findElement(By.xpath("(//input[contains(@name,'vote_radio')])[2]/following-sibling::span"));
        checkBox.click();
        driver.findElement(By.xpath("(//button[contains(text(),'Vote')])[2]")).click();
        driverWait(driver, 5).until(ExpectedConditions.elementToBeClickable(By.xpath("(//a[@data-bx-vote-result])[2]")));

    }

    @And("I verify that second answer should be selected")
    public void iVerifyThatSecondAnswerShouldBeSelected() {
        WebElement container = driver.findElement(By.xpath("(//a[@data-bx-vote-result])[2]"));
        driverWait(driver, 5).until(ExpectedConditions.textToBePresentInElement(container, "1"));
        if (container.getText().equals("1")) {
            System.out.println("Test Pass");
        } else {
            System.out.println("Test Fail" + container.getText());
        }
        System.out.println(container.getText());
    }
}
