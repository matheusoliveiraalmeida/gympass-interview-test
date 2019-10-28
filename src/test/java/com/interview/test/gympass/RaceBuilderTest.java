package com.interview.test.gympass;

import com.interview.test.gympass.builder.RaceBuilder;
import com.interview.test.gympass.model.Race;
import org.junit.Test;

import java.time.LocalTime;

import static org.junit.Assert.assertEquals;

public class RaceBuilderTest {

    @Test
    public void mustBuildRace() {

        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        String driverCode = "000";
        String driverName = "M.ALMEIDA";
        int lap = 4;
        float averageLapSpeed = 3.14f;

        Race race = new RaceBuilder().
            with(r -> {
                r.hour = hour;
                r.driverCode = driverCode;
                r.driverName = driverName;
                r.lap = lap;
                r.lapTime = lapTime;
                r.averageLapSpeed = averageLapSpeed;
            }).build();

        assertEquals(race.getHour(), hour);
        assertEquals(race.getDriverCode(), driverCode);
        assertEquals(race.getDriverName(), driverName);
        assertEquals(race.getLap(), lap);
        assertEquals(race.getAverageLapSpeed(), averageLapSpeed, 0.0005);
        assertEquals(race.getLapTime(), lapTime);

    }

}
