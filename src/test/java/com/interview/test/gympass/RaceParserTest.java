package com.interview.test.gympass;

import com.interview.test.gympass.model.Race;
import com.interview.test.gympass.parser.RaceParser;
import org.junit.Test;

import java.time.format.DateTimeFormatter;

import static org.junit.Assert.assertEquals;

public class RaceParserTest extends BaseTest {

    private static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    private static final String MSG_LOG_LINE_INVALID = "Linha de log inválida: %s";
    private static final int ONE_MICROSECOND = 1000000;

    @Test
    public void whenCallHourFormatter() {
        assertEquals(RaceParser.HOUR_FORMATTER.toString(), HOUR_FORMATTER.toString());
    }

    @Test
    public void whenCallMsgLogInvalid() {
        assertEquals(RaceParser.MSG_LOG_LINE_INVALID, MSG_LOG_LINE_INVALID);
    }

    @Test
    public void whenCallOneMicrosecond() {
        assertEquals(RaceParser.ONE_MICROSECOND, ONE_MICROSECOND);
    }

    @Test
    public void testParseLine() {
        RaceParser raceParser = new RaceParser();

        Race race = raceParser.parseLine("23:49:08.277      038 – F.MASSA                           1 1:02.852                        44,275");

        assertEquals("23:49:08.277", race.getHour().toString());
        assertEquals("038", race.getDriverCode());
        assertEquals("F.MASSA", race.getDriverName());
        assertEquals(1, race.getLap());
        assertEquals("00:01:02.852", race.getLapTime().toString());
        assertEquals(44.275, race.getAverageLapSpeed(), 0.0005);
    }

    @Test
    public void testParseLineInvalid() {
        exceptionTest(IllegalArgumentException.class, "");

        RaceParser raceParser = new RaceParser();

        raceParser.parseLine("xxx23:49:08.277      038 – F.MASSA               1 1:02.852                        44,275");
    }

}
