package com.interview.test.gympass.model;

import java.time.LocalTime;

public class RaceResult implements Comparable<RaceResult> {

    private int position;
    private String driverCode;
    private String driverName;
    private int lapsCompleted;
    private LocalTime totalRaceTime;
    private int bestLap;
    private LocalTime bestLapTime;
    private float averageSpeed;

    public RaceResult(Race race) {
        this.driverCode = race.getDriverCode();
        this.driverName = race.getDriverName();
        this.lapsCompleted = race.getLap();
        this.totalRaceTime = race.getLapTime();
        this.bestLap = race.getLap();
        this.bestLapTime = race.getLapTime();
        this.averageSpeed = race.getAverageLapSpeed();
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public String getDriverCode() {
        return this.driverCode;
    }

    public void setDriverCode(String driverCode) {
        this.driverCode = driverCode;
    }

    public String getDriverName() {
        return this.driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public int getLapsCompleted() {
        return this.lapsCompleted;
    }

    public void setLapsCompleted(int lapsCompleted) {
        this.lapsCompleted = lapsCompleted;
    }

    public LocalTime getTotalRaceTime() {
        return this.totalRaceTime;
    }

    public void setTotalRaceTime(LocalTime totalRaceTime) {
        this.totalRaceTime = totalRaceTime;
    }

    public int getBestLap() {
        return this.bestLap;
    }

    public void setBestLap(int bestLap) {
        this.bestLap = bestLap;
    }

    public LocalTime getBestLapTime() {
        return this.bestLapTime;
    }

    public void setBestLapTime(LocalTime bestLapTime) {
        this.bestLapTime = bestLapTime;
    }

    public float getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(float averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public String resultPerTotalRaceTime(LocalTime totalRaceTime) {
        LocalTime difference = LocalTime.of(
            this.totalRaceTime.getHour(),
            this.totalRaceTime.getMinute(),
            this.totalRaceTime.getSecond(),
            this.totalRaceTime.getNano()
        );

        difference = difference
            .minusHours(totalRaceTime.getHour())
            .minusMinutes(totalRaceTime.getMinute())
            .minusSeconds(totalRaceTime.getSecond())
            .minusNanos(totalRaceTime.getNano());

        return this.toString() + " +" + difference;
    }

    @Override
    public String toString() {
        return String.format("%d %3s %-20s %d %12s %d %12s %.3f",
            position,
            driverCode,
            driverName,
            lapsCompleted,
            totalRaceTime.toString(),
            bestLap,
            bestLapTime.toString(),
            averageSpeed
        );
    }

    @Override
    public int compareTo(RaceResult other) {
        if (lapsCompleted > other.lapsCompleted) {
            return -1;
        }

        if (lapsCompleted < other.lapsCompleted) {
            return 1;
        }

        if (totalRaceTime.equals(other.totalRaceTime)) {
            return 0;
        }

        return totalRaceTime.isBefore(other.totalRaceTime) ? -1 : 1;
    }

}
