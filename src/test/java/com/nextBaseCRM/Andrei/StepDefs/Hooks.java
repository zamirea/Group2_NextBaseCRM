package com.nextBaseCRM.Andrei.StepDefs;

import com.Utility.AutomationTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;

import java.util.concurrent.TimeUnit;


import static com.Utility.AutomationTest.getDriver;


public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
        AutomationTest.initial();
        getDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        getDriver().manage().deleteAllCookies();

    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        AutomationTest.teardown();
    }
}
