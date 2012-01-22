package com.cricketwoodworks.cribbage.rules.hand;

import java.util.Arrays;
import java.util.List;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.cribbage.CribbageUtils;
import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

public class Nobs implements HandScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        Card cut = hand.getCut();
        for (Card card : hand.getCards()) {
            if (card.getFace().equals(Face.JACK) && card.getSuit().equals(cut.getSuit())) {
                return Arrays.asList(new Score(1, "Nobs", card, cut));
            }
        }
        
        return CribbageUtils.EMPTY_SCORE_LIST;
    }
}
