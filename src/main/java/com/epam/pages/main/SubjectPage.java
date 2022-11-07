package com.epam.pages.main;

import com.epam.helpers.SharedTestData;
import com.epam.pages.common.CommonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubjectPage extends CommonPage {

    @FindBy(xpath = "//div[@class='sidebar2']/a[@href='/subjects/Languages/teachers']")
    private WebElement teachersSection;

    public void clickOnTeachersSection() {
        uiHelper.clickOnWebElement(teachersSection);
    }

    public void clickOnAddButton() {
        uiHelper.clickOnWebElement(createButton);
    }
    public int getTeacherListSize() {
        logger.info("Get teachers list size assigned for subjects");
        return listItems.size();
    }

    public void setTeacherListSize() {
        logger.info("Set teachers list size assigned for subjects");
        SharedTestData.setListSize(listItems.size());
    }

    public void clickOnSubjectFromTheList(String subjectName) {
        logger.info("Click on subject from the list using subject name and index");
        uiHelper.clickOnWebElement(listItemsHref.get(getIndexOfSubjectFromList(subjectName)));
    }

    private int getIndexOfSubjectFromList(String subjectName) {
        logger.info("Get index of subject from the list");
        for (int i = 0; i < listItemsHref.size(); i++) {
            if (listItemsHref.get(i).getText().equals(subjectName)) {
                return i;
            }
        }
        return -1;
    }
}
