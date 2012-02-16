package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.CribbageUtils.EMPTY_SCORE_LIST;

import java.util.Arrays;
import java.util.List;

import com.arahlf.cribbage.Rank;
import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;

public class Nobs implements HandScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        Card cut = hand.getCut();
        
        if (!cut.getRank().equals(Rank.JACK)) {
            for (Card card : hand.getCards()) {
                if (card.getRank().equals(Rank.JACK) && card.getSuit().equals(cut.getSuit())) {
                    return Arrays.asList(new Score(1, "Nobs", card, cut));
                }
            }
        }
        
        return EMPTY_SCORE_LIST;
    }
}
