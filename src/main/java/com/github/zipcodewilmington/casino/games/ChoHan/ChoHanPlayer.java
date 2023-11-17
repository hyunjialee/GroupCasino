package com.github.zipcodewilmington.casino.games.ChoHan;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class ChoHanPlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;

    public ChoHanPlayer(CasinoAccount casinoAccount){
        this.casinoAccount = casinoAccount;
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
