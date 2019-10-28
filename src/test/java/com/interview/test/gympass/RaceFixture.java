package com.interview.test.gympass;

import com.interview.test.gympass.model.Race;

import java.time.LocalTime;

class RaceFixture {

    static Race createRace(
        LocalTime hour,
        int lap,
        LocalTime lapTime
    ) {
        return new Race(hour, "000", "M.ALMEIDA", lap, lapTime,3.14f);
    }

}
