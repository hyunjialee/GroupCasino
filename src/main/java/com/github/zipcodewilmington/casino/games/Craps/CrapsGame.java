package com.github.zipcodewilmington.casino.games.Craps;

import com.fasterxml.jackson.databind.util.ISO8601Utils;
import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractRandomGame;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractRandomGame;
import com.github.zipcodewilmington.casino.games.GameUtils.Dice;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.ArrayList;
import java.util.List;
public class CrapsGame extends AbstractRandomGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.CYAN);
    private Dice dice;

    private List<PlayerInterface>players;

    public CrapsGame(){
        this .dice = new Dice();
        this.players = new ArrayList<>();
    }


    @Override
    public void add(PlayerInterface player) {
        this.players.add(player);

    }

    public List<PlayerInterface> getList() {
        return this.players;
    }

    @Override
    public void remove(PlayerInterface player) {
             this.players.remove(player);
    }

    @Override
    public void run() {


        int bet = 0;
        CasinoAccount account = this.players.get(0).getArcadeAccount();

        String gameInput = getPlayerBeginInput();
        if (gameInput.equalsIgnoreCase("start")) {

            bet = getPlayerBetInput();

            int sum = 0;
            sum = dice.rollDice() + dice.rollDice();
            System.out.println("You rolled " + sum);


            if (sum == 7 || sum == 11) {
                int balance = account.getBalance();
                balance = balance + bet * 2;
                account.setBalance(balance);
                System.out.println("You win!" + balance);
            } else if (sum == 2 || sum == 3 || sum == 12) {
                account.setBalance( account.getBalance() - bet);
                System.out.println("You lose!" + bet);
            } else {
                int point = sum;
                System.out.println("Your point is " + point);

                while (true) {
                    sum = 0;
                    sum = dice.rollDice() + dice.rollDice();

                    if (sum == point) {
                        System.out.println("You win!");
                        break;
                    } else if (sum == 7) {
                        System.out.println("You lose!");
                        break;
                    }
                }
            }
        } else {

        }
    }



    @Override
    public String getPlayerBeginInput() {
        return console.getStringInput(new StringBuilder()
        .append("Welcome to Craps game Dice Game!")
                .append("\nThere will be two dice rolled! Bet your amount")
                .append("\nSelect if you wish to start the game or quit back to the main menu")
                .append("\n\t [ START ], [ QUIT ]")
                .toString());

    }

    @Override
    public int getPlayerBetInput() {
        return console.getIntegerInput("How much is the bet");

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
       return console.getStringInput(new StringBuilder()
                .append("\nCongratulations!")
                .append("\n you win bet ")
                .append("\n\t [ CONTINUE ], [ QUIT ]")
                .toString());
    }

    @Override
    public String getPlayerLostInput() {
        return console.getStringInput(new StringBuilder()

                .append("\n You have lost bet!")
                .append("\nThe game of Craps is over, would you like to play again?")
                .append("\n\t [ CONTINUE ], [ QUIT ]")
                .toString());
    }



}
