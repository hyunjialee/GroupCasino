package com.github.zipcodewilmington.casino.games.ChoHan;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractDiceGame;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.List;

import static jdk.internal.org.jline.utils.AttributedStringBuilder.append;

public class ChoHanGame extends AbstractDiceGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    private Dice dice;
    private Dice dice2;
    private int total;
    private int betAmount;
    private ChoHanPlayer player;

    public ChoHanGame() {
        this.player = new ChoHanPlayer(player.getArcadeAccount());
        this.dice = new Dice();

    }

    @Override
    public void add(PlayerInterface player) {
    }

    @Override
    public void remove(PlayerInterface player) {
    }

    @Override
    public String getPlayerBeginInput() {
        return console.getStringInput(new StringBuilder()
        .append("Welcome to ChoHan Dice Game!")
        .append("\nThere will be two dice rolled! Bet your amount and guess if it is EVEN or ODD")
        .append("\nSelect if you wish to start the game or quit back to the main menu")
        .append("\n\t [ START ], [ QUIT ]")
        .toString());
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
    @Override
    public void run() {
        String gameInput;
        do {
            int bet = 0;
            int diceValue = 0;
            CasinoAccount player = this.player.getArcadeAccount();
            gameInput = getPlayerBeginInput();
        }
        while (!gameInput.equalsIgnoreCase("continue"){


            //if (player wants to start)
            // new Dice with [?][?]
            // take in bet with PlayerBettingInput


            //while(!gameDecision is "Continue")

            // ROLL THE DICE
            // Give the option for even or odd decision
            // if correct -> give winnings , print win statement and the value rolled
            // if incorrect -> lose bettings, print lost statement and the value rolled

            //

            //
        } // while (!"quit" is equal to the game decision)
    }

}
