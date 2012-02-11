package com.arahlf.cribbage;

import junit.framework.TestCase;

import com.arahlf.cribbage.model.Deck;

public class TU_Deck extends TestCase {
    
    public void testRemovingCards() {
        Deck deck = new Deck();
        
        assertEquals(52, deck.getRemainingCardCount());
        
        deck.deal();
        
        assertEquals(51, deck.getRemainingCardCount());
        
        deck.deal();
        deck.deal();
        deck.deal();
        
        assertEquals(48, deck.getRemainingCardCount());
    }
    
}
