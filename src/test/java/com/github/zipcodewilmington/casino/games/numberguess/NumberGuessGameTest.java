package com.github.zipcodewilmington.casino.games.numberguess;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Deck;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.NumberValue;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Suit;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import java.util.ArrayList;
import java.util.concurrent.Callable;

import static org.junit.jupiter.api.Assertions.*;

public class NumberGuessGameTest {
private CasinoAccount casinoAccount; //declaration the class
private NumberGuessGame numberGuessGame; //declaration the class
private NumberGuessPlayer numberGuessPlayer; //declaration the class


    @Before // JUnit will now call before every test, without you needing to do anything
    public  void setup() {
        // initialization --\/ the var
        casinoAccount = new CasinoAccount("user","password",6000); // getting the player account
        numberGuessPlayer = new NumberGuessPlayer(casinoAccount); // creating the player
        numberGuessGame = new NumberGuessGame(numberGuessPlayer);

      //  Dealer dealer = new Dealer();


        // do stuff
    }


//    @Test
//    public void  testnumberGuessRun() {
//        numberGuessGame.run();// this take the game and run it
//
//
//
//
//    }

    @Test
    public void testThatPlayerHandSizeIsTwoUponStart(){

        numberGuessGame.run();// this take the game and run it

        ArrayList<Cards> hand = numberGuessGame.getHand(); // hand getter
        int handSize = hand.size();// checking if the actual hand size is 2
        int exceptedHandSize = 2;
        Assert.assertEquals(handSize, exceptedHandSize); // checking that we get two cards when the game start.
    }
    @Test
    public void testThatDealerHandSizeIsTwoUponStart(){

        numberGuessGame.run();// this take the game and run it

        ArrayList<Cards> dealerHand = numberGuessGame.getDealerHand(); // hand getter
        int dealerHandSize = dealerHand.size();// checking if the actual hand size is 2
        int exceptedDealerHandSize = 2;
        Assert.assertEquals(dealerHandSize, exceptedDealerHandSize); // checking that we get two cards when the game start.
    }

    @Test
    public void testHit(){

        numberGuessGame.run(); // this runs the game.

        ArrayList<Cards> hand = numberGuessGame.getHand(); // hand getter
        int startingSize = hand.size();
        numberGuessGame.playerHit(numberGuessGame.getDeck());
        int handSize = hand.size(); // checking if hand is 3 objects in the array
        int exceptedHandSize = startingSize +1;


        Assert.assertEquals(handSize,exceptedHandSize); // checking that we get two cards when the game start.
        //new item add to array
    }
@Test
    public  void  checkHandValue(){
    numberGuessGame.run();
    ArrayList<Cards> hand = numberGuessGame.getHand(); // hand getter
    int startingHandValue = numberGuessGame.checkHandValue();
        int min = 2;
        int max = 30;


    Integer actual = startingHandValue;

    Assert.assertTrue((actual< max)); // the max
    Assert.assertTrue((actual>= min )); // the lows
    }

  //  @Test
//    public void  testStand(){
//        numberGuessGame.stand(); // this runs the game.
//
//
//
//
//
//
//
//        // check hand value
//        Assert.assertEquals();
//
//    }


//
//    @Test
//    public void testGetWin1( ){
//
//
//        p.hand = 21;
//        dealer.hand = 10;
//
//        Assert.assertTrue( p.hand = 21 && !((p.hand = dealer.hand )));
//        // hand value = (int) 21 and not both hands
//    }
//
//    @Test
//
//    public void testGetWin2( ){
//
//
//        p.hand = 17;
//        dealer.hand = 10;
//
//        Assert.assertTrue(p.hand > dealer.hand && !(p.hand > 21) );
//        //  handValue1 > handValue2 && !(hand value <21)
//    }
//
//
//    @Test
//    public void testGetBust (){
//
//        p.hand = 23;
//
//        Assert.assertTrue(p.hand > 21);
//        // hand value > (int) 21
//    }return p.hand; // player hand is over 21
//
//    public  void testGetLoss1( ){
//
//
//        p.hand = 10;
//        dealer.hand = 21;
//
//
//        Assert.assertTrue( dealer.hand = 21 && !((p.hand = dealer.hand)) );
//        // hand value = (int) 21 and not both hands
//    }
//
//    @Test
//    public void testGetLoss2( ){
//
//        p.hand = 10;
//        dealer.hand = 17;
//
//
//        Assert.assertTrue(p.hand < dealer.hand && !(dealer.hand > 21) );
//        // playerhand value < less then dealer hand && not dealer hand not over > 21
//
//    }
//
//
//    @Test
//    public void testGetTie( ){
//
//        p.hand = 18;
//        dealer.hand = 18;
//
//
//        Assert.assertTrue(p.hand = dealer.hand);
//        //player.hand value = dealer.hand value
//    }
//
//    @Test
//    public void testGetTie2( ){
//
//        p.hand = 23;
//        dealer.hand = 24;
//
//
//        Assert.assertTrue(p.hand > 21 &&  dealer.hand > 21);
//        // player and dealer bust( over 21)
//    }
//
//
}