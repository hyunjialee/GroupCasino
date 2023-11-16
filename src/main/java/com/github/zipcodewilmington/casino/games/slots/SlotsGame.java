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

    @Override
    public void run() {
        String gameInput;

        do {
            int bet = 0;
            CasinoAccount player = this.players.get(0).getArcadeAccount();
            System.out.println("Welcome to the Slots Game!");

            gameInput = getPlayerBeginInput();


            if (gameInput.equalsIgnoreCase("start")) {
                System.out.println(" [ ? ]  [ ? ]  [ ? ] ");

                bet += getPlayerBetInput();

                int slot1 = dice.rollDice();
                int slot2 = dice.rollDice();
                int slot3 = dice.rollDice();

                System.out.println("[ " + slot1 + " ]  [ ? ]  [ ? ] ");
                System.out.println("[ " + slot1 + " ]  [ " + slot2 + " ]  [ ? ] ");
                System.out.println("[ " + slot1 + " ]  [ " + slot2 + " ]  [ " + slot3 + " ]");


                if (slot1 == slot2 && slot2 == slot3) {
                    //winning condition
                } else if (slot1 == slot2 || slot2 == slot3) {

                } else {
                    // losing condition
                }

            }
        } while (!"quit".equalsIgnoreCase(getPlayerInGameInput()));
    }
}
