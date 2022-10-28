package com.epam.helpers;

import com.epam.config.PropertiesReader;

public final class ErrorMessagesProvider {

    private static final PropertiesReader propertiesReader = PropertiesReader
            .getInstance("error_messages.properties");

    private ErrorMessagesProvider() {
    }

    public static String getInvalidEmailErrMessage() {
        return propertiesReader.getProperty("invalidEmail");
    }

    public static String getMoreThan50SymbolsErrMessage() {
        return propertiesReader.getProperty("moreThan50Symbols");
    }

    public static String getBlankInputFieldsErrMessage() {
        return propertiesReader.getProperty("blankInputFields");
    }

    public static String getIncorrectLoginOrPasswordErrMessage() {
        return propertiesReader.getProperty("incorrectLoginOrPassword");
    }

    public static String getExistedEmailErrMessage() {
        return propertiesReader.getProperty("existedEmail");
    }

    public static String getExistedAcademicClassErrMessage() {
        return propertiesReader.getProperty("existedAcademicClass");
    }

    public static String getWrongSelectedDatesErrMessage() {
        return propertiesReader.getProperty("wrongSelectedDates");
    }

    public static String getLessThan30DaysErrMessage() {
        return propertiesReader.getProperty("lessThan30Days");
    }
}
