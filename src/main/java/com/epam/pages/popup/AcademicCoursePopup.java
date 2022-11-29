package com.epam.pages.popup;

import com.epam.helpers.ErrorMessagesProvider;
import com.epam.helpers.SharedTestData;
import com.epam.helpers.UserDataProvider;
import com.epam.pages.common.CommonPopup;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.*;

public class AcademicCoursePopup extends CommonPopup {

    @FindBy(id = "name")
    private WebElement academicCourseNameField;
    @FindBy(id = "subject")
    private WebElement subjectsSelect;
    @FindBy(id = "academicClass")
    private WebElement academicClassSelect;
    @FindBy(id = "course")
    private WebElement academicCourseSelect;
    @FindBy(id = "teacher")
    private WebElement teacherSelect;
    @FindBy(xpath = "//*/following-sibling::div[@class='error']")
    private WebElement existedAcademicCourseErrMessage;
    @FindBy(xpath = "//span[@role='combobox']")
    private WebElement selectTeachersBox;
    @FindBy(xpath = "//ul[@id='select2-teacher-results']/li")
    private List<WebElement> listOfTeachersOptions;
    @FindBy(id = "select2-teacher-results")
    private WebElement dropDownList;
    @FindBy(xpath = "//*[@id='select2-teacher-container']/li")
    private List<WebElement> listOfSelectedTeachers;
    private final Map<String, WebElement> map = new HashMap<>();

    public void fillAcademicCourseName() {
        String academicCourseName = RandomStringUtils.random(16, true, false);
        logger.info("Fill academic course name {}", academicCourseName);
        SharedTestData.setLastCreatedItemName(academicCourseName);
        uiHelper.sendKeys(academicCourseNameField, academicCourseName);
    }

    public void fillExistedAcademicCourseName() {
        String existedAcademicCourseName = UserDataProvider.getExistedAcademicCourse();
        logger.info("Fill existed academic course name {}", existedAcademicCourseName);
        uiHelper.sendKeys(academicCourseNameField, existedAcademicCourseName);
    }

    public void fillCaseSensitiveAcademicCourseName() {
        String existedAcademicCourseName = UserDataProvider.getExistedAcademicCourse();
        char firstCharacter = existedAcademicCourseName.charAt(0);
        uiHelper.sendKeys(academicCourseNameField, Character
                .isLowerCase(firstCharacter)
                ? existedAcademicCourseName.toUpperCase()
                : existedAcademicCourseName.toLowerCase()
        );
    }

    public String getExistedAcademicCourseNameErrMessage() {
        return existedAcademicCourseErrMessage.getText();
    }

    public boolean checkUIOfCreatePopupCoursesSection() {
        logger.info("Check UI of create popup in academic course section");
        return uiHelper.checkElementsAreDisplayed(
                academicCourseNameField,
                subjectsSelect,
                xButton,
                saveButton,
                title
        );
    }

    public boolean checkAcademicCourseNameFieldAndDropDownListAreEmptyInCoursesSectionCreatePopup() {
        logger.info("Check academic course name field and drop-down list are empty in courses section create popup");
        return uiHelper.checkElementsAreEmpty(academicCourseNameField)
                && !uiHelper.areElementsSelected(subjectsSelect);
    }

    public boolean checkErrorMessagesOfBlankSelectRequiredFields() {
        logger.info("Check error messages of blank selection fields");
        return getExistedAcademicCourseNameErrMessage()
                        .equals(ErrorMessagesProvider.getBlankSelectFieldsErrMessage());
    }

    public boolean checkAllElementsArePresentInAddClassPopupClassesSection() {
        logger.info("Check elements are present in add class popup academic classes section - " +
                "title, teachers and classes selects, xButton and save button");
        return uiHelper.checkElementsAreDisplayed(
                title,
                teacherSelect,
                academicClassSelect,
                xButton,
                saveButton
        );
    }

    public boolean checkAllElementsArePresentInAddTeachersPopupClassesSection() {
        logger.info("Check elements are present in add teacher popup academic classes section - " +
                "title, teachers and classes selects, xButton and save button");
        return uiHelper.checkElementsAreDisplayed(
                title,
                selectTeachersBox,
                xButton,
                saveButton
        );
    }

    public void clickOnDropDown(String name) {
        logger.info("Click on {} select and open dropdown", name);
        uiHelper.clickOnWebElement(getElementByNameFromMap(name));
    }

    public boolean areListOptionsPresent(String name) {
        logger.info("Check if options to select from {} dropdown are present", name);
        String xpath = String.format("//select[@id='%s']/option", name);
        return uiHelper.checkElementsAreDisplayed(driver.findElements(By.xpath(xpath)));
    }

    public void selectFirstItem(String dropDownList) {
        logger.info("Select first item from the {} dropdown list", dropDownList);
        new Select(getElementByNameFromMap(dropDownList)).selectByIndex(1);
    }

    public void saveValueOfSelectedItem(String value) {
        SharedTestData.setValueOfitem(new Select(getElementByNameFromMap(value)).getFirstSelectedOption().getText());
    }

    public boolean checkTheUserChoiceIsDisplayedInTheField(String value) {
        return new Select(getElementByNameFromMap(value)).getFirstSelectedOption().getText()
                .equals(SharedTestData.getValueOfitem());
    }

    public void selectTheFirstTeacher() {
        uiHelper.clickOnWebElement(listOfTeachersOptions.get(0));
    }

    private WebElement getElementByNameFromMap(String name) {
        return getMapOfElements().get(name);
    }

    private Map<String, WebElement> getMapOfElements() {
        map.putIfAbsent("academicClass",academicClassSelect);
        map.putIfAbsent("academicCourse",academicCourseSelect);
        map.putIfAbsent("teachers", teacherSelect);
        map.putIfAbsent("subject", subjectsSelect);
        return map;
    }

    public int getCountOfSelectedTeachers() {
        logger.info("Get count of selected teachers in the box.");
        return SharedTestData.getSelectedTeachersCountInTheBox();
    }

    public void saveCountOfSelectedTeachersInTheBox() {
        logger.info("Save count of selected teachers in the box.");
        SharedTestData.setSelectedTeachersCountInTheBox(listOfSelectedTeachers.size());
    }

    public boolean checkDropDownListIsOpened() {
        logger.info("Check multi-select drop-down list is opened.");
        return uiHelper.checkElementsAreDisplayed(dropDownList);
    }

    public List<String> getListOfSelectionOptions() {
        logger.info("Get list of selection options");
        List<String> options = new ArrayList<>();
        listOfTeachersOptions.forEach(element -> options.add(element.getText()));
        return options;
    }

    public boolean listContainsNames(List<String> list) {
        logger.info("Check if list contains another list's options");
        return new HashSet<>(list).containsAll(getListOfSelectionOptions());
    }
}
