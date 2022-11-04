package com.epam.pages.main;

import com.epam.helpers.SharedTestData;
import com.epam.pages.common.CommonPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class AdminPage extends CommonPage {

    public boolean checkAllElementsArePresent() {
        logger.info("Check elements: list, role name, name and surname," +
                " sections, settings and create button are present");
        return uiHelper.checkElementsAreDisplayed(
                list,
                roleName,
                nameAndSurname,
                getSectionElementByName("teachers"),
                getSectionElementByName("students"),
                getSectionElementByName("parents"),
                getSectionElementByName("classes"),
                getSectionElementByName("years"),
                getSectionElementByName("subjects"),
                getSectionElementByName("vacations"),
                settingsSection,
                createButton
        );
    }

    public boolean checkUIofChosenSection() {
        logger.info("Check elements are displayed on the given section - list, create button");
        return uiHelper.checkElementsAreDisplayed(
                list,
                createButton
        );
    }

    private WebElement getSectionElementByName(String section) {
        return driver.findElement(By.xpath(String.format("//a[@href='/%s']", section)));
    }

    public boolean checkNewUserIsDisplayedOnAdminsSection() {
        logger.info("Check new user is displayed");
        return getNameOfLastCreatedUser()
                .equals(SharedTestData.getNameField())
                && getSurnameOfLastCreatedUser()
                .equals(SharedTestData.getSurnameField());
    }
    public boolean checkAcademicClassIsDisplayedInTheList() {
        logger.info("Get last created academic class and check if it is added to the list");
        return (listItemsHref.get(listItemsHref.size() - 1).getText())
                .equals(SharedTestData.getAcademicClass());
    }

    public void selectSection(String section) {
        uiHelper.clickOnWebElement(getSectionElementByName(section));
    }
}
