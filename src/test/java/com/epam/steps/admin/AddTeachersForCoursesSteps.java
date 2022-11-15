package com.epam.steps.admin;

import com.epam.helpers.SharedTestData;
import com.epam.pages.main.AdminPage;
import com.epam.pages.popup.AcademicCoursePopup;
import com.epam.steps.BaseSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class AddTeachersForCoursesSteps extends BaseSteps {

    private AcademicCoursePopup coursesPopup;
    private AdminPage adminPage;

    @Before
    public void initPages() {
        coursesPopup = new AcademicCoursePopup();
        adminPage = new AdminPage();
    }
    @When("Select item from 'select teachers' dropdown list")
    public void selectItemFromSelectTeachersDropdownList() {
        coursesPopup.selectTheFirstTeacher();
    }

    @And("Save linked teachers count for {} course from DB and list size from section")
    public void saveLinkedTeachersCountForCourseFromDBAndListSizeFromSection(String courseName) {
        adminPage.setListSize();
        coursesPopup.saveCountOfSelectedTeachersInTheBox();
        int dbCount = dbHelper.findCountOfTeachersAddedToTheCourse(courseName);
        logger.info("Save teachers count '{}' linked to '{}' course to shared test data",
                dbCount, courseName);
        SharedTestData.setTeachersCountLinkedToItem(dbCount);
    }

    @And("Check multi-select drop-down list is opened")
    public void checkMultiSelectDropDownListIsOpened() {
        assertThat(coursesPopup.checkDropDownListIsOpened())
                .withFailMessage("Drop down list is not opened, but it should be")
                .isTrue();
    }

    @And("Check teacher for {} course is added in the DB")
    public void checkTeacherForEnglishCourseIsAddedInTheDB(String courseName) {
        assertThat(isTeacherForCourseAddedToTheDB(courseName))
                .withFailMessage("Teacher for course is not added to the DB, but should be")
                .isTrue();
    }

    @And("Check teacher for {} course is not added in the DB")
    public void checkTeacherForAcademicCourseIsNotAddedInTheDB(String courseName) {
        assertThat(isTeacherForCourseAddedToTheDB(courseName))
                .withFailMessage("Teacher for course is added to the DB, but should not be")
                .isFalse();
    }

    private boolean isTeacherForCourseAddedToTheDB(String courseName) {
        int dbCount = dbHelper.findCountOfTeachersAddedToTheCourse(courseName);
        int sharedCount = SharedTestData.getTeachersCountLinkedToItem();
        logger.info("Count of teachers linked to {} academic course in the DB is {}, count of teachers in the list is {}," +
                "count of selected teachers is {}", courseName, dbCount, sharedCount, coursesPopup.getCountOfSelectedTeachers());
        return (dbCount - sharedCount) == coursesPopup.getCountOfSelectedTeachers();
    }
}
