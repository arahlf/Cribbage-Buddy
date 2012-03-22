package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.CribbageUtils.EMPTY_SCORE_LIST;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;
import com.arahlf.cribbage.model.Rank;

public class Multiple implements ScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Card> cards = hand.getCards();
        Map<Rank, List<Card>> groups = new HashMap<Rank, List<Card>>();
        
        // map the cards into groups
        for (Card card : cards) {
            if (!groups.containsKey(card.getRank())) {
                groups.put(card.getRank(), new ArrayList<Card>());
            }
            
            groups.get(card.getRank()).add(card);
        }
        
        List<Score> scores = new ArrayList<Score>();
        
        for (Entry<Rank, List<Card>> entry : groups.entrySet()) {
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
                    throw new IllegalArgumentException("Invalid Rank group count: " + group.size());
            }
        }
        
        Collections.sort(scores);
        return scores;
    }

    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        return EMPTY_SCORE_LIST;
    }
}
