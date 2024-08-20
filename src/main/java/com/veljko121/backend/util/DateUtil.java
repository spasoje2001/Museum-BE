package com.veljko121.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtil {
    private static final String DATE_FORMAT = "dd.MM.yyyy."; // Define the date format
    private static final DateTimeFormatter FORMATTER = DateTimeFormatter.ofPattern(DATE_FORMAT);

    public static String dateToString(LocalDate date) {
        return date.format(FORMATTER);
    }

    public static LocalDate stringToDate(String dateString) {
        try {
            return LocalDate.parse(dateString, FORMATTER);
        } catch (DateTimeParseException e) {
            // Log the exception, handle it, or throw an unchecked exception
            throw new IllegalArgumentException("Invalid date format. Please use this pattern: " + DATE_FORMAT, e);
        }
    }
}
