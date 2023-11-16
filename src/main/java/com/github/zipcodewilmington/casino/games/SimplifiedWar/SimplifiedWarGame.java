package com.github.zipcodewilmington.casino.games.SimplifiedWar;

import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Deck;

import java.util.Collections;
import java.util.Objects;
import java.util.Scanner;
import java.util.Stack;

public class SimplifiedWarGame {

    private Deck deck;
    private SimplifiedWarPlayer player;
    private SimplifiedWarPlayer opponent;
    private Stack<Cards> playerHand;
    private Stack<Cards> opponentHand;
    private Stack<Cards> winningStack;
    private boolean autoPlay;

    public SimplifiedWarGame() {
        this.deck = new Deck();
        this.player = new SimplifiedWarPlayer();
        this.opponent = new SimplifiedWarPlayer();
        this.playerHand = player.getHand();
        this.opponentHand = opponent.getHand();
        this.winningStack = new Stack<>();
        this.autoPlay = false;
    }

    public boolean dealHands() {
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

    public void checkHandsAddWins() {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nHIT ENTER TO CONTINUE || HIT X TO EXIT");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("X");
    }

    public boolean promptAutoPlay() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nENABLE AUTOPLAY? Y/N");
        String input = scanner.nextLine();
        return input.equalsIgnoreCase("Y");
    }


    public static void main(String[] args) {
        SimplifiedWarGame war = new SimplifiedWarGame();

        war.autoPlay = war.promptAutoPlay();

        war.deck.shuffle();
        war.dealHands();

        int turns = 0;
        while (war.hasCards(war.player) && war.hasCards(war.opponent)) {
            Cards playerCard = war.playerHand.pop();
            war.winningStack.push(playerCard);
            Cards opponentCard = war.opponentHand.pop();
            war.winningStack.push(opponentCard);

            System.out.println("PLAYER CARD: " + playerCard.getSuit() + " " + playerCard.getNumberValue());
            System.out.println("OPPONENT CARD: " + opponentCard.getSuit() + " " + opponentCard.getNumberValue());

            String roundWinner = war.determineRoundWinner(playerCard, opponentCard);
            if (Objects.equals(roundWinner, "player")) {
                System.out.println("PLAYER WINS ROUND!!\n");
                war.player.getWinningPile().addAll(war.winningStack);
                war.winningStack.removeAllElements();
            } else if (Objects.equals(roundWinner, "opponent")) {
                System.out.println("OPPONENT WINS ROUND!!\n");
                war.opponent.getWinningPile().addAll(war.winningStack);
                war.winningStack.removeAllElements();
            } else if (Objects.equals(roundWinner, "tie")) {
                System.out.println("TIE ROUND, NO ONE WINS!!\n");
            }

            System.out.println("PLAYER HAND: " + (war.playerHand.size() + war.player.getWinningPile().size()));
            System.out.println("OPPONENT HAND: " + (war.opponentHand.size() + war.opponent.getWinningPile().size()));

            war.checkHandsAddWins();

            turns++;

            if (!war.autoPlay) {
                if (war.promptExit()) {
                    break;
                }
            }

        }

        System.out.println("TOTAL TURNS: " + turns);

    }

}
