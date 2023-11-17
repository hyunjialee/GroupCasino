package com.github.zipcodewilmington.casino.games.SimplifiedWar;

import com.github.zipcodewilmington.casino.CasinoAccount;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Cards;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.NumberValue;
import com.github.zipcodewilmington.casino.games.GameUtils.CardClass.Suit;
import org.junit.jupiter.api.Test;

import java.util.Stack;

import static org.junit.jupiter.api.Assertions.*;

class SimplifiedWarGameTest {

    SimplifiedWarGame simplifiedWarGame = new SimplifiedWarGame();
    CasinoAccount casinoAccount = new CasinoAccount("Gerald", "password", 350);
    SimplifiedWarPlayer player = new SimplifiedWarPlayer(casinoAccount);

    @Test
    void dealHands() {
        assertTrue(simplifiedWarGame.dealHands(player.getHand(), new Stack<>()));
    }

    @Test
    void hasCards() {
        assertFalse(simplifiedWarGame.hasCards(player));

        player.getHand().push(new Cards(Suit.HEARTS, NumberValue.ACE));
        assertTrue(simplifiedWarGame.hasCards(player));
    }

    @Test
    void determineRoundWinner() {
        Cards playerCard1 = new Cards(Suit.HEARTS, NumberValue.KING);
        Cards opponentCard1 = new Cards(Suit.CLUBS, NumberValue.TWO);
        assertEquals("player", simplifiedWarGame.determineRoundWinner(playerCard1, opponentCard1));

        Cards playerCard2 = new Cards(Suit.HEARTS, NumberValue.TWO);
        Cards opponentCard2 = new Cards(Suit.CLUBS, NumberValue.KING);
        assertEquals("opponent", simplifiedWarGame.determineRoundWinner(playerCard2, opponentCard2));

        Cards playerCard3 = new Cards(Suit.HEARTS, NumberValue.TWO);
        Cards opponentCard3 = new Cards(Suit.CLUBS, NumberValue.TWO);
        assertEquals("tie", simplifiedWarGame.determineRoundWinner(playerCard3, opponentCard3));
    }

    @Test
    void checkHandsAddWins() {
        assertTrue(player.getHand().isEmpty());
        player.getWinningPile().push(new Cards(Suit.HEARTS, NumberValue.ACE));

        simplifiedWarGame.checkHandsAddWins(player, player);
        assertEquals(1, player.getHand().size());
    }

}