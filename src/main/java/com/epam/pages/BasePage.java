package com.epam.pages;

import com.epam.core.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public abstract class BasePage {

    private final WebDriver driver;

    public BasePage() {
        driver = Driver.getDriver();
        PageFactory.initElements(driver, this);
    }

    public void get() {
        driver.get(pageUrl());
    }

    protected String pageUrl() {
        return "";
    }
}
