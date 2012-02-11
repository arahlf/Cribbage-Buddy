package com.arahlf.cribbage;

import static com.arahlf.cribbage.Cards.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;

public class TU_Hand {
    @Test(expected = NullPointerException.class)
    public void testHandShouldNotAllowNullCard() {
            new Hand(null, TWO_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_HEARTS, QUEEN_OF_CLUBS);
    }
    
    @Test(expected = IllegalArgumentException.class)
    public void testHandShouldNotAllowDuplicateCard() {
        new Hand(FIVE_OF_HEARTS, TWO_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_HEARTS, QUEEN_OF_CLUBS);
    }
    
    @Test
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
