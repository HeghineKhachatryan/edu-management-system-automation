package com.epam.pages.popup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.time.LocalDate;
import java.util.List;

public class StudentsPopup extends CreatePopup {
    @FindBy(id = "address")
    protected WebElement address;
    @FindBy(id = "date")
    protected WebElement birthDate;
    @FindBy(id = "academicClass")
    protected WebElement linkedClass;
    @FindBy(id = "bloodGroup")
    protected WebElement bloodGroup;
    @FindBy(id = "gender")
    protected WebElement gender;
    @FindBy(id = "parent")
    protected WebElement linkedParent;
    @FindBy(className = "ui-datepicker-month")
    private WebElement monthToSelect;
    @FindBy(className = "ui-datepicker-year")
    private WebElement yearToSelect;
    @FindBy(className = "ui-datepicker-calendar")
    private WebElement calendar;
    @FindBy(xpath = "//select[@class='ui-datepicker-year']/option")
    private List<WebElement> listOfYears;
    private String selectedValue;

    public void fillBloodGenderBirthdayAddress() {
        logger.info("Fill blood group, gender.");
        fillAddress();
        selectBirthday(9, 7, 1996);
        clickOnFieldAndSelectValue("bloodGroup", "B-");
        clickOnFieldAndSelectValue("gender", "Female");
    }

    public void selectBirthday(int day, int month, int year) {
        uiHelper.clickOnWebElement(birthDate);
        logger.info("Fill birth day - {}/{}/{}", day, month, year);
        selectYear(year);
        new Select(monthToSelect).selectByIndex(month - 1);
        driver.findElement(By.xpath(String.format("//a[@data-date='%s']", day))).click();
        selectedValue = String.format("%s/%s/%s", day, month, year);
    }
    public void clickOnFieldAndSelectValue(String fieldName, String valueToSelect) {
        logger.info("Click on field {} and select value {}", fieldName, valueToSelect);
        WebElement element = driver.findElement(By.xpath(String.format("//select[@id='%s']", fieldName)));
        element.click();
        Select select = new Select(element);
        select.selectByVisibleText(valueToSelect);
        selectedValue = select.getWrappedElement().getText();
    }

    public void fillAddress() {
        selectedValue = "Armenia, Shirak, Gyumri, Shirakatsi, 104";
        logger.info("Fill address - {}", selectedValue);
        uiHelper.sendKeys(address, selectedValue);
    }
    public boolean isYearFromInterval() {
        logger.info("User is able to select dates between interval 1900 and 3 years before moment of selection");
        return listOfYears.stream().allMatch(element -> {
            int year = Integer.parseInt(element.getText());
            return year >= 1900 && year <= (LocalDate.now().getYear() - 3);
        });
    }

    public boolean checkValueOfSelectedField(String fieldName) {
        String text = driver.findElement(By.xpath(String.format("//select[@id='%s']", fieldName))).getText();
        logger.info("Value of selected '{}' field is - {}", fieldName, text);
        return text.equals(selectedValue);
    }

    public boolean checkCalendarIsOpened() {
        logger.info("Check calendar is opened.");
        uiHelper.clickOnWebElement(birthDate);
        return uiHelper.checkElementsAreDisplayed(calendar);
    }

    public boolean checkUIOfCreatePopupStudentsSection() {
        logger.info("Check UI of create popup in students section");
        return checkAllFieldsArePresent() &&
                uiHelper.checkElementsAreDisplayed(
                        address,
                        birthDate,
                        linkedClass,
                        bloodGroup,
                        gender,
                        linkedParent
                );
    }

    public boolean checkAllFieldsAreEmptyInStudentsCreatePopup() {
        logger.info("Check all fields are empty in students section create popup.");
        return checkAllInputFieldsAreEmpty()
                && !uiHelper.areElementsSelected(
                linkedClass,
                linkedParent,
                bloodGroup,
                gender,
                birthDate)
                && uiHelper.checkElementsAreEmpty(
                address
        );
    }

    public boolean areLinkedClassAndParentSelected() {
        logger.info("Check if 'linked class' and 'linked parent' fields are selected.");
        return uiHelper.areElementsSelected(linkedClass, linkedParent);
    }

    private void selectYear(int year) {
        logger.info("User is able to select dates between interval 1900 and 3 years before moment of selection" +
                "selected year is - {}", year);
        if (year >= 1900 && year <= (LocalDate.now().getYear() - 3)) {
            selectedValue = String.valueOf(year);
            new Select(yearToSelect).selectByValue(selectedValue);
        } else {
            logger.error("{} year is not in interval", year);
            throw new IllegalArgumentException("Year needs to be in the range of 1900 and 3 years before moment of selection");
        }
    }
}
