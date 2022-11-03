package com.epam.pages.popup;

import com.epam.helpers.SharedTestData;
import com.epam.pages.common.CommonPopup;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SubjectPopup extends CommonPopup {

    @FindBy(id = "name")
    private WebElement nameField;
    @FindBy(id = "teacher")
    private WebElement teacherSelect;
    @FindBy(xpath = "//*[@class='selection']/span")
    private WebElement selectedTeachers;
    @FindBy(className = "select2-search__field")
    private WebElement teacherSelectField;
    @FindBy(xpath = "//*[@id='select2-teacher-container']/li")
    private List<WebElement> listOfSelectedTeachers;
    @FindBy(xpath = "//*[@id='select2-teacher-container']/li/button")
    private List<WebElement> xButtonsOfSelectedTeachers;
    @FindBy(className = "select2-selection__clear")
    private WebElement xButtonOfTheTeacherList;
    @FindBy(xpath = "//*[@class='select2-results__options']/li")
    private List<WebElement> teachers;
    @FindBy(xpath = "//input/following-sibling::div[@class='error']/p")
    private WebElement existedSubjectNameErrorMessage;

    public void fillName() {
        String subjectName = RandomStringUtils.random(16, true, false);
        logger.info("Fill subject name {}", subjectName);
        uiHelper.sendKeys(nameField, subjectName);
    }

    public void fillExistedSubjectName() {
        String existedName = SharedTestData.getLastCreatedItemName();
        logger.info("Fill existed subject name {}", existedName);
        uiHelper.sendKeys(nameField, existedName);
    }

    public void clickOnTheTeachersDropDownList() {
        uiHelper.clickOnWebElement(teacherSelectField);
    }

    public void fillTeacherName(String teacherName) {
        SharedTestData.setLastInputtedTeacherName(teacherName);
        logger.info("Fill teacher name {}", teacherName);
        uiHelper.sendKeys(teacherSelectField, teacherName);
    }

    public void selectTeacherByName(String teacherName) {
        Select select = new Select(teacherSelect);
        logger.info("Select teacher by name {}", teacherName);
        select.selectByVisibleText(teacherName);
    }

    public void selectTeacher() {
        logger.info("Select teacher");
        Select select = new Select(teacherSelect);
        select.selectByIndex(0);
    }

    public void saveValueFromSubjectNameField() {
        SharedTestData.setLastCreatedItemName(nameField.getDomProperty("value"));
    }

    public void saveValueOfSelectedTeacher() {
        SharedTestData.setLastCreatedItemName(listOfSelectedTeachers.get(listOfSelectedTeachers.size() - 1).getText());
    }

    public boolean checkAllElementsArePresent() {
        return uiHelper.checkElementsAreDisplayed(
                title,
                xButton,
                saveButton,
                nameField,
                teacherSelect
        );
    }

    public boolean checkAllFieldsAndDropDownListAreEmptyInSubjectsSectionCreatePopup() {
        logger.info("Check all fields and drop-down list are empty in subject section create popup");
        return uiHelper.checkElementsAreEmpty(nameField) && !uiHelper.areElementsSelected(teacherSelect);
    }

    public String getExistedSubjectNameErrorMessage() {
        return existedSubjectNameErrorMessage.getText();
    }

    public boolean checkMatchedItemsAreAppearedBelowTheSearchLine() {
        logger.info("Check matched items are appeared below the search line");
        return teachers.stream()
                .allMatch(
                        teacherName -> teacherName.getText().toLowerCase()
                                .contains(SharedTestData.getLastInputtedTeacherName().toLowerCase())
                );
    }

    public boolean checkSelectedItemsAreShownWithTheXIcon() {
        logger.info("Check selected items are shown with the 'x' icon");
        return listOfSelectedTeachers.stream()
                .allMatch(WebElement::isDisplayed)
                && xButtonsOfSelectedTeachers.stream()
                .allMatch(WebElement::isDisplayed);
    }

    public void clickOnXButtonOfSelectedTeacher() {
        uiHelper.clickOnWebElement(xButtonsOfSelectedTeachers.get(xButtonsOfSelectedTeachers.size() - 1));
    }

    public void clickOnXButtonOfTheTeacherList() {
        uiHelper.clickOnWebElement(xButtonOfTheTeacherList);
    }

    public boolean checkThereAreNoSelectedItems() {
        return !selectedTeachers.getAttribute("class").contains("clearable");
    }

    public String getTheSearchLinePlaceholder() {
        return teacherSelectField.getDomProperty("placeholder");
    }

}
