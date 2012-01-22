package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.Cards.*;

import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;


public class TU_FifteenCount extends AbstractRuleTestCase {
    
    public void testNoFifteens() {
        Hand hand = new Hand(ACE_OF_CLUBS, SEVEN_OF_SPADES, NINE_OF_DIAMONDS, JACK_OF_CLUBS, KING_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    public void testSingleFifteen() {
        Hand hand = new Hand(EIGHT_OF_DIAMONDS, SEVEN_OF_HEARTS, NINE_OF_DIAMONDS, JACK_OF_CLUBS, KING_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Fifteen for 2", 2);
    }
    
    public void testTwoFifteens() {
        Hand hand = new Hand(EIGHT_OF_DIAMONDS, SEVEN_OF_HEARTS, EIGHT_OF_HEARTS, JACK_OF_CLUBS, KING_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(2, scores.size());
        assertScore(scores.get(0), 2, "Fifteen for 2", 2);
    }
    
    private HandScoringRule _rule = new FifteenCount();
}
