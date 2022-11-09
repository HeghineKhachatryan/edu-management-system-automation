package com.epam.pages.popup;

import com.epam.helpers.SharedTestData;
import com.epam.pages.common.CommonPopup;
import com.epam.pages.main.AdminPage;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AcademicCoursePopup extends CommonPopup {

    @FindBy(id = "name")
    private WebElement academicCourseNameField;
    @FindBy(id = "subject")
    private WebElement subjectsSelect;
    @FindBy(xpath = "//input/following-sibling::div[@class='error']")
    private WebElement existedAcademicCourseErrMessage;

    public void fillAcademicCourseName() {
        String academicCourseName = RandomStringUtils.random(16, true, false);
        logger.info("Fill academic course name {}", academicCourseName);
        SharedTestData.setLastCreatedItemName(academicCourseName);
        uiHelper.sendKeys(academicCourseNameField, academicCourseName);
    }

    public void fillExistedAcademicCourseName() {
        String existedAcademicCourseName = new AdminPage().getNameOfLastCreatedItem();
        logger.info("Fill existed academic course name {}", existedAcademicCourseName);
        uiHelper.sendKeys(academicCourseNameField, existedAcademicCourseName);
    }

    public void fillCaseSensitiveAcademicCourseName() {
        String existedAcademicCourseName = new AdminPage().getNameOfLastCreatedItem();
        char firstCharacter = existedAcademicCourseName.charAt(0);
        uiHelper.sendKeys(academicCourseNameField, Character
                .isLowerCase(firstCharacter)
                ? existedAcademicCourseName.toUpperCase()
                : existedAcademicCourseName.toLowerCase()
        );
    }

    public void clickOnSubjectSelect() {
        uiHelper.clickOnWebElement(subjectsSelect);
    }

    public void selectSubject() {
        logger.info("Select subject");
        Select select = new Select(subjectsSelect);
        select.selectByIndex(1);
    }

    public void saveValueOfSelectedSubject() {
        SharedTestData.setLastSelectedSubject(new Select(subjectsSelect).getFirstSelectedOption().getText());
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

    public boolean checkDropdownOpensWithListOfSubjects() {
        List<WebElement> options = new Select(subjectsSelect).getOptions();
        return options.size() > 1 && uiHelper.checkElementsAreDisplayed(options);
    }

    public boolean checkTheUserChoiceIsDisplayedInTheSubjectField() {
        return new Select(subjectsSelect).getFirstSelectedOption().getText()
                .equals(SharedTestData.getLastSelectedSubject());
    }
}
