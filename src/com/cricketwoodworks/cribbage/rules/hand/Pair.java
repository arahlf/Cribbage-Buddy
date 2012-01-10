package com.cricketwoodworks.cribbage.rules.hand;

import java.util.List;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;

public class Pair implements HandScoringRule {
    @Override
    public int scoreHand(Hand hand, Card cut) {
        int score = 0;
        int streak = 1;
        Face lastFace = null;
        
        List<Card> cards = hand.getCards();
        
        for (int i = 0; i < cards.size(); i++) {
            Card card = cards.get(i);
            
            if (lastFace == null) {
                lastFace = card.getFace();
            }
            else {
                if (lastFace.equals(card.getFace())) {
                    streak++;
                    
                    if (i == cards.size() - 1) {
                        score += POINTS[streak];
                    }
                }
                else {
                    score += POINTS[streak];
                    streak = 1;
                    lastFace = card.getFace();
                }
            }
        }
        
        return score;
    }
    
    private static final int[] POINTS = new int[] { 0, 0, 2, 6, 12 };
}
