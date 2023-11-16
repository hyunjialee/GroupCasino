package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardsTest {

    Cards card = new Cards(Suit.HEARTS, NumberValue.ACE);

    @Test
    void getSuit() {
        assertEquals(Suit.HEARTS, card.getSuit());
    }

    @Test
    void setSuit() {
        card.setSuit(Suit.DIAMONDS);

        assertEquals(Suit.DIAMONDS, card.getSuit());
    }

    @Test
    void getNumberValue() {
        assertEquals(NumberValue.ACE, card.getNumberValue());
    }

    @Test
    void setNumberValue() {
        card.setNumberValue(NumberValue.KING);

        assertEquals(NumberValue.KING, card.getNumberValue());
    }
}