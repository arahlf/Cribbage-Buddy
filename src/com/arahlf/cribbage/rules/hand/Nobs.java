package com.arahlf.cribbage.rules.hand;

import java.util.Arrays;
import java.util.List;

import com.arahlf.Card;
import com.arahlf.Face;
import com.arahlf.cribbage.CribbageUtils;
import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;

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
