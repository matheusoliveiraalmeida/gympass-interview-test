package com.interview.test.gympass.parser;

import com.interview.test.gympass.builder.RaceBuilder;
import com.interview.test.gympass.model.Race;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static com.interview.test.gympass.parser.RaceGroupConstants.*;
import static com.interview.test.gympass.parser.RaceRegexConstants.LINE_REGEX;
import static java.lang.Float.parseFloat;
import static java.lang.Integer.parseInt;

public class RaceParser {

    public static final DateTimeFormatter HOUR_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss.SSS");
    public static final String MSG_LOG_LINE_INVALID = "Linha de log inválida: %s";
    public static final int ONE_MICROSECOND = 1000000;

    public Race parseLine(String line) {

        Pattern pattern = Pattern.compile(LINE_REGEX);
        Matcher matcher = pattern.matcher(line);

        if (!matcher.matches()) {
            throw new IllegalArgumentException(String.format(MSG_LOG_LINE_INVALID, line));
        }

        return createRace(matcher);

    }

    private Race createRace(Matcher matcher) {
        return new RaceBuilder().with(race -> {
            race.hour = getHour(matcher);
            race.driverCode = getDriverCode(matcher);
            race.driverName = getDriverName(matcher);
            race.lap = getLap(matcher);
            race.lapTime = getLapTime(matcher);
            race.averageLapSpeed = getAverageLapSpeed(matcher);
        }).build();
    }

    private float getAverageLapSpeed(Matcher matcher) {
        return parseFloat(matcher.group(AVERAGE_SPEED_GROUP).replace(",", "."));
    }

    private LocalTime getLapTime(Matcher matcher) {
        return LocalTime.of(0,
            parseInt(matcher.group(LAP_TIME_MINUTE_GROUP)),
            parseInt(matcher.group(LAP_TIME_SECOND_GROUP)),
            parseInt(matcher.group(LAP_TIME_MILLI_SECOND_GROUP)) * ONE_MICROSECOND
        );
    }

    private int getLap(Matcher matcher) {
        return parseInt(matcher.group(LAP_GROUP));
    }

    private String getDriverName(Matcher matcher) {
        return matcher.group(DRIVER_NAME_GROUP);
    }

    private String getDriverCode(Matcher matcher) {
        return matcher.group(DRIVER_CODE_GROUP);
    }

    private LocalTime getHour(Matcher matcher) {
        return LocalTime.parse(matcher.group(HOUR_GROUP), HOUR_FORMATTER);
    }

}
