package com.github.zipcodewilmington.casino.games.ChoHan;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractDiceGame;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

public class ChoHanGame extends AbstractDiceGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    private Dice dice;
    private Dice dice2;
    private int total;
    private int betAmount;

    @Override
    public void add(PlayerInterface player) {
    }

    @Override
    public void remove(PlayerInterface player) {
    }

    @Override
    public void run() {
    }

    @Override
    public String getPlayerBeginInput() {
        return null;
    }

    @Override
    public int getPlayerBetInput() {
        return 0;
    }

    @Override
    public String getPlayerInGameInput() {
        return null;
    }

    @Override
    public String getPlayerGuessInput() {
        return null;
    }

    @Override
    public String getPlayerWinInput() {
        return null;
    }

    @Override
    public String getPlayerLostInput() {
        return null;
    }
}
