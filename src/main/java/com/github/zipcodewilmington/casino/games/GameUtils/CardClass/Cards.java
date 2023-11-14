package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

public class Cards {

    private Suit suit;
    private NumberValue numberValue;

    public Cards(Suit suit, NumberValue numberValue) {
        this.suit = suit;
        this.numberValue = numberValue;

    }

    public Suit getSuit() {
        return suit;
    }

    public void setSuit(Suit suit) {
        this.suit = suit;
    }

    public NumberValue getNumberValue() {
        return numberValue;
    }

    public void setNumberValue(NumberValue numberValue) {
        this.numberValue = numberValue;
    }

    public Cards drawCards() {
        return null;
    }
}
