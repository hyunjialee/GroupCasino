package com.github.zipcodewilmington.casino.games.SimplifiedWar;

import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;

import java.util.Stack;

public class SimplifiedWarPlayer {

    private Stack<Cards> hand;
    private Stack<Cards> winningPile;

    public SimplifiedWarPlayer() {
        this.hand = new Stack<>();
        this.winningPile = new Stack<>();
    }

    public Stack<Cards> getHand() {
        return this.hand;
    }

    public Stack<Cards> getWinningPile() {
        return this.winningPile;
    }
}