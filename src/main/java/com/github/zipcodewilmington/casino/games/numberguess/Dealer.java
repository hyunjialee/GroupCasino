package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class Dealer implements PlayerInterface {



    private CasinoAccount casinoAccount;
    public Dealer(CasinoAccount casinoAccount){ // this is giving the deal a
        this.casinoAccount = casinoAccount;

    }

    @Override
    public CasinoAccount getArcadeAccount() {
        return casinoAccount;
    }

    @Override
    public <SomeReturnType> SomeReturnType play() {
        return null;
    }
}

