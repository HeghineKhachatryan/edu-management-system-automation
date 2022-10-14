package com.epam.steps.super_admin;

import com.epam.pages.main.SuperAdminPage;
import com.epam.pages.popup.CreatePopup;
import com.epam.steps.BaseSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAdminSteps extends BaseSteps {

    private SuperAdminPage superAdminPage;
    private CreatePopup createPopup;

    @Before
    public void initPages() {
        superAdminPage = new SuperAdminPage();
        createPopup = new CreatePopup();
    }

    @And("Check admin is not added in the DB")
    public void checkAdminIsNotAddedInTheDB() {
        logger.info("Check admin is not added in the DB");
        assertThat(superAdminPage.checkAdminIsNotAddedInTheDB())
                .isTrue();
    }

    @And("Check admin is added in the DB")
    public void checkAdminIsAddedInTheDB() {
        logger.info("Check admin is added in the DB");
        assertThat(superAdminPage.checkAdminIsNotAddedInTheDB())
                .isFalse();
    }

    @Given("Fill in input fields more than 50 symbols")
    public void typeInInputFieldsMoreThan50Symbols() {
        createPopup.fillInputFieldsWithMoreSymbols();
    }

    @Then("Check new Admin is displayed on the Admins section")
    public void checkNewAdminIsDisplayedOnTheAdminsSection() {
        assertThat(superAdminPage.checkNewAdminIsDisplayedOnAdminsSection())
                .isTrue();
    }

    @Then("Check the admin password is hashed in the DB")
    public void checkPasswordIsHashedInTheDB() {
        assertThat(superAdminPage.passwordIsHashed())
                .isTrue();
    }
}
