package com.cricketwoodworks.cribbage.rules.hand;

import java.util.Arrays;
import java.util.List;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Suit;
import com.cricketwoodworks.cribbage.CribbageUtils;
import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

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
