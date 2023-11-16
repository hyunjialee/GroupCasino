package com.github.zipcodewilmington.casino.games.slots;

import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.AbstractRandomGame;

/**
 * Created by leon on 7/21/2020.
 */
public class SlotsGame extends AbstractRandomGame implements GameInterface {
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
