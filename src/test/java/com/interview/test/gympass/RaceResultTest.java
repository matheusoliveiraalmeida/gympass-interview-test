package com.interview.test.gympass;

import com.interview.test.gympass.model.Race;
import com.interview.test.gympass.model.RaceResult;
import org.junit.Test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import static com.interview.test.gympass.RaceFixture.createRace;
import static org.junit.Assert.assertEquals;

public class RaceResultTest {

    @Test
    public void testGettersAndSetters() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race = createRace(hour, 1, lapTime);

        RaceResult raceResult = new RaceResult(race);

        raceResult.setPosition(1);
        raceResult.setDriverCode("111");
        raceResult.setDriverName("J.AFONSO");
        raceResult.setLapsCompleted(4);
        raceResult.setTotalRaceTime(hour);

        assertEquals(1, raceResult.getPosition());
        assertEquals("111", raceResult.getDriverCode());
        assertEquals("J.AFONSO", raceResult.getDriverName());
        assertEquals(4, raceResult.getLapsCompleted());
        assertEquals(hour, raceResult.getTotalRaceTime());
        assertEquals(race.getLap(), raceResult.getBestLap());
        assertEquals(race.getLapTime(), raceResult.getBestLapTime());
        assertEquals(race.getAverageLapSpeed(), raceResult.getAverageSpeed(), 0.0005);
    }

    @Test
    public void testToString() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race = createRace(hour, 1, lapTime);

        RaceResult raceResult = new RaceResult(race);

        assertEquals("0 000 M.ALMEIDA            1     00:01:30 1     00:01:30 3,140", raceResult.toString());
    }

    @Test
    public void testResultPerTotalTimeWithDifference() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 2, 30);
        
        Race race = createRace(hour, 1, lapTime);

        RaceResult raceResult = new RaceResult(race);

        assertEquals("0 000 M.ALMEIDA            1     00:02:30 1     00:02:30 3,140 +00:01:10", raceResult.resultPerTotalRaceTime(LocalTime.of(0, 1, 20)));
    }

    @Test
    public void testCompareToEqualSameLap() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race = createRace(hour, 1, lapTime);

        RaceResult raceResult1 = new RaceResult(race);
        RaceResult raceResult2 = new RaceResult(race);
        
        assertEquals(0, raceResult1.compareTo(raceResult2));
    }

    @Test
    public void testCompareToSameLapThis() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race1 = createRace(hour, 1, lapTime);
        Race race2 = createRace(hour, 1, lapTime.plus(1, ChronoUnit.MINUTES));

        RaceResult raceResult1 = new RaceResult(race1);
        RaceResult raceResult2 = new RaceResult(race2);
        
        assertEquals(-1, raceResult1.compareTo(raceResult2));
    }

    @Test
    public void testCompareToSameLapOther() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race1 = createRace(hour, 1, lapTime);
        Race race2 = createRace(hour, 1, lapTime.minus(1, ChronoUnit.MINUTES));

        RaceResult raceResult1 = new RaceResult(race1);
        RaceResult raceResult2 = new RaceResult(race2);
        
        assertEquals(1, raceResult1.compareTo(raceResult2));
    }

    @Test
    public void testCompareToEqualDifferenceLapsThis() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race1 = createRace(hour, 2, lapTime);
        Race race2 = createRace(hour, 1, lapTime);

        RaceResult raceResult1 = new RaceResult(race1);
        RaceResult raceResult2 = new RaceResult(race2);
        
        assertEquals(-1, raceResult1.compareTo(raceResult2));
    }

    @Test
    public void testCompareToEqualDifferenceLapsOther() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race race1 = createRace(hour, 1, lapTime);
        Race race2 = createRace(hour, 2, lapTime);

        RaceResult raceResult1 = new RaceResult(race1);
        RaceResult raceResult2 = new RaceResult(race2);
        
        assertEquals(1, raceResult1.compareTo(raceResult2));
    }

}
