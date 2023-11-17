package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractRandomGame;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends AbstractRandomGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.PURPLE);
    private Dice dice;
    private List<PlayerInterface> players;

    public SlotsGame() {
        this.dice = new Dice();
        this.players = new ArrayList<>();
    }

    @Override
    public void add(PlayerInterface player) {
        this.players.add(player);
    }

    @Override
    public void remove(PlayerInterface player) {
        this.players.remove(player);
    }

    public List<PlayerInterface> getList() {
        return this.players;
    }
    @Override
    public String getPlayerBeginInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nWelcome to the Slots Game!")
                .append("\nThe slot numbers must all match to win the bet amount placed")
                .append("\nIf you win two numbers consecutively, you will win half of your bet back")
                .append("\nSelect if you wish to start the game or quit back to the main menu")
                .append("\n\t [ START ], [ QUIT ]")
                .toString());
    }

    @Override
    public int getPlayerBetInput() {
        return console.getIntegerInput(new StringBuilder()
                .append("Please place in your bet wager")
                .toString());
    }
    @Override
    public String getPlayerInGameInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nYou got two in a row!")
                .append("\nYou have receive half of your bet back into your account")
                .append("\nThe slots game is over, would you like to play again?")
                .append("\n[ AGAIN ], [ QUIT ]")
                .toString());
    }

    @Override
    public String getPlayerGuessInput() {
        return null;
    }

    @Override
    public String getPlayerWinInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nCongratulations, you got three numbers in a row!")
                .append("\nYou have won the slots machine!")
                .append("\nThe slots game is over, would you like to play again?")
                .append("\n[ AGAIN ], [ QUIT ]")
                .toString());
    }

    @Override
    public String getPlayerLostInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nTry again next time. Maybe you'll win :( ")
                .append("\nYou have lost the slots machine!")
                .append("\nThe slots game is over, would you like to play again?")
                .append("\n[ AGAIN ], [ QUIT ]")
                .toString());
    }

    @Override
    public void run() {
        String gameInput;

        do {
            int bet = 0;
            CasinoAccount player = this.players.get(0).getArcadeAccount();
            System.out.println("\n" +
                    "  _____ _       ___   ______      ___ ___   ____    __  __ __  ____  ____     ___ \n" +
                    " / ___/| |     /   \\ |      |    |   |   | /    |  /  ]|  |  ||    ||    \\   /  _]\n" +
                    "(   \\_ | |    |     ||      |    | _   _ ||  o  | /  / |  |  | |  | |  _  | /  [_ \n" +
                    " \\__  || |___ |  O  ||_|  |_|    |  \\_/  ||     |/  /  |  _  | |  | |  |  ||    _]\n" +
                    " /  \\ ||     ||     |  |  |      |   |   ||  _  /   \\_ |  |  | |  | |  |  ||   [_ \n" +
                    " \\    ||     ||     |  |  |      |   |   ||  |  \\     ||  |  | |  | |  |  ||     |\n" +
                    "  \\___||_____| \\___/   |__|      |___|___||__|__|\\____||__|__||____||__|__||_____|\n" +
                    "                                                                                  \n");

            gameInput = getPlayerBeginInput();


            if (gameInput.equalsIgnoreCase("start")) {
                System.out.println("[ ? ]  [ ? ]  [ ? ] ");

                bet += getPlayerBetInput();

                int slot1 = dice.rollDice();
                int slot2 = dice.rollDice();
                int slot3 = dice.rollDice();

                System.out.println("[ " + slot1 + " ]  [ ? ]  [ ? ] \n\n");
                System.out.println("[ " + slot1 + " ]  [ " + slot2 + " ]  [ ? ] \n\n");
                System.out.println("[ " + slot1 + " ]  [ " + slot2 + " ]  [ " + slot3 + " ]\n\n");


                if (slot1 == slot2 && slot2 == slot3) {
                    player.setBalance(player.getBalance() + bet);
                    System.out.println(player.getName() + "'s total balance: " + player.getBalance());
                    gameInput = getPlayerWinInput();

                    //winning bet


                } else if (slot1 == slot2 || slot2 == slot3) {
                    bet /= 2;
                    player.setBalance(player.getBalance() + bet);
                    System.out.println(player.getName() + "'s total balance: " + player.getBalance());
                    gameInput = getPlayerInGameInput();
                    //half the money that was bet

                } else {
                    player.setBalance(player.getBalance() - bet);
                    System.out.println(player.getName() + "'s total balance: " + player.getBalance());
                    gameInput = getPlayerLostInput();

                    // losing condition
                }
            }
        } while (!"quit".equalsIgnoreCase(gameInput));
    }
}
