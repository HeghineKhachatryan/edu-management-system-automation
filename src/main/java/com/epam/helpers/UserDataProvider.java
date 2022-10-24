package com.epam.helpers;

import com.epam.config.PropertiesReader;

public final class UserDataProvider {

    private static final PropertiesReader propertiesReader = PropertiesReader.getInstanceForUserDataFile();

    private UserDataProvider() {
    }

    public static String getSuperAdminEmail() {
        return propertiesReader.getProperty("superAdminEmail");
    }

    public static String getSuperAdminPassword() {
        return propertiesReader.getProperty("superAdminPassword");
    }

    public static String getAdminEmail() {
        return propertiesReader.getProperty("adminEmail");
    }

    public static String getAdminPassword() {
        return propertiesReader.getProperty("adminPassword");
    }

    public static String getExistedEmail() {
        return propertiesReader.getProperty("existedEmail");
    }

    public static String getValidName() {
        return propertiesReader.getProperty("validName");
    }

    public static String getValidSurname() {
        return propertiesReader.getProperty("validSurname");
    }
}
