package com.arahlf.cribbage.model;

import static com.arahlf.cribbage.Cards.*;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TU_PlayHand {
    @Test
    public void testTypicalUse() {
        PlayHand hand = new PlayHand();
        
        hand.addCard(FIVE_OF_CLUBS);
        hand.addCard(EIGHT_OF_DIAMONDS);
        hand.addCard(QUEEN_OF_HEARTS);
        hand.addCard(FIVE_OF_SPADES);
        hand.addCard(ACE_OF_CLUBS);
        hand.addCard(NINE_OF_CLUBS);
        
        hand.confirmDealtCards();
        
        hand.selectCard(FIVE_OF_SPADES);
        hand.selectCard(QUEEN_OF_HEARTS);
        
        hand.confirmSelections();
        
        assertEquals(2, hand.getSelectedCardsCount());
        assertEquals(4, hand.getRemainingCardCount());
        
        hand.playCard(ACE_OF_CLUBS);
        hand.playCard(NINE_OF_CLUBS);
        hand.playCard(FIVE_OF_CLUBS);
        hand.playCard(EIGHT_OF_DIAMONDS);
        
        assertEquals(0, hand.getRemainingCardCount());
    }
}
