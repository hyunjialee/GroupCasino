package com.github.zipcodewilmington.casino.games.GameUtils.CardClass;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    public Stack<Cards> deckOfCards = new Stack<>();

    //deck of cards extends stack

    public void shuffle(){
        Collections.shuffle(deckOfCards);
    }

    public Cards draw(){
        return deckOfCards.pop();
    }

    // needs 1-13 of each suit
    // assign each index to a specific card,
    // e.g. 0-12 = spades; 13-25 = clubs; 26-38 = hearts; 39-51 = diamonds

    public Deck() {
        for (Suit suit : Suit.values()) {
            for (NumberValue numberValue : NumberValue.values()) {
                deckOfCards.push(new Cards(suit, numberValue));
            }
        }
    }

}