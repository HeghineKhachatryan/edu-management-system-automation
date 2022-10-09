package com.epam.steps;

import com.epam.core.driver.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BaseSteps {

    public static void setup() {
        Driver.getDriver();
    }

    public static void quitDriver() {
        Driver.quitDriver();
    }
}
