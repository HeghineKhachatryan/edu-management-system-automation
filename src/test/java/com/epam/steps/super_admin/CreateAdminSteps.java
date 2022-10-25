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

    @Then("Check the admin password is hashed in the DB")
    public void checkPasswordIsHashedInTheDB() {
        assertThat(dbHelper.isAdminPasswordHashed())
                .withFailMessage("Password is not hashed in DB")
                .isTrue();
    }
}
