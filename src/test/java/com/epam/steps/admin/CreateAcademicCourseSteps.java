package com.epam.steps.admin;

import com.epam.helpers.ErrorMessagesProvider;
import com.epam.pages.main.AdminPage;
import com.epam.pages.popup.AcademicCoursePopup;
import com.epam.steps.BaseSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

import static org.assertj.core.api.Assertions.assertThat;

public class CreateAcademicCourseSteps extends BaseSteps {

    private AcademicCoursePopup academicCoursePopup;
    private AdminPage adminPage;

    @Before
    public void initPages() {
        academicCoursePopup = new AcademicCoursePopup();
        adminPage = new AdminPage();
    }

    @Given("Fill academic course name")
    public void fillAcademicCourseName() {
        academicCoursePopup.fillAcademicCourseName();
    }

    @Given("Fill existed academic course name")
    public void fillExistedAcademicCourseName() {
        academicCoursePopup.fillExistedAcademicCourseName();
    }

    @Given("Fill case sensitive existed academic course name")
    public void fillCaseSensitiveExistedAcademicCourseName() {
        logger.info("Fill case sensitive existed academic course name");
        academicCoursePopup.fillCaseSensitiveAcademicCourseName();
    }

    @Given("Select subject")
    public void selectSubject() {
        academicCoursePopup.selectSubject();
    }

    @Given("Click on 'Subject' select")
    public void clickOnSubjectSelect() {
        academicCoursePopup.clickOnSubjectSelect();
    }

    @And("Save value of selected subject")
    public void saveValueOfSelectedSubject() {
        academicCoursePopup.saveValueOfSelectedSubject();
    }

    @Then("Check all fields are present in create popup - academic course section")
    public void checkAllFieldsArePresentInCreatePopupAcademicCourseSection() {
        assertThat(academicCoursePopup.checkUIOfCreatePopupCoursesSection())
                .withFailMessage("All required elements in academic course section are not displayed")
                .isTrue();
    }

    @Then("Check academic course name field and drop down list are empty in courses section create popup")
    public void checkAcademicCourseNameFieldAndDropDownListAreEmptyInCoursesSectionCreatePopup() {
        assertThat(academicCoursePopup.checkAcademicCourseNameFieldAndDropDownListAreEmptyInCoursesSectionCreatePopup())
                .withFailMessage("Name field and drop down list are not empty on the courses section")
                .isTrue();
    }

    @Then("Check academic course is displayed in the list")
    public void checkSubjectIsDisplayedInTheList() {
        assertThat(adminPage.checkNewCreatedItemIsDisplayedOnAdminsSection())
                .withFailMessage("Academic course is not displayed in the list, but it should be")
                .isTrue();
    }

    @Then("Check academic course is added in the DB")
    public void academicCourseIsAddedInTheDB() {
        logger.info("Check academic course is added in the DB");
        assertThat(dbHelper.isAcademicCourseIsAddedInTheDB())
                .withFailMessage("Academic course is not added in the DB, but it should be")
                .isTrue();
    }

    @Then("Check academic course is not added in the DB")
    public void academicCourseIsNotAddedInTheDB() {
        logger.info("Check academic course is not added in the DB");
        assertThat(dbHelper.isAcademicCourseIsAddedInTheDB())
                .withFailMessage("Academic course is added in the DB, but it should be")
                .isFalse();
    }

    @Then("Check error message of existed academic course name")
    public void checkErrorMessageOfExistedAcademicCourseName() {
        logger.info("Check error message of existed academic course name");
        assertThat(academicCoursePopup.getExistedAcademicCourseNameErrMessage())
                .withFailMessage("Existed academic course name is wrong")
                .isEqualTo(ErrorMessagesProvider.getExistedAcademicCourseErrMessage());
    }

    @Given("Click on 'Subject' select and check dropdown opens with list of subjects")
    public void clickOnSubjectSelectAndCheckDropdownOpensWithListOfSubjects() {
        academicCoursePopup.clickOnSubjectSelect();
        logger.info("Check dropdown opens with list of subjects");
        assertThat(academicCoursePopup.checkDropdownOpensWithListOfSubjects())
                .withFailMessage("Dropdown is not opened or there aro no select options")
                .isTrue();
    }

    @And("Check the user choice is displayed in the 'Subject' field")
    public void checkTheUserChoiceIsDisplayedInTheSubjectField() {
        logger.info("Check 'Subject' dropdown is closed");
        assertThat(academicCoursePopup.checkTheUserChoiceIsDisplayedInTheSubjectField())
                .withFailMessage("Dropdown is not closed")
                .isTrue();
    }
}
