package com.cricketwoodworks.cribbage.rules.hand;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;
import com.cricketwoodworks.cribbage.rules.hand.HandScoringRule;
import com.cricketwoodworks.cribbage.rules.hand.Pair;

public class TU_Pair extends TestCase {
    
    public void testBasicPair() {
        Card cut = new Card(Face.TEN, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.ACE, Suit.DIAMOND));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUB));
        _hand.addCard(new Card(Face.FIVE, Suit.SPADE));
        _hand.addCard(new Card(Face.TEN, Suit.HEART));
        
        assertEquals(2, _rule.scoreHand(_hand, null));
    }
    
    public void testMultiplePairs() {
        Card cut = new Card(Face.FIVE, Suit.CLUB);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.EIGHT, Suit.DIAMOND));
        _hand.addCard(new Card(Face.EIGHT, Suit.SPADE));
        _hand.addCard(new Card(Face.FIVE, Suit.HEART));
        _hand.addCard(new Card(Face.EIGHT, Suit.HEART));
        
        assertEquals(8, _rule.scoreHand(_hand, null));
    }
    
    public void testFourOfAKind() {
        Card cut = new Card(Face.FOUR, Suit.SPADE);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.FOUR, Suit.HEART));
        _hand.addCard(new Card(Face.FOUR, Suit.DIAMOND));
        _hand.addCard(new Card(Face.SEVEN, Suit.HEART));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUB));
        
        assertEquals(12, _rule.scoreHand(_hand, cut));
    }
    
    private Hand _hand = new Hand();
    private HandScoringRule _rule = new Pair();
}
