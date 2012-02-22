package com.arahlf.cribbage;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Rank;
import com.arahlf.cribbage.model.Suit;

public class TU_Card {
    @Test
    public void testEquals() {
        Card x = new Card(Rank.ACE, Suit.SPADES);
        Card y = new Card(Rank.ACE, Suit.SPADES);
        Card z = new Card(Rank.ACE, Suit.SPADES);
        
        assertFalse(x.equals(null));
        
        // reflexive
        assertTrue(x.equals(x));
        
        // symmetric
        assertTrue(x.equals(y));
        assertTrue(y.equals(x));
        
        // transitive
        assertTrue(z.equals(z));
        assertTrue(x.equals(z));
        
        // consistent
        for (int i = 0; i < 1000; i++) {
            assertTrue(x.equals(y));
        }
    }
    
    @Test
    public void testHashCode() {
        Card x = new Card(Rank.FIVE, Suit.CLUBS);
        Card y = new Card(Rank.FIVE, Suit.CLUBS);
        
        assertTrue(x.hashCode() == y.hashCode());
    }
}
