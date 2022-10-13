package com.epam.pages.main;

import com.epam.helpers.SharedTestData;
import com.epam.jdbc.service.AdminService;
import com.epam.pages.common.CommonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuperAdminPage extends CommonPage {

    @FindBy(linkText = "Admins")
    protected WebElement adminsSection;
    private final AdminService adminService = new AdminService();

    public boolean checkAllElementsArePresent() {
        logger.info("Check elements - list, role name, admins section, settings serction and create button are present");
        return uiHelper.checkElementsAreDisplayed(
                list,
                roleName,
                adminsSection,
                settingsSection,
                createButton
        );
    }

    public boolean checkAdminIsNotAddedInTheDB() {
        return adminService.findByEmail(SharedTestData.getLastGeneratedEmail()).getEmail() == null;
    }

    public boolean checkNewAdminIsDisplayedOnAdminsSection() {
        logger.info("Check admin is displayed on admins section");
        return getNameOfLastCreatedUser().equals(SharedTestData.getNameField()) && getSurnameOfLastCreatedUser().equals(SharedTestData.getSurnameField());
    }

    public boolean passwordIsHashed() {
        logger.info("Check password is encrypted");
        return !adminService.findByEmail(SharedTestData.getLastGeneratedEmail()).getPassword().equals(SharedTestData.getLastGeneratedPassword());
    }
}
