package com.github.zipcodewilmington.casino.games.SimplifiedWar;

import com.github.zipcodewilmington.casino.CasinoAccount;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimplifiedWarPlayerTest {

    CasinoAccount casinoAccount = new CasinoAccount("Gerald", "password", 350);
    SimplifiedWarPlayer player = new SimplifiedWarPlayer(casinoAccount);

    @Test
    void getHand() {
        assertTrue(player.getHand().empty());
    }

    @Test
    void getWinningPile() {
        assertTrue(player.getWinningPile().empty());
    }

    @Test
    void getArcadeAccount() {
        assertEquals("Gerald", player.getArcadeAccount().getName());
    }
}