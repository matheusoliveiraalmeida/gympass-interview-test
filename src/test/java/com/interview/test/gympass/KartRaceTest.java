package com.interview.test.gympass;

import com.interview.test.gympass.model.RaceResult;
import com.interview.test.gympass.race.KartRace;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class KartRaceTest extends BaseTest {

    @Test
    public void testRunRace() throws IOException {
        KartRace kartRace = new KartRace();

        String[] args = new String[1];
        args[0] = getFileLog();

        kartRace.runRace(args);

        List<RaceResult> raceResults = kartRace.getRaceResults();

        assertRaceResult(1, "038", "F.MASSA", 4, "00:04:11.578", raceResults.get(0));
        assertRaceResult(2, "002", "K.RAIKKONEN", 4, "00:04:15.153", raceResults.get(1));
        assertRaceResult(3, "033", "R.BARRICHELLO", 4, "00:04:16.080", raceResults.get(2));
        assertRaceResult(4, "023", "M.WEBBER", 4, "00:04:17.722", raceResults.get(3));
        assertRaceResult(5, "015", "F.ALONSO", 4, "00:04:54.221", raceResults.get(4));
        assertRaceResult(6, "011", "S.VETTEL", 3, "00:06:27.276", raceResults.get(5));

        assertEquals("23:51:14.216 038 F.MASSA              3 00:01:02.769 44,334", kartRace.getBestLapOfTheRace().toString());
    }

    @Test
    public void testGetRaceResultsNoRun() {
        exceptionTest(IllegalStateException.class, "The Race didn't start!");

        KartRace kartRace = new KartRace();

        kartRace.getRaceResults();
    }

    @Test
    public void testGetBestLapNoRun() {
        exceptionTest(IllegalStateException.class, "The Race didn't start!");

        KartRace kartRace = new KartRace();

        kartRace.getBestLapOfTheRace();
    }

    private void assertRaceResult(int position,
                                  String driverCode,
                                  String driverName,
                                  int lapsCompleted,
                                  String totalRaceTime,
                                  RaceResult raceResult) {

        assertEquals(position, raceResult.getPosition());
        assertEquals(driverCode, raceResult.getDriverCode());
        assertEquals(driverName, raceResult.getDriverName());
        assertEquals(lapsCompleted, raceResult.getLapsCompleted());
        assertEquals(totalRaceTime, raceResult.getTotalRaceTime().toString());

    }

}
