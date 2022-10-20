package com.epam.steps.admin;

import com.epam.pages.main.AdminPage;
import com.epam.pages.main.LoginPage;
import com.epam.steps.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseSteps {
    private final AdminPage adminPage = new AdminPage();
    private final LoginPage loginPage = new LoginPage();

    @When("Select {} section")
    public void selectSection(String section) {
        adminPage.selectSection(section);
    }

    @And("Go to login page")
    public void goToLoginPage() {
        loginPage.goToPage();
    }
}
