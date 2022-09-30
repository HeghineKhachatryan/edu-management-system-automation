package com.epam.core;

import com.epam.core.config.PropertiesReader;
import com.epam.core.factory.DriverFactory;
import org.openqa.selenium.WebDriver;

public class Driver {

    private static final String browserName = PropertiesReader.getInstance().getProperty("browser");

    public static WebDriver getDriver() {
        return DriverFactory.getDriver(browserName);
    }

    public static void quitDriver() {
        getDriver().quit();
    }
}
