package com.epam.steps.admin;

import com.epam.steps.BaseSteps;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateParentSteps extends BaseSteps {

    @Then("Check parent created by admin is not added in the DB")
    public void checkParentIsNotAddedInTheDB() {
        assertThat(dbHelper.isUserAddedInTheDB())
                .withFailMessage("Parent wasn't meant to be added in the DB, but was added.")
                .isTrue();
    }

    @Then("Check parent created by admin is added in the DB")
    public void checkParentIsAddedInTheDB() {
        assertThat(dbHelper.isUserAddedInTheDB())
                .withFailMessage("Parent wasn't meant to be added in the DB, but was added.")
                .isFalse();
    }

    @Then("Check the parent password is hashed in the DB")
    public void checkTheParentPasswordIsHashedInTheDB() {
        assertThat(dbHelper.isParentPasswordHashed())
                .withFailMessage("Password was not hashed in the DB.")
                .isTrue();
    }
}
