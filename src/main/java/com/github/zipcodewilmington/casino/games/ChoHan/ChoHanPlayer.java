package com.github.zipcodewilmington.casino.games.ChoHan;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class ChoHanPlayer implements PlayerInterface {
    CasinoAccount casinoAccount;

    public ChoHanPlayer(CasinoAccount CasinoAccount){
        this.casinoAccount = CasinoAccount;
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
