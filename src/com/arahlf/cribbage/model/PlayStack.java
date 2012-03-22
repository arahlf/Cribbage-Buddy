package com.arahlf.cribbage.model;

import java.util.ArrayList;
import java.util.List;

public class PlayStack {
    
    public boolean playCard(Card card) {
        
        if (getPipCount() + card.getRank().getPipValue() > 31) {
            return false;
        }
        
        _cards.add(card);
        
        _notifyListeners();
        
        return true;
    }
    
    public int getPipCount() {
        int total = 0;
        
        for (Card card : _cards) {
            total += card.getRank().getPipValue();
        }
        
        return total;
    }
    
    public List<Card> getCards() {
        return new ArrayList<Card>(_cards);
    }
    
    public void clear() {
        _cards.clear();
    }
    
    public void addListener(PlayStackListener listener) {
        _listeners.add(listener);
    }
    
    private void _notifyListeners() {
        for (PlayStackListener listener : _listeners) {
            listener.onPlayStackUpdate(this);
        }
    }
    
    public final List<Card> _cards = new ArrayList<Card>();
    public final List<PlayStackListener> _listeners = new ArrayList<PlayStackListener>();
    
    
    public static interface PlayStackListener {
        /**
         * Fired when the PlayStack is updated.
         * @param playStack
         */
        void onPlayStackUpdate(PlayStack playStack);
    }
}

