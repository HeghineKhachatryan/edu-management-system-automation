package com.epam.steps.common;

import com.epam.pages.main.AdminPage;
import com.epam.pages.main.SuperAdminPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class UICheckSteps {

    private SuperAdminPage superAdminPage;

    @Before
    public void initPages() {
        superAdminPage = new SuperAdminPage();
    }

    @Then("Check all elements are present in super admin page")
    public void checkAllElementsArePresentInSuperAdminPage() {
        assertThat(superAdminPage.checkAllElementsArePresent())
                .isTrue();
    }
}
