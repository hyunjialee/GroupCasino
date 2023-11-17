package com.github.zipcodewilmington.dicetest;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import com.github.zipcodewilmington.casino.games.slots.SlotsGame;
import com.github.zipcodewilmington.casino.games.slots.SlotsPlayer;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class SlotsGameTest {
    CasinoAccount account;
    com.github.zipcodewilmington.casino.games.slots.SlotsPlayer player = new com.github.zipcodewilmington.casino.games.slots.SlotsPlayer(account);
    SlotsGame game = new SlotsGame();

    @Test
    void testRollDice() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertTrue(result < 7);

    }
    @Test
    public void testAdd(){
        game.add(player);

        Assert.assertTrue(game.getList().contains(player));

    }

    @Test
    public void testRemove(){
        game.add(player);
        game.remove(player);
        Assert.assertTrue(game.getList().isEmpty());
    }

    @Test
    public void testAdd2(){
        game.add(player);
        Assert.assertFalse(game.getList().isEmpty());
    }
    @Test
    public void testChohanConstructor() {
        CasinoAccount account = new CasinoAccount("bob", "the", 123);
        SlotsPlayer player2 = new SlotsPlayer(account);

        Assert.assertEquals(player2.getArcadeAccount(), account);

    }

    @Test
    public void testGetAccount() {
        SlotsPlayer player3 = new SlotsPlayer(null);

        Assert.assertNull(player3.getArcadeAccount());

    }

    @Test
    public void testGetAccount2() {
        CasinoAccount account = new CasinoAccount("bob", "1", 123);
        SlotsPlayer player3 = new SlotsPlayer(account);

        Assert.assertNotNull(player3.getArcadeAccount());

    }
}


