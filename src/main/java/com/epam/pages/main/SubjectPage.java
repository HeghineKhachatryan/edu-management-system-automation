package com.epam.pages.main;

import com.epam.helpers.SharedTestData;
import com.epam.pages.common.CommonPage;
import org.openqa.selenium.By;

public class SubjectPage extends CommonPage {

    public void clickOnSectionByText(String sectionText) {
        String section = String.format("//div[contains(@class,'debar2')]/a[text()='%s']", sectionText);
        uiHelper.clickOnWebElement(driver.findElement(By.xpath(section)));
    }

    public void clickOnAddButton() {
        uiHelper.clickOnWebElement(createButton);
    }
    public int getTeacherListSize() {
        logger.info("Get teachers list size assigned for subjects");
        return listItems.size();
    }

    public void setListSize() {
        logger.info("Set list size assigned for last created item to SharedTest data.");
        SharedTestData.setListSize(listItems.size());
    }

    public void clickOnItemFromTheList(String itemName) {
        logger.info("Click on item from the list using item name and index");
        uiHelper.clickOnWebElement(listItemsHref.get(getIndexOfSubjectFromList(itemName)));
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
