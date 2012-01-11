package com.cricketwoodworks.cribbage;

import java.util.List;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class TU_Hand extends TestCase {
    
    public void testSorting() {
        Card queen = new Card(Face.QUEEN, Suit.CLUB);
        Card ace = new Card(Face.ACE, Suit.CLUB);
        Card five = new Card(Face.FIVE, Suit.CLUB);
        Card ten = new Card(Face.TEN, Suit.CLUB);
        Card three = new Card(Face.THREE, Suit.CLUB);
        
        _hand.addCards(queen, ace, five, ten, three);
        
        List<Card> cards = _hand.getCards();
        
        assertEquals(ace, cards.get(0));
        assertEquals(three, cards.get(1));
        assertEquals(five, cards.get(2));
        assertEquals(ten, cards.get(3));
        assertEquals(queen, cards.get(4));
    }
    
    private final Hand _hand = new Hand();
}
