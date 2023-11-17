package com.github.zipcodewilmington.dicetest;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.Craps.CrapsGame;
import com.github.zipcodewilmington.casino.games.Craps.CrapsPlayer;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CrapsGameTest {
    CasinoAccount account;
    CrapsPlayer player = new CrapsPlayer(account);
    CrapsGame game = new CrapsGame();


    @Test
    void testRollDice() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertTrue(result < 7);

    }

    @Test
    public void testAdd() {
        game.add(player);

        Assert.assertTrue(game.getList().contains(player));

    }

    @Test
    public void testRemove() {
        game.add(player);
        game.remove(player);
        Assert.assertTrue(game.getList().isEmpty());
    }

    @Test
    public void testAdd2() {
        game.add(player);
        Assert.assertFalse(game.getList().isEmpty());
    }

    @Test
    public void testCrapsConstructor() {
        CasinoAccount account = new CasinoAccount("bob", "the", 123);
        CrapsPlayer player2 = new CrapsPlayer(account);

        Assert.assertEquals(player2.getArcadeAccount(), account);

    }

    @Test
    public void testGetAccount() {
        CrapsPlayer player3 = new CrapsPlayer(null);

        Assert.assertNull(player3.getArcadeAccount());

    }

    @Test
    public void testGetAccount2() {
        CasinoAccount account = new CasinoAccount("bob", "1", 123);
        CrapsPlayer player3 = new CrapsPlayer(account);

        Assert.assertNotNull(player3.getArcadeAccount());

    }
}























