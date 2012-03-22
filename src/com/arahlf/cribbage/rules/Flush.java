package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.CribbageUtils.EMPTY_SCORE_LIST;

import java.util.Arrays;
import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;
import com.arahlf.cribbage.model.Suit;

public class Flush implements ScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Card> cards = hand.getCardsWithoutCut();
        Suit suit = cards.get(0).getSuit();
        
        for (int i = 1; i < cards.size(); i++) {
            if (!cards.get(i).getSuit().equals(suit)) {
                return EMPTY_SCORE_LIST;
            }
        }
        
        if (hand.getCut().getSuit().equals(suit)) {
            return Arrays.asList(new Score(5, "Flush (5 card)", hand.getCards()));
        }
        
        if (!hand.isCrib()) {
            return Arrays.asList(new Score(4, "Flush (4 card)", cards));
        }
        
        return EMPTY_SCORE_LIST;
    }

    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        return EMPTY_SCORE_LIST;
    }
}
