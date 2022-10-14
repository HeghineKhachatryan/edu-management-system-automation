package com.epam.steps.admin;

import com.epam.pages.main.AdminPage;
import com.epam.pages.popup.CreatePopup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTeacherSteps {
    private final AdminPage adminPage = new AdminPage();
    private final CreatePopup createPopup = new CreatePopup();

    @Then("See all elements are present")
    public void seeAllElementsArePresent() {
        assertThat(adminPage.checkAllElementsArePresent()).isTrue();
    }

    @When("Select {} section")
    public void selectSection(String section) {
        adminPage.selectSection(section);
    }

    @And("Fill in existed name, surname")
    public void fillInNameSurname() {
        createPopup.fillExistedName();
        createPopup.fillExistedSurname();
    }

    @Then("User is created and displayed in the list")
    public void userIsCreatedAndDisplayedInTheList() {
        assertThat(adminPage.checkNewUserIsDisplayedOnAdminsSection()).isTrue();
    }

    @Then("Check teacher is not added in the DB")
    public void checkAdminIsNotAddedInTheDB() {
        assertThat(adminPage.checkTeacherIsNotAddedInTheDB())
                .isTrue();
    }

    @Then("Check teacher is added in the DB")
    public void checkAdminIsAddedInTheDB() {
        assertThat(adminPage.checkTeacherIsNotAddedInTheDB())
                .isFalse();
    }

    @Then("Check the teacher password is hashed in the DB")
    public void checkPasswordIsHashedInTheDB() {
        assertThat(adminPage.passwordIsHashed())
                .isTrue();
    }
}
