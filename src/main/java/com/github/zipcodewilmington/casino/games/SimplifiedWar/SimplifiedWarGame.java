package com.github.zipcodewilmington.casino.games.SimplifiedWar;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.GameInterface;
import com.github.zipcodewilmington.casino.PlayerInterface;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.AbstractCardGame;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Deck;
import com.github.zipcodewilmington.utils.AnsiColor;
import com.github.zipcodewilmington.utils.IOConsole;

import java.util.*;

public class SimplifiedWarGame extends AbstractCardGame implements GameInterface {
    private final IOConsole console = new IOConsole(AnsiColor.PURPLE);
    private final Deck deck;
    private final List<SimplifiedWarPlayer> players = new ArrayList<>();
    private final Stack<Cards> winningStack;
    private boolean autoPlay;

    public SimplifiedWarGame() {
        this.deck = new Deck();
        this.winningStack = new Stack<>();
        this.autoPlay = false;
    }

    @Override
    public void add(PlayerInterface player) {
        this.players.add((SimplifiedWarPlayer) player);
        this.players.add(new SimplifiedWarPlayer(new CasinoAccount("", "", 100)));
    }

    @Override
    public void remove(PlayerInterface player) {
        this.players.remove((SimplifiedWarPlayer) player);
    }

    public boolean promptAutoPlay() {
        String input = console.getStringInput("\nENABLE AUTOPLAY? [ Y ] [ N ]");
        return input.equalsIgnoreCase("Y");
    }

    private int getAutoPlayBet(int bet, CasinoAccount casinoPlayer) {
        if (autoPlay) {
            bet = console.getIntegerInput("HOW MUCH WOULD YOU LIKE TO BET? WINNER GETS 3X FOR AUTOPLAY");
            casinoPlayer.setBalance(casinoPlayer.getBalance() - bet);
            bet *= 3;
        }
        return bet;
    }
    public boolean dealHands(Stack<Cards> playerHand, Stack<Cards> opponentHand) {
        int deckSize = deck.deckOfCards.size();
        for (int i = 0; i < deckSize; i++) {
            if (i % 2 == 0) {
                playerHand.push(deck.draw());
            } else {
                opponentHand.push(deck.draw());
            }
        }
        return (playerHand.size() == opponentHand.size());
    }

    public boolean hasCards(SimplifiedWarPlayer simplifiedPlayer) {
        return (simplifiedPlayer.getHand().size() + simplifiedPlayer.getWinningPile().size()) != 0;
    }

    public String determineRoundWinner(Cards playerCard, Cards opponentCard) {
        if (playerCard.getNumberValue().getPrimaryValue() > opponentCard.getNumberValue().getPrimaryValue()) {
            return "player";
        } else if (playerCard.getNumberValue().getPrimaryValue() < opponentCard.getNumberValue().getPrimaryValue()) {
            return "opponent";
        } else {
            return "tie";
        }
    }

    public void checkHandsAddWins(SimplifiedWarPlayer player, SimplifiedWarPlayer opponent) {
        addWinsToHandAndShuffle(player);
        addWinsToHandAndShuffle(opponent);
    }

    public void addWinsToHandAndShuffle(SimplifiedWarPlayer simplifiedPlayer) {
        if (simplifiedPlayer.getHand().isEmpty()) {
            simplifiedPlayer.getHand().addAll(simplifiedPlayer.getWinningPile());
            simplifiedPlayer.getWinningPile().removeAllElements();
            Collections.shuffle(simplifiedPlayer.getHand());
        }
    }

    public boolean promptExit() {
        String input = console.getStringInput("\n[ ENTER TO CONTINUE ] [ X TO EXIT ]");
        return input.equalsIgnoreCase("X");
    }

