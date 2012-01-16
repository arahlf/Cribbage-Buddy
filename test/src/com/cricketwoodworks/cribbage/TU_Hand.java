package com.cricketwoodworks.cribbage;

import java.util.List;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class TU_Hand extends TestCase {
    
    public void testHandValidation() {
        _hand.addCard(new Card(Face.FIVE, Suit.SPADES));
        
        try {
            _hand.addCard(new Card(Face.FIVE, Suit.SPADES));
            fail("Should not have been able to add a duplicate card.");
        }
        catch (IllegalArgumentException expected) {
        }
    }
    
    public void testSorting() {
        Card queen = new Card(Face.QUEEN, Suit.CLUBS);
        Card ace = new Card(Face.ACE, Suit.CLUBS);
        Card five = new Card(Face.FIVE, Suit.CLUBS);
        Card ten = new Card(Face.TEN, Suit.CLUBS);
        Card three = new Card(Face.THREE, Suit.CLUBS);
        
        _hand.addCards(ten, ace, five, three);
        _hand.addCard(queen);
        
        List<Card> cards = _hand.getCards();
        
        assertEquals(ace, cards.get(0));
        assertEquals(three, cards.get(1));
        assertEquals(five, cards.get(2));
        assertEquals(ten, cards.get(3));
        assertEquals(queen, cards.get(4));
    }
    
    private final Hand _hand = new Hand();
}
