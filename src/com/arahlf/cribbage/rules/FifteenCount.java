package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.CribbageUtils.EMPTY_SCORE_LIST;
import static com.arahlf.cribbage.CribbageUtils.addCards;

import java.util.ArrayList;
import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

public class FifteenCount implements ScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Score> scores = new ArrayList<Score>();
        
        _search(new ArrayList<Card>(), hand.getCards(), scores);
        
        return scores;
    }
    
    private void _search(List<Card> current, List<Card> remaining, List<Score> scores) {
        if (addCards(current) == 15) {
            scores.add(new Score(2, "Fifteen", current));
        }
        
        for (int i = 0; i < remaining.size(); i++) {
            List<Card> newCurrent = new ArrayList<Card>(current);
            List<Card> newRemaining = new ArrayList<Card>(remaining);
            
            newCurrent.add(newRemaining.get(i));
            
            if (i + 1 >= newRemaining.size()) {
                newRemaining.clear();
            }
            else {
                newRemaining = newRemaining.subList(i + 1, newRemaining.size());
            }
            
            _search(newCurrent, newRemaining, scores);
        }
    }

    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        return EMPTY_SCORE_LIST;
    }
}
