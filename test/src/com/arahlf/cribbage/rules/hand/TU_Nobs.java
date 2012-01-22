package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.Cards.*;

import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;

public class TU_Nobs extends AbstractRuleTestCase {
    
    public void testNobs() {
        Hand hand = new Hand(FOUR_OF_DIAMONDS, TWO_OF_CLUBS, EIGHT_OF_SPADES, JACK_OF_DIAMONDS, ACE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 1, "Nobs for 1", 2);
    }
    
    public void testWhenJackIsTheCut() {
        Hand hand = new Hand(JACK_OF_DIAMONDS, TWO_OF_CLUBS, EIGHT_OF_SPADES, FOUR_OF_DIAMONDS, ACE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    private HandScoringRule _rule = new Nobs();
}
