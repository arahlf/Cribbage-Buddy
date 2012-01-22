package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.Cards.*;

import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;

public class TU_Multiple extends AbstractRuleTestCase {
    
    public void testTwoOfAKind() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, ACE_OF_DIAMONDS, FOUR_OF_CLUBS, FIVE_OF_SPADES, TEN_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Two of a kind for 2", 2);
    }
    
    public void testThreeOfAKind() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, ACE_OF_DIAMONDS, FOUR_OF_CLUBS, TEN_OF_SPADES, TEN_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Three of a kind for 6", 3);
    }
    
    public void testFourOfAKind() {
        Hand hand = new Hand(FOUR_OF_SPADES, FOUR_OF_HEARTS, FOUR_OF_DIAMONDS, SEVEN_OF_HEARTS, FOUR_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 12, "Four of a kind for 12", 4);
    }
    
    public void testMultiplePairs() {
        Hand hand = new Hand(FIVE_OF_CLUBS, EIGHT_OF_DIAMONDS, EIGHT_OF_SPADES, FIVE_OF_HEARTS, EIGHT_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(2, scores.size());
        assertScore(scores.get(0), 2, "Two of a kind for 2", 2);
        assertScore(scores.get(1), 6, "Three of a kind for 6", 3);
    }
    
    private HandScoringRule _rule = new Multiple();
}
