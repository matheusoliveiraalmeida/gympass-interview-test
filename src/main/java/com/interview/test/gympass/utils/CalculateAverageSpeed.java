package com.interview.test.gympass.utils;

import com.interview.test.gympass.model.Race;
import com.interview.test.gympass.model.RaceResult;

public final class CalculateAverageSpeed {

    private CalculateAverageSpeed() {}

    public static void calculate(Race race, RaceResult raceResult) {
        float distance = race.getAverageLapSpeed() * race.getLapTime().toNanoOfDay();

        float averageSpeed = (float) raceResult.getLapsCompleted() * distance / (float) raceResult.getTotalRaceTime().toNanoOfDay();

        raceResult.setAverageSpeed(averageSpeed);
    }

}
