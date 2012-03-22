package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.CribbageUtils.EMPTY_SCORE_LIST;

import java.util.Arrays;
import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;
import com.arahlf.cribbage.model.Rank;

public class Nobs implements ScoringRule {
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

    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        return EMPTY_SCORE_LIST;
    }
}
