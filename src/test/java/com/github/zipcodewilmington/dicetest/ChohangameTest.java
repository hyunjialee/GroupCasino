package com.github.zipcodewilmington.dicetest;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.ChoHan.ChoHanGame;
import com.github.zipcodewilmington.casino.games.ChoHan.ChoHanPlayer;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ChohangameTest {
    CasinoAccount account;
    ChoHanPlayer player = new ChoHanPlayer(account);
    ChoHanGame game = new ChoHanGame();

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
    public void testChohanConstructor() {
        CasinoAccount account = new CasinoAccount("bob", "the", 123);
        ChoHanPlayer player2 = new ChoHanPlayer(account);

        Assert.assertEquals(player2.getArcadeAccount(), account);

    }

    @Test
    public void testGetAccount() {
        ChoHanPlayer player3 = new ChoHanPlayer(null);

        Assert.assertNull(player3.getArcadeAccount());

    }

    @Test
    public void testGetAccount2() {
        CasinoAccount account = new CasinoAccount("bob", "1", 123);
        ChoHanPlayer player3 = new ChoHanPlayer(account);

        Assert.assertNotNull(player3.getArcadeAccount());

    }
}