package com.cricketwoodworks.cribbage.rules.hand;

import static com.cricketwoodworks.cribbage.Cards.*;

import java.util.List;

import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

public class TU_Run extends AbstractRuleTestCase {
    
    public void testNoRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, FOUR_OF_CLUBS, SIX_OF_SPADES, TEN_OF_DIAMONDS, KING_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    public void testTwoCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, EIGHT_OF_DIAMONDS, JACK_OF_HEARTS, KING_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    public void testThreeCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, FOUR_OF_CLUBS, SIX_OF_HEARTS, TEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 3, "Run of three for 3", 3);
    }
    
    public void testFourCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, FOUR_OF_CLUBS, FIVE_OF_HEARTS, TEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 4, "Run of four for 4", 4);
    }
    
    public void testFiveCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, FOUR_OF_CLUBS, FIVE_OF_DIAMONDS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 5, "Run of five for 5", 5);
    }
    
    public void testDoubleRunThreeCard() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, FOUR_OF_SPADES, FIVE_OF_DIAMONDS, FIVE_OF_CLUBS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Double run of three for 6", 4);
    }
    
    public void testDoubleRunFourCard() {
        Hand hand = new Hand(THREE_OF_DIAMONDS, FOUR_OF_SPADES, FIVE_OF_DIAMONDS, FIVE_OF_CLUBS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 8, "Double run of four for 8", 5);
    }
    
    public void testDoubleDoubleRun() {
        Hand hand = new Hand(FOUR_OF_DIAMONDS, FOUR_OF_SPADES, FIVE_OF_DIAMONDS, FIVE_OF_CLUBS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 12, "Double double run of three for 12", 5);
    }
    
    public void testTripleRun() {
        Hand hand = new Hand(TEN_OF_HEARTS, JACK_OF_SPADES, JACK_OF_HEARTS, JACK_OF_CLUBS, QUEEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 9, "Triple run of three for 9", 5);
    }
    
    private HandScoringRule _rule = new Run();
}
