package com.github.zipcodewilmington.dicetest;

import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void testRollDice() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertTrue(result < 7);

    }
    @Test
    void testRollDice2() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertFalse(result < 0);

    }
    @Test
    void testRollDice3() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertFalse(result > 7);

    }    @Test
    void testRollDice4() {

        Dice dice = new Dice();
        int result = dice.rollDice();

        Assert.assertTrue(result > 0);
    }
}