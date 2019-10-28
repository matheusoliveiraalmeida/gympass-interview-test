package com.interview.test.gympass.parser;

public class RaceRegexConstants {

    public static final String HOUR_REGEX = "(\\d{2}:\\d{2}:\\d{2}.\\d{3})";
    public static final String SPACE_REGEX = "\\s+";
    public static final String DRIVER_REGEX = "(\\d{3}) – ([A-Za-z.]+)";
    public static final String LAP_REGEX =  "(\\d)";
    public static final String LAP_TIME_REGEX = "((\\d+):)?(\\d+)\\.(\\d{3})";
    public static final String AVERAGE_SPEED_REGEX = "(\\d+,\\d+)";
    public static final String LINE_REGEX =
        HOUR_REGEX + SPACE_REGEX +
            DRIVER_REGEX + SPACE_REGEX +
            LAP_REGEX + SPACE_REGEX +
            LAP_TIME_REGEX + SPACE_REGEX +
            AVERAGE_SPEED_REGEX;

}
