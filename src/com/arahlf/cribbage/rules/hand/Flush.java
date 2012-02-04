package com.arahlf.cribbage.rules.hand;

import java.util.Arrays;
import java.util.List;

import com.arahlf.cribbage.CribbageUtils;
import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.Suit;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;

public class Flush implements HandScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Card> cards = hand.getCardsWithoutCut();
        Suit suit = cards.get(0).getSuit();
        
        for (int i = 1; i < cards.size(); i++) {
            if (!cards.get(i).getSuit().equals(suit)) {
                return CribbageUtils.EMPTY_SCORE_LIST;
            }
        }
        
        if (hand.getCut().getSuit().equals(suit)) {
            return Arrays.asList(new Score(5, "Flush (5 card)", hand.getCards()));
        }
        
        return Arrays.asList(new Score(4, "Flush (4 card)", cards));
    }
}
