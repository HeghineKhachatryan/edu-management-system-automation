package com.epam.helpers;

public class SharedTestData {

    private static String generatedPassword;
    private static String lastEmail;
    private static String nameField;
    private static String surnameField;

    public static String getLastGeneratedPassword() {
        return generatedPassword;
    }

    public static void setLastGeneratedPassword(String password) {
        generatedPassword = password;
    }

    public static String getLastEmail() {
        return lastEmail;
    }

    public static void setLastEmail(String email) {
        lastEmail = email;
    }

    public static String getNameField() {
        return nameField;
    }

    public static void setNameField(String name) {
        nameField = name;
    }

    public static String getSurnameField() {
        return surnameField;
    }

    public static void setSurnameField(String surname) {
        surnameField = surname;
    }
}
