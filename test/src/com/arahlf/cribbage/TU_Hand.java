package com.arahlf.cribbage;

import static com.arahlf.cribbage.Cards.*;

import java.util.List;

import junit.framework.TestCase;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;

public class TU_Hand extends TestCase {
    
    public void testHandValidations() {
        try {
            new Hand(null, TWO_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_HEARTS, QUEEN_OF_CLUBS);
            fail("Hand should not have allowed a null card.");
        }
        catch (NullPointerException expected) {
        }
        
        try {
            new Hand(FIVE_OF_HEARTS, TWO_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_HEARTS, QUEEN_OF_CLUBS);
            fail("Hand should not have allowed a null card.");
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
