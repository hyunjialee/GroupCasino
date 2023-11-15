package com.github.zipcodewilmington.casino.games.GameUtils;

public abstract class AbstractDiceGame {
    public abstract String getPlayerBeginInput();
    public abstract int getPlayerBetInput();
    public abstract String getPlayerInGameInput();
    public abstract String getPlayerGuessInput();
    public abstract String getPlayerWinInput();
    public abstract String getPlayerLostInput();

}
