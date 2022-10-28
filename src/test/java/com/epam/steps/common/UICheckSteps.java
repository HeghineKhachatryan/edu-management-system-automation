package com.epam.steps.common;

import com.epam.pages.main.AdminPage;
import com.epam.pages.main.LoginPage;
import com.epam.pages.main.SuperAdminPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class UICheckSteps {

    private LoginPage loginPage;
    private SuperAdminPage superAdminPage;
    private AdminPage adminPage;

    @Before
    public void initPages() {
        loginPage = new LoginPage();
        superAdminPage = new SuperAdminPage();
        adminPage = new AdminPage();
    }

    @Then("Check all elements are present in login page")
    public void checkAllElementsArePresentInLoginPage() {
        assertThat(loginPage.checkAllElementsArePresent())
                .withFailMessage("All elements are present in login page")
                .isTrue();
    }

    @Then("Check all elements are present in super admin page")
    public void checkAllElementsArePresentInSuperAdminPage() {
        assertThat(superAdminPage.checkAllElementsArePresent())
                .withFailMessage("All elements are not present in super admin page.")
                .isTrue();
    }

    @Then("Check all elements are present on admin page")
    public void seeAllElementsArePresentOnAdminPage() {
        assertThat(adminPage.checkAllElementsArePresent())
                .withFailMessage("Elements in admin page are not present")
                .isTrue();
    }

    @Then("Check all elements are present on the chosen section")
    public void seeAllElementsArePresentInStudentSection() {
        assertThat(adminPage.checkUIofStudentsAndParentsSections())
                .withFailMessage("Elements are not present on the chosen section")
                .isTrue();
    }
}
