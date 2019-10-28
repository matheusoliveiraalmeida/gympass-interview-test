package com.interview.test.gympass.model;

import com.interview.test.gympass.annotations.Position;

import java.time.LocalTime;

public class Race implements Comparable<Race> {

    @Position(initialPosition = 0, finalPosition = 8)
    private final LocalTime hour;

    @Position(initialPosition = 15, finalPosition = 18)
    private final String driverCode;

    @Position(initialPosition = 21, finalPosition = 40)
    private final String driverName;

    @Position(initialPosition = 40, finalPosition = 41)
    private final int lap;

    @Position(initialPosition = 48, finalPosition = 56)
    private final LocalTime lapTime;

    @Position(initialPosition = 65, finalPosition = 74)
    private final float averageLapSpeed;

    public Race(
        LocalTime hour,
        String driverCode,
        String driverName,
        int lap,
        LocalTime lapTime,
        float averageLapSpeed
    ) {
        this.hour = hour;
        this.driverCode = driverCode;
        this.driverName = driverName;
        this.lap = lap;
        this.lapTime = lapTime;
        this.averageLapSpeed = averageLapSpeed;
    }

    public LocalTime getHour() {
        return this.hour;
    }

    public String getDriverCode() {
        return this.driverCode;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public int getLap() {
        return this.lap;
    }

    public LocalTime getLapTime() {
        return this.lapTime;
    }

    public float getAverageLapSpeed() {
        return this.averageLapSpeed;
    }

    @Override
    public String toString() {
        return String.format("%12s %3s %-20s %d %12s %.3f",
            hour.toString(),
            driverCode,
            driverName,
            lap,
            lapTime.toString(),
            averageLapSpeed
        );
    }

    @Override
    public int compareTo(Race other) {
        if (!driverCode.equals(other.driverCode)) {
            return driverCode.compareTo(other.driverCode);
        }
        return Integer.compare(lap, other.lap);
    }

}
