package com.epam.steps.admin;

import com.epam.pages.main.AdminPage;
import com.epam.pages.popup.CreatePopup;
import com.epam.steps.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTeacherSteps extends BaseSteps {
    private final AdminPage adminPage = new AdminPage();
    private final CreatePopup createPopup = new CreatePopup();

    @And("Fill in existed name, surname")
    public void fillInNameSurname() {
        createPopup.fillExistedName();
        createPopup.fillExistedSurname();
    }

    @Then("User is created and displayed in the list")
    public void userIsCreatedAndDisplayedInTheList() {
        assertThat(adminPage.checkNewUserIsDisplayedOnAdminsSection())
                .withFailMessage("Last created user is not displayed in the list, but it should be.")
                .isTrue();
    }

    @Then("Check teacher is not added in the DB")
    public void checkTeacherIsNotAddedInTheDB() {
        assertThat(dbHelper.isUserAddedInTheDB())
                .withFailMessage("Teacher wasn't meant to be added in the DB, but was added.")
                .isTrue();
    }

    @Then("Check teacher is added in the DB")
    public void checkTeacherIsAddedInTheDB() {
        assertThat(dbHelper.isUserAddedInTheDB())
                .withFailMessage("Teacher was meant to be added in the DB, but wasn't added.")
                .isFalse();
    }

    @Then("Check the teacher password is hashed in the DB")
    public void checkPasswordIsHashedInTheDB() {
        assertThat(dbHelper.isTeacherPasswordHashed())
                .withFailMessage("Password was not hashed in the DB.")
                .isTrue();
    }
}
