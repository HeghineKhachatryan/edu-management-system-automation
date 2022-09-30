package com.epam.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement emailInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(className = "button-login")
    private WebElement loginButton;

    public boolean checkEmailInputFieldIsPresent() {
        return emailInput.isDisplayed();
    }

    public boolean checkPasswordInputFieldIsPresent() {
        return passwordInput.isDisplayed();
    }

    public boolean checkLoginButtonIsPresent() {
        return loginButton.isDisplayed();
    }

    @Override
    protected String pageUrl() {
        return "http://localhost:8082/login";
    }
}
