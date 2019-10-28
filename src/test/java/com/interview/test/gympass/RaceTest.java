package com.interview.test.gympass;

import com.interview.test.gympass.model.Race;
import org.junit.Test;

import java.time.LocalTime;

import static com.interview.test.gympass.RaceFixture.createRace;
import static org.junit.Assert.assertEquals;

public class RaceTest {

    @Test
    public void testToString() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race line = createRace(hour, 1, lapTime);

        assertEquals("       10:00 000 M.ALMEIDA            1     00:01:30 3,140", line.toString());
    }

    @Test
    public void testCompareToEqual() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race line1 = createRace(hour, 1, lapTime);
        Race line2 = createRace(hour, 1, lapTime);

        assertEquals(0, line1.compareTo(line2));
    }

    @Test
    public void testCompareToThis() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race line1 = createRace(hour, 1, lapTime);
        Race line2 = createRace(hour, 2, lapTime);

        assertEquals(-1, line1.compareTo(line2));
    }

    @Test
    public void testCompareToOther() {
        LocalTime hour = LocalTime.of(10, 0);
        LocalTime lapTime = LocalTime.of(0, 1, 30);
        
        Race line1 = new Race(hour, "001", "M.ALMEIDA", 1, lapTime, 3.14f);
        Race line2 = new Race(hour, "000", "M.ALMEIDA", 1, lapTime, 3.14f);

        assertEquals(1, line1.compareTo(line2));
    }
    
}
