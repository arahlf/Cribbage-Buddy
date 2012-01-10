package com.cricketwoodworks.cribbage.rules.hand;

import junit.framework.TestCase;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class TU_Nobs extends TestCase {
    
    public void testNobs() {
        Card cut = new Card(Face.FOUR, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.CLUB));
        _hand.addCard(new Card(Face.EIGHT, Suit.SPADE));
        _hand.addCard(new Card(Face.JACK, Suit.DIAMOND));
        _hand.addCard(new Card(Face.ACE, Suit.HEART));
        
        assertEquals(1, _rule.scoreHand(_hand, cut));
    }
    
    public void testWhenJackIsTheCut() {
        Card cut = new Card(Face.JACK, Suit.DIAMOND);
        
        _hand.addCard(cut);
        _hand.addCard(new Card(Face.TWO, Suit.CLUB));
        _hand.addCard(new Card(Face.EIGHT, Suit.SPADE));
        _hand.addCard(new Card(Face.FOUR, Suit.DIAMOND));
        _hand.addCard(new Card(Face.ACE, Suit.HEART));
        
        assertEquals(0, _rule.scoreHand(_hand, cut));
    }
    
    private Hand _hand = new Hand();
    private HandScoringRule _rule = new Nobs();
}
