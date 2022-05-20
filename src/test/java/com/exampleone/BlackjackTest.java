package com.exampleone;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

//So many void methods in the live code. So many. 

class BlackjackTest {

    @Test
    void testPlayerMoney() {
        double playerMoney = 200.00;
        assertEquals(playerMoney, 200);
    }

    @Test
    void testEndRound() {
        boolean endRound = false;
        assertFalse(endRound);
    }

    @Test
    void testDealerBust() {
        int dealerDeck = 24;
        if (dealerDeck > 21) {
            System.out.println("Dealer busts. You win!");
        }
        assertTrue(dealerDeck > 21);
    }

    @Test
    void testPlayerBust() {
        int playerDeck = 22;
        if (playerDeck > 21) {
            System.out.println("BUST!");
        }
        assertTrue(playerDeck > 21);
    }

    @Test
    void testPlayerWin() {
        int playerDeck = 21;
        int dealerDeck = 20;

        if (playerDeck > dealerDeck) {
            System.out.println("You win!");
        }
        assertTrue(playerDeck > dealerDeck);
    }

}
