package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void getPrimaryValue() {
        assertEquals('H', Suit.HEARTS.getPrimaryValue());
    }

    @Test
    void getSuitByValue() {
        assertEquals(Suit.DIAMONDS, Suit.getSuitByValue('D'));
    }

    @Test
    void values() {
        Suit[] values = Suit.values();

        assertEquals(4, values.length);
    }

    @Test
    void valueOf() {
        assertEquals(Suit.HEARTS, Suit.valueOf("HEARTS"));
    }
}