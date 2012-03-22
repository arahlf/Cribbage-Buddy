package com.arahlf.cribbage.rules.hand;

import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

/**
 * An interface for rules used to score hands.
 * 
 * @author arahlf
 */
public interface ScoringRule {
    /**
     * Scores a hand.
     * 
     * @param hand
     * @param cut
     * @return A list of Scores, never null.
     */
    public List<Score> scoreHand(Hand hand);
    
    /**
     * Scores a peg.
     * 
     * @param playStack
     * @return A list of Scores, never null.
     */
    public List<Score> scorePeg(PlayStack playStack);
}
