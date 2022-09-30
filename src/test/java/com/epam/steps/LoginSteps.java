package com.epam.steps;

import com.epam.core.Driver;
import com.epam.pages.LoginPage;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.Assert.assertTrue;

public class LoginSteps {

    private static LoginPage loginPage;

    @BeforeAll
    public static void initPages() {
        Driver.getDriver();
        loginPage = new LoginPage();
        loginPage.get();
    }

    @Given("Check email input field is present")
    public void checkEmailInputFieldIsPresent() {
        assertTrue(loginPage.checkEmailInputFieldIsPresent());
    }

    @When("Check password input field is present")
    public void checkPasswordInputFieldIsPresent() {
        assertTrue(loginPage.checkPasswordInputFieldIsPresent());
    }

    @Then("Check login button is present")
    public void checkLoginButtonIsPresent() {
        assertTrue(loginPage.checkLoginButtonIsPresent());
    }

    @AfterAll
    public static void tearDown() {
        Driver.getDriver().quit();
    }
}
