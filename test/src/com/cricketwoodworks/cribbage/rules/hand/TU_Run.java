package com.cricketwoodworks.cribbage.rules.hand;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class TU_Run extends TestCase {
    
    public void testNoRun() {
        Card cut = new Card(Face.TEN, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMOND));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUB));
        _hand.addCard(new Card(Face.SIX, Suit.SPADE));
        _hand.addCard(new Card(Face.KING, Suit.HEART));
        
        assertEquals(0, _rule.scoreHand(_hand, null));
    }
    
    public void testTwoCardRun() {
        Card cut = new Card(Face.EIGHT, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMOND));
        _hand.addCard(new Card(Face.KING, Suit.CLUB));
        _hand.addCard(new Card(Face.THREE, Suit.SPADE));
        _hand.addCard(new Card(Face.JACK, Suit.HEART));
        
        assertEquals(0, _rule.scoreHand(_hand, null));
    }
    
    public void testThreeCardRun() {
        Card cut = new Card(Face.TEN, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMOND));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUB));
        _hand.addCard(new Card(Face.THREE, Suit.SPADE));
        _hand.addCard(new Card(Face.SIX, Suit.HEART));
        
        assertEquals(3, _rule.scoreHand(_hand, null));
    }
    
    public void testFourCardRun() {
        Card cut = new Card(Face.TEN, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMOND));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUB));
        _hand.addCard(new Card(Face.THREE, Suit.SPADE));
        _hand.addCard(new Card(Face.FIVE, Suit.HEART));
        
        assertEquals(4, _rule.scoreHand(_hand, null));
    }
    
    public void testFiveCardRun() {
        Card cut = new Card(Face.FIVE, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.DIAMOND));
        _hand.addCard(new Card(Face.FOUR, Suit.CLUB));
        _hand.addCard(new Card(Face.THREE, Suit.SPADE));
        _hand.addCard(new Card(Face.SIX, Suit.HEART));
        
        assertEquals(5, _rule.scoreHand(_hand, null));
    }
    
    private Hand _hand = new Hand();
    private HandScoringRule _rule = new Run();
}
