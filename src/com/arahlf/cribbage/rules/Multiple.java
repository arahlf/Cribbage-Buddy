package com.arahlf.cribbage.rules;

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
            
            _addScore(group, scores);
        }
        
        Collections.sort(scores);
        return scores;
    }

    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        List<Card> cards = playStack.getCards();
        
        int size = cards.size();
        List<Card> multiples = new ArrayList<Card>();
        
        if (size > 1) {
            Card lastCard = cards.get(size - 1);
            
            multiples.add(lastCard);
            
            for (int i = size - 2; i >= 0; i--) {
                Card card = cards.get(i);
                
                if (!card.getRank().equals(lastCard.getRank())) {
                    break;
                }
                
                multiples.add(card);
                continue;
            }
        }
        
        return _addScore(multiples, new ArrayList<Score>());
    }
    
    private List<Score> _addScore(List<Card> multiples, List<Score> scores) {
        switch (multiples.size()) {
            case 1:
                break;
            case 2:
                scores.add(new Score(2, "Pair", multiples));
                break;
            case 3:
                scores.add(new Score(6, "Three of a kind", multiples));
                break;
            case 4:
                scores.add(new Score(12, "Four of a kind", multiples));
                break;
            default:
                throw new IllegalArgumentException("Invalid multiple count: " + multiples.size());
        }
        
        return scores;
    }
}
