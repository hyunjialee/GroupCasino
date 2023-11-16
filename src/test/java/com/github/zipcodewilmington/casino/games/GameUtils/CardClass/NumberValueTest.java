package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberValueTest {

    @Test
    void getPrimaryValue() {
        assertEquals(1, NumberValue.ACE.getPrimaryValue());
    }

    @Test
    void getSecondaryValue() {
        assertEquals(11, NumberValue.ACE.getSecondaryValue());
    }

    @Test
    void values() {
        NumberValue[] values = NumberValue.values();

        assertEquals(13, values.length);
    }

    @Test
    void valueOf() {
        assertEquals(NumberValue.ACE, NumberValue.valueOf("ACE"));
    }
}