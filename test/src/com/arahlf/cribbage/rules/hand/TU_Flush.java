package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.Cards.*;

import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;

public class TU_Flush extends AbstractRuleTestCase {
    
    public void testNoFlush() {
        Hand hand = new Hand(FOUR_OF_HEARTS, FIVE_OF_SPADES, SIX_OF_SPADES, SEVEN_OF_SPADES, QUEEN_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    public void testFourCardFlush() {
        Hand hand = new Hand(NINE_OF_CLUBS, TWO_OF_HEARTS, EIGHT_OF_HEARTS, KING_OF_HEARTS, ACE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 4, "Flush (4 card) for 4", 4);
    }
    
    public void testFiveCardFlush() {
        Hand hand = new Hand(FOUR_OF_SPADES, FIVE_OF_SPADES, SIX_OF_SPADES, SEVEN_OF_SPADES, QUEEN_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 5, "Flush (5 card) for 5", 5);
    }
    
    private HandScoringRule _rule = new Flush();
}
