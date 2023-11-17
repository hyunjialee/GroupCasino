package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

public enum Suit {
    HEARTS('H'),
    SPADES('S'),
    DIAMONDS('D'),
    CLUBS('C');

    private final char primaryValue;

    private Suit(char primaryValue) {
        this.primaryValue = primaryValue;
    }

    public char getPrimaryValue(){
        return primaryValue;
    }

    public static Suit getSuitByValue(char primaryValue){
        Suit[] suits = Suit.values();
        for (Suit suit : suits)
            if (suit.primaryValue == primaryValue)
                return suit;
        return null;
    }
}