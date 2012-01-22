package com.arahlf.cribbage.rules.hand;

import static com.arahlf.cribbage.CribbageUtils.addCards;

import java.util.ArrayList;
import java.util.List;

import com.arahlf.Card;
import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;

public class FifteenCount implements HandScoringRule {
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
}
