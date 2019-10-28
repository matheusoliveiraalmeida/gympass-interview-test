package com.interview.test.gympass;

import com.interview.test.gympass.parser.RaceGroupConstants;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaceGroupConstantsTest {

    private static final int HOUR_GROUP = 1;
    private static final int DRIVER_CODE_GROUP = 2;
    private static final int DRIVER_NAME_GROUP = 3;
    private static final int LAP_GROUP = 4;
    private static final int LAP_TIME_MINUTE_GROUP = 6;
    private static final int LAP_TIME_SECOND_GROUP = 7;
    private static final int LAP_TIME_MILLI_SECOND_GROUP = 8;
    private static final int AVERAGE_SPEED_GROUP = 9;

    @Test
    public void whenCallHourGroup() {
        assertEquals(RaceGroupConstants.HOUR_GROUP, HOUR_GROUP);
    }

    @Test
    public void whenCallDriverCodeGroup() {
        assertEquals(RaceGroupConstants.DRIVER_CODE_GROUP, DRIVER_CODE_GROUP);
    }

    @Test
    public void whenCallDriverNameGroup() {
        assertEquals(RaceGroupConstants.DRIVER_NAME_GROUP, DRIVER_NAME_GROUP);
    }

    @Test
    public void whenCallLapGroup() {
        assertEquals(RaceGroupConstants.LAP_GROUP, LAP_GROUP);
    }

    @Test
    public void whenCallLapTimeMinuteGroup() {
        assertEquals(RaceGroupConstants.LAP_TIME_MINUTE_GROUP, LAP_TIME_MINUTE_GROUP);
    }

    @Test
    public void whenCallLapTimeSecondGroup() {
        assertEquals(RaceGroupConstants.LAP_TIME_SECOND_GROUP, LAP_TIME_SECOND_GROUP);
    }

    @Test
    public void whenCallLapTimeMilliSecondGroup() {
        assertEquals(RaceGroupConstants.LAP_TIME_MILLI_SECOND_GROUP, LAP_TIME_MILLI_SECOND_GROUP);
    }

    @Test
    public void whenCallAverageSpeedGroup() {
        assertEquals(RaceGroupConstants.AVERAGE_SPEED_GROUP, AVERAGE_SPEED_GROUP);
    }

}
