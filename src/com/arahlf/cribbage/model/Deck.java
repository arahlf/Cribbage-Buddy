package com.arahlf.cribbage.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

public class Deck {
    
    public Deck() {
        for (Rank rank : Rank.values()) {
            for (Suit suit : Suit.values()) {
                _cards.add(new Card(rank, suit));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(_cards);
        
        _notifyListeners();
    }
    
    public Card cutCard(int index) {
        Card card = _cards.remove(index);
        
        _notifyListeners();
        
        return card; 
    }
    
    public Card dealCard() {
        Card card = _cards.pop();
        
        _notifyListeners();
        
        return card;
    }
    
    public Card getCard(int index) {
        return _cards.get(index);
    }
    
    public int getRemainingCardCount() {
        return _cards.size();
    }
    
    public int indexOfCard(Card card) {
        return _cards.indexOf(card);
    }
    
    public void addListener(DeckListener listener) {
        _listeners.add(listener);
    }
    
    public void removeListener(DeckListener listener) {
        _listeners.remove(listener);
    }
    
    private void _notifyListeners() {
        for (DeckListener listener : _listeners) {
            listener.onDeckChanged(this);
        }
    }
    
    private final Stack<Card> _cards = new Stack<Card>();
    private final List<DeckListener> _listeners = new ArrayList<DeckListener>();
}
