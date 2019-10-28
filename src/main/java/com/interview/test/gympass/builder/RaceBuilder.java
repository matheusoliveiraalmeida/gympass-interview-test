package com.interview.test.gympass.builder;

import com.interview.test.gympass.model.Race;

import java.time.LocalTime;
import java.util.function.Consumer;

public class RaceBuilder {

    public LocalTime hour;
    public String driverCode;
    public String driverName;
    public int lap;
    public LocalTime lapTime;
    public float averageLapSpeed;

    public RaceBuilder with(Consumer<RaceBuilder> builder) {
        builder.accept(this);
        return this;
    }

    public Race build() {
        return new Race(hour, driverCode, driverName, lap, lapTime, averageLapSpeed);
    }

}
