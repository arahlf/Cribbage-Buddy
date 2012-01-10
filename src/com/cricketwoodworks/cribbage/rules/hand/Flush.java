package com.cricketwoodworks.cribbage.rules.hand;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Hand;
import com.cricketwoodworks.Suit;

public class Flush implements HandScoringRule {
    @Override
    public int scoreHand(Hand hand, Card cut) {
        Suit suit = null;
        
        for (Card card : hand.getCards()) {
            if (card.equals(cut)) {
                continue;
            }
            else if (suit == null) {
                suit = card.getSuit();
            }
            else if (!card.getSuit().equals(suit)) {
                return 0;
            }
        }
        
        return cut.getSuit().equals(suit) ? 5 : 4;
    }
}
