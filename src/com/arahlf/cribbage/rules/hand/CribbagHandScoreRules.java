package com.arahlf.cribbage.rules.hand;

import java.util.ArrayList;
import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.hands.Hand;

public class CribbagHandScoreRules implements HandScoringRule {
    
    public CribbagHandScoreRules() {
        _rules.add(new Flush());
        _rules.add(new Multiple());
        _rules.add(new Nobs());
        _rules.add(new Run());
        _rules.add(new FifteenCount());
    }
    
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Score> scores = new ArrayList<Score>();
        
        for (HandScoringRule rule : _rules) {
            scores.addAll(rule.scoreHand(hand));
        }
        
        return scores;
    }
    
    private final List<HandScoringRule> _rules = new ArrayList<HandScoringRule>();
}
