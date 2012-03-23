package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.TestUtils.assertScore;
import static com.arahlf.cribbage.model.Cards.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

public class TU_Multiple {
    @Test
    public void testTwoOfAKind() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, ACE_OF_DIAMONDS, FOUR_OF_CLUBS, FIVE_OF_SPADES, TEN_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Pair for 2", 2);
    }
    
    @Test
    public void testThreeOfAKind() {
        Hand hand = new Hand(TEN_OF_DIAMONDS, ACE_OF_DIAMONDS, FOUR_OF_CLUBS, TEN_OF_SPADES, TEN_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Three of a kind for 6", 3);
    }
    
    @Test
    public void testFourOfAKind() {
        Hand hand = new Hand(FOUR_OF_SPADES, FOUR_OF_HEARTS, FOUR_OF_DIAMONDS, SEVEN_OF_HEARTS, FOUR_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 12, "Four of a kind for 12", 4);
    }
    
    @Test
    public void testMultiplePairs() {
        Hand hand = new Hand(FIVE_OF_CLUBS, EIGHT_OF_DIAMONDS, EIGHT_OF_SPADES, FIVE_OF_HEARTS, EIGHT_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(2, scores.size());
        assertScore(scores.get(0), 2, "Pair for 2", 2);
        assertScore(scores.get(1), 6, "Three of a kind for 6", 3);
    }
    
    @Test
    public void testNoPairPegging() {
        PlayStack playStack = _createPlayStack(ACE_OF_CLUBS, TEN_OF_SPADES, FIVE_OF_DIAMONDS, JACK_OF_CLUBS, FIVE_OF_HEARTS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertTrue(scores.isEmpty());
    }
    
    @Test
    public void testPairPegging() {
        PlayStack playStack = _createPlayStack(FIVE_OF_HEARTS, FIVE_OF_DIAMONDS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 2, "Pair for 2", 2);
    }
    
    @Test
    public void testThreeOfAKindPegging() {
        PlayStack playStack = _createPlayStack(NINE_OF_CLUBS, SIX_OF_HEARTS, SIX_OF_CLUBS, SIX_OF_SPADES);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Three of a kind for 6", 3);
    }
    
    @Test
    public void testFourOfAKindPegging() {
        PlayStack playStack = _createPlayStack(EIGHT_OF_DIAMONDS, TEN_OF_SPADES, TWO_OF_DIAMONDS, TWO_OF_HEARTS, TWO_OF_SPADES, TWO_OF_CLUBS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 12, "Four of a kind for 12", 4);
    }
    
    private PlayStack _createPlayStack(Card... cards) {
        PlayStack playStack = new PlayStack();
        
        for (Card card : cards) {
            playStack.playCard(card);
        }
        
        return playStack;
    }
    
    private ScoringRule _rule = new Multiple();
}
