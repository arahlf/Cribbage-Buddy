package com.cricketwoodworks.cribbage.rules.hand;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Hand;

public interface HandScoringRule {
    
    public int scoreHand(Hand hand, Card cut);
    
}
