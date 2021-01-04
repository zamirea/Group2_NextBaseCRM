package com.nextBaseCRM.Andrei.StepDefs;

import com.Utility.AutomationTest;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;


public class Hooks {

    @Before(order = 0)
    public void scenarioStart() {
        AutomationTest.initial();

    }

    @After(order = 0)
    public void scenarioEnd(Scenario scenario) {
        AutomationTest.teardown();
    }
}
