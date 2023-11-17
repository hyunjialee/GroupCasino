package com.github.zipcodewilmington.dicetest;

import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class ChohangameTest {

    @Test
    void testRollDice() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertTrue(result < 7);

    }

    @Test
    public void testAdd(){

    }

    @Test
    public void testRemove(){

    }
}
