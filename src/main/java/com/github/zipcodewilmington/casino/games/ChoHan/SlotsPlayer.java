package com.github.zipcodewilmington.casino.games.ChoHan;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class SlotsPlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;

    public SlotsPlayer(CasinoAccount casinoAccount){
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
