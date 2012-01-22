package com.cricketwoodworks.cribbage.rules.hand;

import java.util.ArrayList;
import java.util.Collections;
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
            List<Card> group = entry.getValue();
            
            switch (group.size()) {
                case 1:
                    continue;
                case 2:
                    scores.add(new Score(2, "Two of a kind", group));
                    break;
                case 3:
                    scores.add(new Score(6, "Three of a kind", group));
                    break;
                case 4:
                    scores.add(new Score(12, "Four of a kind", group));
                    break;
                default:
                    throw new IllegalArgumentException("Invalid Face group count: " + group.size());
            }
        }
        
        Collections.sort(scores);
        return scores;
    }
}
