package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.TestUtils.assertScore;
import static com.arahlf.cribbage.model.Cards.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

public class TU_Count {
    @Test
    public void testNoFifteens() {
        Hand hand = new Hand(ACE_OF_CLUBS, SEVEN_OF_SPADES, NINE_OF_DIAMONDS, JACK_OF_CLUBS, KING_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    @Test
    public void testSingleFifteen() {
        Hand hand = new Hand(EIGHT_OF_DIAMONDS, SEVEN_OF_HEARTS, NINE_OF_DIAMONDS, JACK_OF_CLUBS, KING_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Fifteen for 2", 2);
    }
    
    @Test
    public void testTwoFifteens() {
        Hand hand = new Hand(EIGHT_OF_DIAMONDS, SEVEN_OF_HEARTS, EIGHT_OF_HEARTS, JACK_OF_CLUBS, KING_OF_SPADES);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(2, scores.size());
        assertScore(scores.get(0), 2, "Fifteen for 2", 2);
    }
    
    @Test
    public void testThreeFives() {
        Hand hand = new Hand(FIVE_OF_HEARTS, FIVE_OF_DIAMONDS, FIVE_OF_SPADES, EIGHT_OF_DIAMONDS, THREE_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Fifteen for 2", 3);
    }
    
    @Test
    public void testFourFives() {
        Hand hand = new Hand(FIVE_OF_HEARTS, FIVE_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_CLUBS, THREE_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(4, scores.size());
    }
    
    @Test
    public void testPerfectHand() {
        Hand hand = new Hand(FIVE_OF_HEARTS, FIVE_OF_DIAMONDS, FIVE_OF_SPADES, FIVE_OF_CLUBS, JACK_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(8, scores.size());
    }
    
    @Test
    public void testNoScorePegging() {
        PlayStack playStack = new PlayStack();
        playStack.playCard(EIGHT_OF_HEARTS);
        playStack.playCard(JACK_OF_DIAMONDS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(0, scores.size());
    }
    
    @Test
    public void testFifteenCount() {
        PlayStack playStack = new PlayStack();
        playStack.playCard(TEN_OF_CLUBS);
        playStack.playCard(FIVE_OF_DIAMONDS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Fifteen for 2", 2);
    }
    
    @Test
    public void testThirtyOneCount() {
        PlayStack playStack = new PlayStack();
        playStack.playCard(FIVE_OF_CLUBS);
        playStack.playCard(NINE_OF_DIAMONDS);
        playStack.playCard(SEVEN_OF_SPADES);
        playStack.playCard(QUEEN_OF_CLUBS);
        
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Thirty one for 2", 4);
    }
    
    private ScoringRule _rule = new Count();
}
