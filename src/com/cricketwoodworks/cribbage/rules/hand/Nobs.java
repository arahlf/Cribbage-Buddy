package com.cricketwoodworks.cribbage.rules.hand;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.Hand;

public class Nobs implements HandScoringRule {
    @Override
    public int scoreHand(Hand hand, Card cut) {
        for (Card card : hand.getCards()) {
            if (!card.equals(cut) && card.getFace().equals(Face.JACK) && card.getSuit().equals(cut.getSuit())) {
                return 1;
            }
        }
        
        return 0;
    }
}
