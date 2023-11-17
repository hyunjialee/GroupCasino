package com.github.zipcodewilmington.casino.games.SimplifiedWar;

import com.github.zipcodewilmington.Casino;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;

import java.util.Stack;

public class SimplifiedWarPlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;
    private Stack<Cards> hand;
    private Stack<Cards> winningPile;

    public SimplifiedWarPlayer(CasinoAccount casinoAccount) {
        this.hand = new Stack<>();
        this.winningPile = new Stack<>();
        this.casinoAccount = casinoAccount;
    }

    public Stack<Cards> getHand() {
        return this.hand;
    }

    public Stack<Cards> getWinningPile() {
        return this.winningPile;
    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return this.casinoAccount;
    }
    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}