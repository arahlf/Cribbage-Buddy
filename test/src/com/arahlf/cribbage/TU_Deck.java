package com.arahlf.cribbage;

import junit.framework.TestCase;

import com.arahlf.Deck;

public class TU_Deck extends TestCase {
    
    public void testRemovingCards() {
        Deck deck = new Deck();
        
        assertEquals(52, deck.getRemainingCardCount());
        
        deck.getNextCard();
        
        assertEquals(51, deck.getRemainingCardCount());
        
        deck.getNextCard();
        deck.getNextCard();
        deck.getNextCard();
        
        assertEquals(48, deck.getRemainingCardCount());
    }
    
}
