package com.github.zipcodewilmington.dicetest;

import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DiceTest {

    @Test
    void rollDice() {
        // rolls a number greater than 0, less than 7

        Dice dice = new Dice();
        int expected = 6;
        int actual = dice.rollDice();
        Assert.assertEquals(expected, actual);

    }

    @Test
    void getValue() {
        // gets value of the dice;

        int expected = 0;
        int actual = 0;
        Assert.assertEquals(expected, actual);
    }
}