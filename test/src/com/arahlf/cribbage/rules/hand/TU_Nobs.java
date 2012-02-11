package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.Cards.*;
import static com.arahlf.cribbage.TestUtils.assertScore;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Hand;

public class TU_Nobs {
    @Test
    public void testNobs() {
        Hand hand = new Hand(FOUR_OF_DIAMONDS, TWO_OF_CLUBS, EIGHT_OF_SPADES, JACK_OF_DIAMONDS, ACE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 1, "Nobs for 1", 2);
    }
    
    @Test
    public void testWhenJackIsTheCut() {
        Hand hand = new Hand(JACK_OF_DIAMONDS, TWO_OF_CLUBS, EIGHT_OF_SPADES, FOUR_OF_DIAMONDS, ACE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    private HandScoringRule _rule = new Nobs();
}
