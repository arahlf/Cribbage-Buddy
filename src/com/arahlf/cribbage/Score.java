package com.arahlf.cribbage;

import java.util.Arrays;
import java.util.List;

import com.arahlf.Card;

public class Score implements Comparable<Score> {
    
    public Score(int points, String displayName, Card... cards) {
        this(points, displayName, Arrays.asList(cards));
    }
    
    public Score(int points, String displayName, List<Card> cards) {
        _points = points;
        _displayName = displayName;
        _cards = cards;
    }
    
    public int getPoints() {
        return _points;
    }
    
    public List<Card> getCards() {
        return _cards;
    }
    
    @Override
    public int compareTo(Score other) {
        return _points - other.getPoints();
    }
    
    @Override
    public String toString() {
        return _displayName + " for " + _points;
    }
    
    private final int _points;
    private final String _displayName;
    private final List<Card> _cards;
}
