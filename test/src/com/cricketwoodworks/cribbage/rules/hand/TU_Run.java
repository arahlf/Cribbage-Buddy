package com.cricketwoodworks.cribbage.rules.hand;

import static com.cricketwoodworks.cribbage.Cards.*;

import java.util.List;

import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

public class TU_Run extends AbstractRuleTestCase {
    
    public void testNoRun() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, TWO_OF_DIAMONDS, FOUR_OF_CLUBS, SIX_OF_SPADES, KING_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    public void testTwoCardRun() {
        Hand hand = new Hand(EIGHT_OF_DIAMONDS, TWO_OF_DIAMONDS, KING_OF_CLUBS, THREE_OF_SPADES, JACK_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    public void testThreeCardRun() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, TWO_OF_DIAMONDS, FOUR_OF_CLUBS, THREE_OF_SPADES, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 3, "Run of three for 3", 3);
    }
    
    public void testFourCardRun() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, TWO_OF_DIAMONDS, FOUR_OF_CLUBS, THREE_OF_SPADES, FIVE_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 4, "Run of four for 4", 4);
    }
    
    public void testFiveCardRun() {
        Hand hand = new Hand(FIVE_OF_DIAMONDS, TWO_OF_DIAMONDS, FOUR_OF_CLUBS, THREE_OF_SPADES, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 5, "Run of five for 5", 5);
    }
    
    public void testDoubleRun() {
        Hand hand = new Hand(FIVE_OF_DIAMONDS, TWO_OF_DIAMONDS, FIVE_OF_CLUBS, FOUR_OF_SPADES, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Double run for 6", 4);
    }
    
    public void testDoubleDoubleRun() {
        Hand hand = new Hand(FIVE_OF_DIAMONDS, FOUR_OF_DIAMONDS, FIVE_OF_CLUBS, FOUR_OF_SPADES, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Double run for 6", 4);
    }
    
    public void testTripleRun() {
        Hand hand = new Hand(TEN_OF_HEARTS, JACK_OF_SPADES, JACK_OF_HEARTS, JACK_OF_CLUBS, QUEEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 9, "Triple run for 9", 5);
    }
    
    private HandScoringRule _rule = new Run();
}
