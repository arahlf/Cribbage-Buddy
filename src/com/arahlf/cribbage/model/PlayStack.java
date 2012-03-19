package com.arahlf.cribbage.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PlayStack {
    
    public boolean playCard(Card card) {
        
        if (_getTotalPips() + card.getRank().getPipValue() > 31) {
            return false;
        }
        
        _cards.add(card);
        
        return true;
    }
    
    public int getPipCount() {
        return _getTotalPips();
    }
    
    public List<Card> getCards() {
        return Collections.unmodifiableList(_cards);
    }
    
    private int _getTotalPips() {
        int total = 0;
        
        for (Card card : _cards) {
            total += card.getRank().getPipValue();
        }
        
        return total;
    }
    
    public final List<Card> _cards = new ArrayList<Card>();
}
