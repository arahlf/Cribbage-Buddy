package com.cricketwoodworks.cribbage.rules.hand;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class TU_Flush extends TestCase {
    
    public void testFourCardFlush() {
        Card cut = new Card(Face.NINE, Suit.CLUB);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.HEART));
        _hand.addCard(new Card(Face.EIGHT, Suit.HEART));
        _hand.addCard(new Card(Face.KING, Suit.HEART));
        _hand.addCard(new Card(Face.ACE, Suit.HEART));
        
        assertEquals(4, _rule.scoreHand(_hand, cut));
    }
    
    public void testFiveCardFlush() {
        Card cut = new Card(Face.FOUR, Suit.SPADE);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.FIVE, Suit.SPADE));
        _hand.addCard(new Card(Face.SIX, Suit.SPADE));
        _hand.addCard(new Card(Face.SEVEN, Suit.SPADE));
        _hand.addCard(new Card(Face.QUEEN, Suit.SPADE));
        
        assertEquals(5, _rule.scoreHand(_hand, cut));
    }
    
    private Hand _hand = new Hand();
    private HandScoringRule _rule = new Flush();
}
