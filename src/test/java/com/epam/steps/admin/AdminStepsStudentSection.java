package com.epam.steps.admin;

import com.epam.pages.main.AdminPage;
import com.epam.pages.popup.CreatePopup;
import com.epam.pages.popup.StudentsPopup;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AdminStepsStudentSection {
    private final AdminPage adminPage = new AdminPage();
    private final StudentsPopup studentsPopup = new StudentsPopup();
    private final CreatePopup createPopup = new CreatePopup();

    @Then("See all elements are present in student section")
    public void seeAllElementsArePresentInStudentSection() {
        assertThat(adminPage.checkUIofStudentsSection()).isTrue();
    }

    @Then("Check all fields are present in create popup - students section")
    public void checkAllFieldsArePresentInCreatePopupStudentsSection() {
        assertThat(studentsPopup.checkUIOfCreatePopupStudentsSection()).isTrue();
    }

    @And("Fill in all required fields in students section create popup")
    public void fillInAllRequiredFieldsInStudentsSectionCreatePopup() {
        createPopup.fillNameSurnameEmail();
        createPopup.clickOnGeneratePasswordButton();
        studentsPopup.fillBloodGenderBirthdayAddress();
    }

    @Then("Check all input fields are empty in students section create popup")
    public void checkAllInputFieldsAreEmptyInStudentsSectionCreatePopup() {
        assertThat(studentsPopup.checkAllFieldsAreEmptyInStudentsCreatePopup()).isTrue();
    }

    //duplicate in teachers section
    @When("Select {} section")
    public void selectSection(String section) {
        adminPage.selectSection(section);
    }

    @When("Fill in existed name, surname, all other required fields besides email")
    public void fillInExistedNameSurnameNonExistedMailAllOtherRequiredFields() {
        createPopup.fillExistedName();
        createPopup.fillExistedSurname();
        studentsPopup.fillBloodGenderBirthdayAddress();
    }

    @When("Click on 'Birth Day' field opens calendar")
    public void clickOnBirthDayFieldOpensCalendar() {
        assertThat(studentsPopup.checkCalendarIsOpened()).isTrue();
    }

    @Then("User is able to select dates between the given interval provided by documentation")
    public void userIsAbleToSelectDatesBetweenTheGivenIntervalProvidedByDocumentation() {
        assertThat(studentsPopup.isYearFromInterval()).isTrue();
    }

    @And("The user choice is displayed in the {} field")
    public void theUserChoiceIsDisplayedInTheLinkedClassField(String fieldName) {
        assertThat(studentsPopup.checkValueOfSelectedField(fieldName)).isTrue();
    }

    @Then("Check student created by admin is not added in the DB")
    public void checkAdminIsNotAddedInTheDB() {
        assertThat(adminPage.checkStudentIsNotAddedInTheDB())
                .isTrue();
    }

    @Then("Check student created by admin is added in the DB")
    public void checkAdminIsAddedInTheDB() {
        assertThat(adminPage.checkStudentIsNotAddedInTheDB())
                .isFalse();
    }

    //duplicate in teachers section
    @Then("User is created and displayed in the list")
    public void userIsCreatedAndDisplayedInTheList() {
        assertThat(adminPage.checkNewUserIsDisplayedOnAdminsSection()).isTrue();
    }

    @When("Click on {} field and select {} from the list")
    public void clickOnFieldAndSelectAcademicClassNameFromTheList(String fieldName, String valueToSelect) {
        studentsPopup.clickOnFieldAndSelectValue(fieldName, valueToSelect);
    }

    @And("Check that 'Linked Parent' and 'Linked Class' fields are not selected")
    public void checkThatLinkedParentAndLinkedClassFieldsAreNotSelected() {
        assertThat(studentsPopup.areLinkedClassAndParentSelected()).isFalse();
    }
}
