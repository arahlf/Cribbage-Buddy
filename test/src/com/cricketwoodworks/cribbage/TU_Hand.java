package com.cricketwoodworks.cribbage;

import static com.cricketwoodworks.cribbage.Cards.*;

import java.util.List;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.cribbage.hands.Hand;

public class TU_Hand extends TestCase {
    
    public void testHandContainsOnlyFiveCards() {
        try {
            new Hand(FIVE_OF_CLUBS, SIX_OF_SPADES, TEN_OF_HEARTS, EIGHT_OF_DIAMONDS, NINE_OF_HEARTS, ACE_OF_CLUBS);
            fail("Hand should only allow 5 cards.");
        }
        catch (IllegalArgumentException expected) {
        }
    }
    
    public void testCardsAreSorted() {
        Hand hand = new Hand(KING_OF_SPADES, TWO_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_HEARTS, QUEEN_OF_CLUBS);
        
        List<Card> cards = hand.getCards();
        
        assertEquals(TWO_OF_DIAMONDS, cards.get(0));
        assertEquals(FIVE_OF_HEARTS, cards.get(1));
        assertEquals(FIVE_OF_SPADES, cards.get(2));
        assertEquals(QUEEN_OF_CLUBS, cards.get(3));
        assertEquals(KING_OF_SPADES, cards.get(4));
    }
    
}
