package com.arahlf.cribbage.rules.hand;

import java.util.ArrayList;
import java.util.List;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

public class CribbagHandScoringRules implements ScoringRule {
    
    public CribbagHandScoringRules() {
        _rules.add(new Flush());
        _rules.add(new Multiple());
        _rules.add(new Nobs());
        _rules.add(new Run());
        _rules.add(new FifteenCount());
    }
    
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Score> scores = new ArrayList<Score>();
        
        for (ScoringRule rule : _rules) {
            scores.addAll(rule.scoreHand(hand));
        }
        
        return scores;
    }
    
    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        List<Score> scores = new ArrayList<Score>();
        
        for (ScoringRule rule : _rules) {
            scores.addAll(rule.scorePeg(playStack));
        }
        
        return scores;
    }
    
    private final List<ScoringRule> _rules = new ArrayList<ScoringRule>();
}
