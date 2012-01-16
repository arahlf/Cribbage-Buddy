package com.cricketwoodworks.cribbage.rules.hand;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class TU_Run extends TestCase {
    
    public void testNoRun() {
        Card cut = new Card(Face.TEN, Suit.DIAMONDS);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMONDS));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUBS));
        _hand.addCard(new Card(Face.SIX, Suit.SPADES));
        _hand.addCard(new Card(Face.KING, Suit.HEARTS));
        
        assertEquals(0, _rule.scoreHand(_hand, null));
    }
    
    public void testTwoCardRun() {
        Card cut = new Card(Face.EIGHT, Suit.DIAMONDS);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMONDS));
        _hand.addCard(new Card(Face.KING, Suit.CLUBS));
        _hand.addCard(new Card(Face.THREE, Suit.SPADES));
        _hand.addCard(new Card(Face.JACK, Suit.HEARTS));
        
        assertEquals(0, _rule.scoreHand(_hand, null));
    }
    
    public void testThreeCardRun() {
        Card cut = new Card(Face.TEN, Suit.DIAMONDS);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMONDS));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUBS));
        _hand.addCard(new Card(Face.THREE, Suit.SPADES));
        _hand.addCard(new Card(Face.SIX, Suit.HEARTS));
        
        assertEquals(3, _rule.scoreHand(_hand, null));
    }
    
    public void testFourCardRun() {
        Card cut = new Card(Face.TEN, Suit.DIAMONDS);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMONDS));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUBS));
        _hand.addCard(new Card(Face.THREE, Suit.SPADES));
        _hand.addCard(new Card(Face.FIVE, Suit.HEARTS));
        
        assertEquals(4, _rule.scoreHand(_hand, null));
    }
    
    public void testFiveCardRun() {
        Card cut = new Card(Face.FIVE, Suit.DIAMONDS);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMONDS));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUBS));
        _hand.addCard(new Card(Face.THREE, Suit.SPADES));
        _hand.addCard(new Card(Face.SIX, Suit.HEARTS));
        
        assertEquals(5, _rule.scoreHand(_hand, null));
    }
    
    public void testDoubleRun() {
        Card cut = new Card(Face.FIVE, Suit.DIAMONDS);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMONDS));
        _hand.addCard(new Card(Face.FIVE, Suit.CLUBS));
        _hand.addCard(new Card(Face.FOUR, Suit.SPADES));
        _hand.addCard(new Card(Face.SIX, Suit.HEARTS));
        
        assertEquals(5, _rule.scoreHand(_hand, null));
    }
    
    private Hand _hand = new Hand();
    private HandScoringRule _rule = new Run();
}
