package com.veljko121.backend.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;

public class DateUtil {
    private static final String DATE_FORMAT = "dd.MM.yyyy."; // Define the date format

    public static String dateToString(LocalDate date) {
        SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
        return sdf.format(date);
    }

    public static LocalDate stringToDate(String dateString) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_FORMAT);
        try {
            return LocalDate.parse(dateString, formatter);
        } catch (DateTimeParseException e) {
            // Log the exception, handle it, or throw an unchecked exception
            throw new IllegalArgumentException("Invalid date format. Please use this pattern: " + DATE_FORMAT, e);
        }
    }
}
