package com.epam.helpers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.LocalDate;

public final class SharedTestData {

    private static final Logger logger = LoggerFactory.getLogger(SharedTestData.class);
    private static String generatedPassword;
    private static String lastEmail;
    private static String nameField;
    private static String surnameField;
    private static String selectedValueOfStudentPopup;
    private static LocalDate startDate;
    private static LocalDate endDate;

    private SharedTestData() {
    }

    public static String getLastGeneratedPassword() {
        logger.info("Get last generated password {} from SharedTestData", generatedPassword);
        return generatedPassword;
    }

    public static void setLastGeneratedPassword(String password) {
        logger.info("Save value of last generated password {} into SharedTestData", password);
        generatedPassword = password;
    }

    public static String getLastEmail() {
        logger.info("Get last email {} from SharedTestData", lastEmail);
        return lastEmail;
    }

    public static void setLastEmail(String email) {
        logger.info("Save value of last email {} into SharedTestData", email);
        lastEmail = email;
    }

    public static String getNameField() {
        logger.info("Get name field {} from SharedTestData", nameField);
        return nameField;
    }

    public static void setNameField(String name) {
        logger.info("Save value of name fields {} into SharedTestData", name);
        nameField = name;
    }

    public static String getSurnameField() {
        logger.info("Get surname fields {} from SharedTestData", surnameField);
        return surnameField;
    }

    public static void setSurnameField(String surname) {
        logger.info("Save value of surname fields {} into SharedTestData", surname);
        surnameField = surname;
    }

    public static String getSelectedValueOfStudentPopup() {
        logger.info("Get selected value of student popup field {} from SharedTestData", selectedValueOfStudentPopup);
        return selectedValueOfStudentPopup;
    }

    public static void setSelectedValueOfStudentPopup(String selectedValue) {
        logger.info("Save selected value of student popup fields {} into SharedTestData", selectedValue);
        selectedValueOfStudentPopup = selectedValue;
    }


    public static LocalDate getStartDate() {
        return startDate;
    }

    public static void setStartDate(LocalDate startDate) {
        SharedTestData.startDate = startDate;
    }

    public static LocalDate getEndDate() {
        return endDate;
    }

    public static void setEndDate(LocalDate endDate) {
        SharedTestData.endDate = endDate;
    }
}
