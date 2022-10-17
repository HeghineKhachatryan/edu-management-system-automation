package com.epam.steps.admin;

import com.epam.helpers.SharedTestData;
import com.epam.jdbc.service.UserServiceImpl;
import com.epam.pages.main.AdminPage;
import com.epam.pages.popup.CreatePopup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateTeacherSteps {
    private final AdminPage adminPage = new AdminPage();
    private final CreatePopup createPopup = new CreatePopup();
    private final UserServiceImpl userService = new UserServiceImpl();

    @Then("See all elements are present on admin page")
    public void seeAllElementsArePresentOnAdminPage() {
        assertThat(adminPage.checkAllElementsArePresent())
                .withFailMessage("Elements in admin page are not present")
                .isTrue();
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
        assertThat(adminPage.checkNewUserIsDisplayedOnAdminsSection())
                .withFailMessage("Last created user is not displayed in the list, but it should be.")
                .isTrue();
    }

    @Then("Check teacher is not added in the DB")
    public void checkAdminIsNotAddedInTheDB() {
        assertThat(checkStudentIsNotAddedInTheDB())
                .withFailMessage("Teacher wasn't meant to be added in the DB, but was added.")
                .isTrue();
    }

    @Then("Check teacher is added in the DB")
    public void checkAdminIsAddedInTheDB() {
        assertThat(checkStudentIsNotAddedInTheDB())
                .withFailMessage("Teacher was meant to be added in the DB, but wasn't added.")
                .isFalse();
    }

    @Then("Check the teacher password is hashed in the DB")
    public void checkPasswordIsHashedInTheDB() {
        assertThat(passwordIsHashed())
                .withFailMessage("Password was not hashed in the DB.")
                .isTrue();
    }

    private boolean checkStudentIsNotAddedInTheDB() {
        return userService.findByEmail(SharedTestData.getLastGeneratedEmail()).getEmail() == null;
    }
    private boolean passwordIsHashed() {
        return !userService.findTeacherPasswordByEmail(
                        SharedTestData.getLastGeneratedEmail())
                .equals(SharedTestData.getLastGeneratedPassword());
    }
}
