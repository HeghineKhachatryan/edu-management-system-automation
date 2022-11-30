package com.epam.helpers;

import com.epam.config.PropertiesReader;

public final class MessageProvider {

    private static final PropertiesReader PROPERTIES_READER = PropertiesReader
            .getInstance("messages.properties");

    private MessageProvider() {
    }

    public static String getSuccessMsgForTimetableCreation() {
        return PROPERTIES_READER.getProperty("successfullyCreatedTimetable");
    }
}
