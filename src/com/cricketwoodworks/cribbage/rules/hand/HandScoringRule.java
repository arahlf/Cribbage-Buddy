package com.cricketwoodworks.cribbage.rules.hand;

import java.util.List;

import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

/**
 * An interface for rules used to score hands.
 * 
 * @author arahlf
 */
public interface HandScoringRule {
    /**
     * Scores a hand.
     * 
     * @param hand
     * @param cut
     * @return A list of Scores, never null.
     */
    public List<Score> scoreHand(Hand hand);
}
