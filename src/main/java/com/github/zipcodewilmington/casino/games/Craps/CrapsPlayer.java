package com.github.zipcodewilmington.casino.games.Craps;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.PlayerInterface;

public class CrapsPlayer implements PlayerInterface {
    private CasinoAccount casinoAccount;

    public CrapsPlayer (CasinoAccount CasinoAccount){
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
