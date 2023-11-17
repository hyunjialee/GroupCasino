package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DeckTest {

    Deck deck = new Deck();

    @Test
    public void testDeck() {
        assertEquals(52, deck.deckOfCards.size());
    }
    @Test
    public void testDeck1() {
        Cards firstCard = deck.deckOfCards.get(0);

        assertEquals(Suit.HEARTS, firstCard.getSuit());
        assertEquals(NumberValue.ACE, firstCard.getNumberValue());
    }

    @Test
    public void draw() {
        Cards drawCard = deck.draw();

        assertEquals(Suit.CLUBS, drawCard.getSuit());
        assertEquals(NumberValue.KING, drawCard.getNumberValue());
    }

    @Test
    public void shuffle() {
        deck.shuffle();
        Cards firstCard = deck.deckOfCards.get(0);

        assertNotEquals(Suit.HEARTS, firstCard.getSuit());
        assertNotEquals(NumberValue.ACE, firstCard.getNumberValue());
    }
}