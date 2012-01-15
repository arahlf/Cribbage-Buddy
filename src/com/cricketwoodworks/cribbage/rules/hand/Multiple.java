package com.cricketwoodworks.cribbage.rules.hand;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Face;
import com.cricketwoodworks.cribbage.Score;
import com.cricketwoodworks.cribbage.hands.Hand;

public class Multiple implements HandScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Face, List<Card>> groups = new HashMap<Face, List<Card>>();
        
        // map the cards into groups
        for (Card card : cards) {
            if (!groups.containsKey(card.getFace())) {
                groups.put(card.getFace(), new ArrayList<Card>());
            }
            
            groups.get(card.getFace()).add(card);
        }
        
        List<Score> scores = new ArrayList<Score>();
        
        for (Entry<Face, List<Card>> entry : groups.entrySet()) {
            int count = entry.getValue().size();
            
            switch (entry.getValue().size()) {
                case 1:
                    continue;
                case 2:
                    scores.add(new Score(2, "Two of a kind", entry.getValue()));
                case 3:
                    scores.add(new Score(6, "Three of a kind", entry.getValue()));
                case 4:
                    scores.add(new Score(12, "Four of a kind", entry.getValue()));
                default:
                    throw new IllegalArgumentException("Invalid Face group count: " + count);
            }
        }
        
        return scores;
    }
}
