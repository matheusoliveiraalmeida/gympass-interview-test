package com.interview.test.gympass;

import com.interview.test.gympass.model.Race;
import com.interview.test.gympass.model.RaceResult;
import com.interview.test.gympass.utils.CalculateAverageSpeed;
import org.junit.Test;

import java.time.LocalTime;

import static com.interview.test.gympass.RaceFixture.createRace;
import static org.junit.Assert.assertEquals;

public class CalculateAverageSpeedTest {

    @Test
    public void shouldCalculateAverageSpeed() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 52);

        Race race = createRace(hour, 2, lapTime);
        RaceResult raceResult = new RaceResult(race);

        CalculateAverageSpeed.calculate(race, raceResult);

        assertEquals(raceResult.getAverageSpeed(), 6.28, 0.005);

    }

}
