package com.github.zipcodewilmington.casino.games.ChoHan;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractRandomGame;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;
//import sun.jvm.hotspot.utilities.Assert;

import java.util.ArrayList;
import java.util.List;

public class ChoHanGame extends AbstractRandomGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    private Dice dice;
    private List<PlayerInterface> players;

    public ChoHanGame() {
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

    @Override
    public String getPlayerBeginInput() {
        return console.getStringInput(new StringBuilder()
        .append("\nWelcome to ChoHan Dice Game!")
        .append("\nThere will be two dice rolled! Bet your amount and guess if it is EVEN or ODD")
        .append("\nSelect if you wish to start the game or quit back to the main menu")
        .append("\n\t [ START ], [ QUIT ]")
        .toString());
    }

    @Override
    public int getPlayerBetInput() {
        return console.getIntegerInput(new StringBuilder()
                .append("\nPlease place in your bet wager")
                .toString());
    }

    @Override
    public String getPlayerInGameInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nPlease guess if the dice rolls are even or odd")
                .append("\n [ EVEN ], [ ODD ]")
                .toString());
    }

    @Override
    public String getPlayerGuessInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nPlease guess if the dice rolls are even or odd")
                .append("\n\t [ EVEN ], [ ODD ]")
                .toString());
    }

    @Override
    public String getPlayerWinInput() {
        return console.getStringInput(new StringBuilder()
                .append("\nCongratulations!")
                .append("\nYou have guessed correctly!")
                .append("\nThe game of Cho Han is over, would you like to play again?")
                .append("\n\t [ AGAIN ], [ QUIT ]")
                .toString());
    }

    @Override
    public String getPlayerLostInput() {
        return console.getStringInput(new StringBuilder()
                .append("\n OH NOOOOOOO!")
                .append("\nYou have guessed incorrectly!")
                .append("\nThe game of Cho Han is over, would you like to play again?")
                .append("\n\t [ AGAIN ], [ QUIT ]")
                .toString());
    }

    public List<PlayerInterface> getList(){
        return this.players;
    }
    @Override
    public void run() {
        String gameInput;
        do {
            int bet = 0;
            CasinoAccount player = this.players.get(0).getArcadeAccount();
            System.out.println("\n" +
                    "   _____ _             _    _             \n" +
                    "  / ____| |           | |  | |            \n" +
                    " | |    | |__   ___   | |__| | __ _ _ __  \n" +
                    " | |    | '_ \\ / _ \\  |  __  |/ _` | '_ \\ \n" +
                    " | |____| | | | (_) | | |  | | (_| | | | |\n" +
                    "  \\_____|_| |_|\\___/  |_|  |_|\\__,_|_| |_|" +
                    "                                          \n" + "              _______.\n" +
                    "   ______    | .   . |\\\n" +
                    "  /     /\\   |   .   |.\\\n" +
                    " /  '  /  \\  | .   . |.'|\n" +
                    "/_____/. . \\ |_______|.'|\n" +
                    "\\ . . \\    /  \\ ' .   \\'|\n" +
                    " \\ . . \\  /    \\____'__\\|\n" +
                    "  \\_____\\/" + "\n" +
                    "  _____  _             _____                      \n" +
                    " |  __ \\(_)           / ____|                     \n" +
                    " | |  | |_  ___ ___  | |  __  __ _ _ __ ___   ___ \n" +
                    " | |  | | |/ __/ _ \\ | | |_ |/ _` | '_ ` _ \\ / _ \\\n" +
                    " | |__| | | (_|  __/ | |__| | (_| | | | | | |  __/\n" +
                    " |_____/|_|\\___\\___|  \\_____|\\__,_|_| |_| |_|\\___|\n" +
                    "                                                  \n" +
                    "                                                  \n");
            gameInput = getPlayerBeginInput();

            if (gameInput.equalsIgnoreCase("start")) {
                dice = new Dice();

                System.out.println("[ ? ]  [ ? ]");

                // take in bet with PlayerBettingInput

                bet += getPlayerBetInput();

                // need guess statement here

                int totalSum;
                int dice1 = dice.rollDice(); // Random 1-6
                int dice2 = dice.rollDice(); // Random 1-6

                totalSum = dice1 + dice2; //has to be a number 2 - 12

                String guess = getPlayerGuessInput();
                System.out.println("[ " + dice1 + " ]  [ " + dice2 + " ]");
                if ((guess.equalsIgnoreCase("even") && totalSum % 2 == 0) || (guess.equalsIgnoreCase("odd") && totalSum % 2 != 0)) {
                    player.setBalance(player.getBalance() + bet);
                    System.out.println("\n" + player.getName() + "'s total balance: " + player.getBalance());
                    gameInput = getPlayerWinInput();


                    // guess number needs to be 2 4 6 8 10 12 to return win

                } else {
                    player.setBalance(player.getBalance() - bet);
                    System.out.println("\n" + player.getName() + "'s total balance: " + player.getBalance());
                    gameInput = getPlayerLostInput();

                }
            }

        } while(!"quit".equalsIgnoreCase(gameInput));

    }
}
