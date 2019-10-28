package com.interview.test.gympass;

import com.interview.test.gympass.parser.RaceRegexConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaceRegexConstantsTest {

    private static final String HOUR_REGEX = "(\\d{2}:\\d{2}:\\d{2}.\\d{3})";
    private static final String SPACE_REGEX = "\\s+";
    private static final String DRIVER_REGEX = "(\\d{3}) – ([A-Za-z.]+)";
    private static final String LAP_REGEX =  "(\\d)";
    private static final String LAP_TIME_REGEX = "((\\d+):)?(\\d+)\\.(\\d{3})";
    private static final String AVERAGE_SPEED_REGEX = "(\\d+,\\d+)";
    private static final String LINE_REGEX =
        HOUR_REGEX + SPACE_REGEX +
            DRIVER_REGEX + SPACE_REGEX +
            LAP_REGEX + SPACE_REGEX +
            LAP_TIME_REGEX + SPACE_REGEX +
            AVERAGE_SPEED_REGEX;

    @Test
    public void whenCallHourRegex() {
        assertEquals(RaceRegexConstants.HOUR_REGEX, HOUR_REGEX);
    }

    @Test
    public void whenCallSpaceRegex() {
        assertEquals(RaceRegexConstants.SPACE_REGEX, SPACE_REGEX);
    }

    @Test
    public void whenCallDriverRegex() {
        assertEquals(RaceRegexConstants.DRIVER_REGEX, DRIVER_REGEX);
    }

    @Test
    public void whenCallLapRegex() {
        assertEquals(RaceRegexConstants.LAP_REGEX, LAP_REGEX);
    }

    @Test
    public void whenCallLapTimeRegex() {
        assertEquals(RaceRegexConstants.LAP_TIME_REGEX, LAP_TIME_REGEX);
    }

    @Test
    public void whenCallAverageSpeedRegex() {
        assertEquals(RaceRegexConstants.AVERAGE_SPEED_REGEX, AVERAGE_SPEED_REGEX);
    }

    @Test
    public void whenCallLineRegex() {
        assertEquals(RaceRegexConstants.LINE_REGEX, LINE_REGEX);
    }

}
