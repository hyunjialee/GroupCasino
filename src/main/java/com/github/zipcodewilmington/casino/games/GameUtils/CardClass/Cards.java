package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

import java.util.Objects;

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
    @Override
    public String toString(){
        return suit + "-" + numberValue;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cards card = (Cards) o;
        return suit == card.suit &&
                numberValue == card.numberValue;
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, numberValue);
    }
}
