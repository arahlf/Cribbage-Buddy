package com.cricketwoodworks.cribbage.rules.hand;

import java.util.ArrayList;
import java.util.List;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

public class Pair implements HandScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand, Card cut) {
        
        
        
        return null;
    }
    
    private static final int[] POINTS = new int[] { 0, 0, 2, 6, 12 };
}
