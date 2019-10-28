package com.interview.test.gympass.layout;

public enum Layout {

    HOUR(0, 18),
    ID(19, 23),
    DRIVER(24, 36),
    LAP(58, 59),
    LAP_TIME_MINUTE(0, 1),
    LAP_TIME_SECOND(2, 4),
    LAP_TIME_MILLIS_SECOND(5, 8),
    AVERAGE_SPEED(91, 97);

    private final int initialPosition;
    private final int finalPosition;

    Layout(int initialPosition, int finalPosition) {
        this.initialPosition = initialPosition;
        this.finalPosition = finalPosition;
    }

    public int getInitialPosition() {
        return initialPosition;
    }

    public int getFinalPosition() {
        return finalPosition;
    }

}
