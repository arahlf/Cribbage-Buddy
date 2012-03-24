package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.TestUtils.assertScore;
import static com.arahlf.cribbage.model.Cards.*;
import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

public class TU_Run {
    @Test
    public void testNoRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, FOUR_OF_CLUBS, SIX_OF_SPADES, TEN_OF_DIAMONDS, KING_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    @Test
    public void testTwoCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, EIGHT_OF_DIAMONDS, JACK_OF_HEARTS, KING_OF_CLUBS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(0, scores.size());
    }
    
    @Test
    public void testThreeCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, FOUR_OF_CLUBS, SIX_OF_HEARTS, TEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 3, "Run of three for 3", 3);
    }
    
    @Test
    public void testFourCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, FOUR_OF_CLUBS, FIVE_OF_HEARTS, TEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 4, "Run of four for 4", 4);
    }
    
    @Test
    public void testFiveCardRun() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, THREE_OF_SPADES, FOUR_OF_CLUBS, FIVE_OF_DIAMONDS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 5, "Run of five for 5", 5);
    }
    
    @Test
    public void testDoubleRunThreeCard() {
        Hand hand = new Hand(TWO_OF_DIAMONDS, FOUR_OF_SPADES, FIVE_OF_DIAMONDS, FIVE_OF_CLUBS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 6, "Double run of three for 6", 4);
    }
    
    @Test
    public void testDoubleRunFourCard() {
        Hand hand = new Hand(THREE_OF_DIAMONDS, FOUR_OF_SPADES, FIVE_OF_DIAMONDS, FIVE_OF_CLUBS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 8, "Double run of four for 8", 5);
    }
    
    @Test
    public void testDoubleDoubleRun() {
        Hand hand = new Hand(FOUR_OF_DIAMONDS, FOUR_OF_SPADES, FIVE_OF_DIAMONDS, FIVE_OF_CLUBS, SIX_OF_HEARTS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 12, "Double double run of three for 12", 5);
    }
    
    @Test
    public void testTripleRun() {
        Hand hand = new Hand(TEN_OF_HEARTS, JACK_OF_SPADES, JACK_OF_HEARTS, JACK_OF_CLUBS, QUEEN_OF_DIAMONDS);
        
        List<Score> scores = _rule.scoreHand(hand);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 9, "Triple run of three for 9", 5);
    }
    
    @Test
    public void testThreeCardRunWhilePegging() {
        PlayStack playStack = _createPlayStack(EIGHT_OF_DIAMONDS, TWO_OF_CLUBS, THREE_OF_HEARTS, FOUR_OF_DIAMONDS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 3, "Run of 3 for 3", 3);
    }
    
    @Test
    public void testFourCardRunWhilePegging() {
        PlayStack playStack = _createPlayStack(SIX_OF_CLUBS, EIGHT_OF_DIAMONDS, FIVE_OF_SPADES, SEVEN_OF_HEARTS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 4, "Run of 4 for 4", 4);
    }
    
    @Test
    public void testSevenCardRunWhilePegging() {
        PlayStack playStack = _createPlayStack(THREE_OF_CLUBS, TWO_OF_DIAMONDS, FIVE_OF_HEARTS, ACE_OF_SPADES, FOUR_OF_SPADES, SIX_OF_DIAMONDS, SEVEN_OF_HEARTS);
        
        List<Score> scores = _rule.scorePeg(playStack);
        
        assertEquals(1, scores.size());
        assertScore(scores.get(0), 7, "Run of 7 for 7", 7);
    }
    
    private PlayStack _createPlayStack(Card... cards) {
        PlayStack playStack = new PlayStack();
        
        for (Card card : cards) {
            playStack.playCard(card);
        }
        
        return playStack;
    }
    
    private ScoringRule _rule = new Run();
}
