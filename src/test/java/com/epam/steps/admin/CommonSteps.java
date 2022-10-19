package com.epam.steps.admin;

import com.epam.pages.main.AdminPage;
import com.epam.steps.BaseSteps;
import io.cucumber.java.en.When;

public class CommonSteps extends BaseSteps {
    private final AdminPage adminPage = new AdminPage();

    @When("Select {} section")
    public void selectSection(String section) {
        adminPage.selectSection(section);
    }
}
