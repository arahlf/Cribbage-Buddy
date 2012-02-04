package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.Cards.*;
import static com.arahlf.cribbage.CribbageUtils.getTotalPoints;

import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Hand;

public class TU_CribbageHandScoringRules extends AbstractRuleTestCase {
    
    public void testPerfectHand() {
        Hand hand = new Hand(FIVE_OF_CLUBS, JACK_OF_CLUBS, FIVE_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(10, scores.size());
        assertEquals(29, getTotalPoints(scores));
    }
    
    private HandScoringRule _rule = new CribbagHandScoringRules();
}
