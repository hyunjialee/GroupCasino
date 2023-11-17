package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Deck;

import java.util.ArrayList;

/**
 * Created by leon on 7/21/2020.
 */
public class NumberGuessGame {


    // dealer
    private Dealer dealer;

    // player
    private NumberGuessPlayer numberGuessPlayer;
    // deck
    private Deck deck;
    //hand
    private ArrayList<Cards> hand;
    private ArrayList<Cards> dealerHand;

    // hold (stand)
    //hit
    // -bet

    public NumberGuessGame(NumberGuessPlayer numberGuessPlayer){ // need a player to make the game work.
        this.numberGuessPlayer = numberGuessPlayer;

    }

    public Deck getDeck() {
        return deck;
    }



    public ArrayList<Cards> getHand() {
        return hand;
    }

    public void setHand(ArrayList<Cards> hand) {
        this.hand = hand;
    }

    public ArrayList<Cards> getDealerHand() {
        return dealerHand;
    }

    public void setDealerHand(ArrayList<Cards> dealerHand) {
        this.dealerHand = dealerHand;
    }

    public void  startingHand(Deck deck){ // this just dose it once in the begain.
        // pop 2 cards from deck
        Cards card1 = deck.draw();
        hand.add(card1);
        Cards card2 = deck.draw();
        // put card in players hand
        hand.add(card2);

    }
    public void  startingDealerHand(Deck deck){ // this just dose it once in the begain.
        // pop 2 cards from deck
        Cards card3 = deck.draw();
        dealerHand.add(card3);
        Cards card4 = deck.draw();
        // put card in players hand
        dealerHand.add(card4);

    }
//    public void  startingDealerHand(Deck deck){ // this just dose it once in the begain.
//        // pop 2 cards from deck
//        Cards card1 = deck.draw();
//        dealerHand.add(card1);
//        Cards card2 = deck.draw();
//        // put card in players hand
//        dealerHand.add(card2);
//
//    }

    public void  playerHit(Deck deck){ // this is if Player want to hit
        // pop 1 cards from deck
        Cards cardNew = deck.draw();
        hand.add(cardNew);
        // put card in players hand

    }
    public void  checkHandVaule() {

}







    public void run() {
        deck = new Deck();
        deck.shuffle();
        hand = new ArrayList<>();
        dealerHand = new ArrayList<>();

        startingDealerHand(deck);
       startingHand(deck); // using my method
        System.out.println("this is the Player Hand " + hand.get(0).getNumberValue() + " " + hand.getFirst().getSuit());
        System.out.println("last cards in Player Hand " + hand.get(hand.size()-1).getNumberValue());
        System.out.println("this is the Dealer Hand " + dealerHand.get(0).getNumberValue() + " " + hand.getFirst().getSuit());
        System.out.println("last cards in Dealer hand " + dealerHand.get(hand.size()-1).getNumberValue());
        }

    }
