package com.epam.pages.main;

import com.epam.pages.common.CommonPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AcademicClassPage extends CommonPage {

    @FindBy(className = "url-path")
    private WebElement urlPath;

    public boolean checkAllElementsArePresentInSection() {
        logger.info("Check elements are present in section - add button, url-path, list");
        return uiHelper.checkElementsAreDisplayed(
                createButton,
                urlPath,
                list
        );
    }
}
