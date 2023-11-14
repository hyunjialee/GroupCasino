package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

public enum NumberValue {

    ACE(1, 11),
    TWO(2, 2),
    THREE(3, 3),
    FOUR(4, 4),
    FIVE(5, 5),
    SIX(6, 6),
    SEVEN(7, 7),
    EIGHT(8, 8),
    NINE(9, 9),
    TEN(10, 10),
    JACK(11, 10),
    QUEEN(12, 10),
    KING(13, 10);

    private final int primaryValue;
    private final int secondaryValue;

    NumberValue(int primaryValue, int secondaryValue) {
        this.primaryValue = primaryValue;
        this.secondaryValue = secondaryValue;
    }

    public int getPrimaryValue() {
        return primaryValue;
    }

    public int getSecondaryValue() {
        return secondaryValue;
    }
}
// This is a test - nathan