    @Override
    public void run() {
        SimplifiedWarPlayer player = players.get(0);
        CasinoAccount casinoPlayer = player.getArcadeAccount();
        SimplifiedWarPlayer opponent = new SimplifiedWarPlayer(new CasinoAccount("", "", 100));
        Stack<Cards> playerHand = player.getHand();
        Stack<Cards> opponentHand = opponent.getHand();
        int bet = 0;

        System.out.println("" +
                "__/\\\\\\______________/\\\\\\_______________/\\\\\\\\\\\\\\\\\\_________________/\\\\\\\\\\\\\\\\\\_____        \n" +
                " _\\/\\\\\\_____________\\/\\\\\\_____________/\\\\\\\\\\\\\\\\\\\\\\\\\\_____________/\\\\\\///////\\\\\\___       \n" +
                "  _\\/\\\\\\_____________\\/\\\\\\____________/\\\\\\/////////\\\\\\___________\\/\\\\\\_____\\/\\\\\\___      \n" +
                "   _\\//\\\\\\____/\\\\\\____/\\\\\\____________\\/\\\\\\_______\\/\\\\\\___________\\/\\\\\\\\\\\\\\\\\\\\\\/____     \n" +
                "    __\\//\\\\\\__/\\\\\\\\\\__/\\\\\\_____________\\/\\\\\\\\\\\\\\\\\\\\\\\\\\\\\\___________\\/\\\\\\//////\\\\\\____    \n" +
                "     ___\\//\\\\\\/\\\\\\/\\\\\\/\\\\\\______________\\/\\\\\\/////////\\\\\\___________\\/\\\\\\____\\//\\\\\\___   \n" +
                "      ____\\//\\\\\\\\\\\\//\\\\\\\\\\_______________\\/\\\\\\_______\\/\\\\\\___________\\/\\\\\\_____\\//\\\\\\__  \n" +
                "       _____\\//\\\\\\__\\//\\\\\\________________\\/\\\\\\_______\\/\\\\\\___________\\/\\\\\\______\\//\\\\\\_ \n" +
                "        ______\\///____\\///_________________\\///________\\///____________\\///________\\///__");


        autoPlay = promptAutoPlay();
        bet = getAutoPlayBet(bet, casinoPlayer);

        // IF AUTOPLAY TRUE --> HOW MUCH DO YOU WANT TO BET? (IF PLAYER WINS, TRIPLE AMOUNT WON)
        // IF AUTOPLAY FALSE --> BET PER ROUND? (IF PLAYER WINS, DOUBLE AMOUNT WON)

        deck.shuffle();
        dealHands(playerHand, opponentHand);

        int turns = 1;
        while (hasCards(player) && hasCards(opponent)) {
            System.out.println("\n============ ROUND " + turns + " ============");
            System.out.println("" +
                    ".------.     .------.     .------.\n" +
                    "|W.--. |     |A.--. |     |R.--. |\n" +
                    "| :/ \\:|     | (\\/) |     | :(): |\n" +
                    "| :\\ /:|     | :\\/: |     | ()() |\n" +
                    "| '--'W|     | '--'A|     | '--'R|\n" +
                    "`------'     `------'     `------'");
            Cards playerCard = playerHand.pop();
            winningStack.push(playerCard);
            Cards opponentCard = opponentHand.pop();
            winningStack.push(opponentCard);

            System.out.println("PLAYER CARD:   " + playerCard.getNumberValue() + " OF " + playerCard.getSuit());
            System.out.println("OPPONENT CARD: " +  opponentCard.getNumberValue()+ " OF " + opponentCard.getSuit());

            String roundWinner = determineRoundWinner(playerCard, opponentCard);
            if (Objects.equals(roundWinner, "player")) {
                System.out.println("\n>> PLAYER WINS ROUND <<\n");
                player.getWinningPile().addAll(winningStack);
                winningStack.removeAllElements();
            } else if (Objects.equals(roundWinner, "opponent")) {
                System.out.println("\n>> OPPONENT WINS ROUND <<\n");
                opponent.getWinningPile().addAll(winningStack);
                winningStack.removeAllElements();
            } else if (Objects.equals(roundWinner, "tie")) {
                System.out.println("\n>> TIE ROUND <<\n");
            }

            System.out.println("PLAYER HAND:   " + (playerHand.size() + player.getWinningPile().size()));
            System.out.println("OPPONENT HAND: " + (opponentHand.size() + opponent.getWinningPile().size()));

            checkHandsAddWins(player, opponent);

            turns++;

            if (!autoPlay) {
                if (promptExit()) {
                    break;
                }
            }

            if (!hasCards(opponent)) {
                casinoPlayer.setBalance(casinoPlayer.getBalance() + bet);
                System.out.println("\nCONGRATULATIONS, YOU WIN!! YOUR BALANCE IS NOW: " + casinoPlayer.getBalance());
            } else if (!hasCards(player)) {
                System.out.println("\nTOO BAD, OPPONENT WINS!! YOUR BALANCE IS NOW: " + casinoPlayer.getBalance());
            }
        }
    }
}