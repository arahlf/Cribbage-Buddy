package com.arahlf.cribbage.model;

import static com.arahlf.cribbage.CribbageUtils.CRIBBAGE_CARD_COMPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PlayHand {
    
    public boolean addCard(Card card) {
        if (!_state.equals(PlayHandState.DEALING)) {
            throw new IllegalStateException("Can only add cards while in the dealing state.");
        }
        
        return _cards.add(card);
    }
    
    public void confirmDealtCards() {
        if (_state.equals(PlayHandState.DEALING)) {
            _state = PlayHandState.PICKING;
        }
        else {
            throw new IllegalStateException("Can only confirm dealt cards while in the dealing state.");
        }
    }
    
    public void selectCard(Card card) {
        if (!_state.equals(PlayHandState.PICKING)) {
            throw new IllegalStateException("Can only select cards to remove while in the picking state.");
        }
        
        if (_cards.size() - _cardsToRemove.size() > MAX_HAND_SIZE) {
            _cardsToRemove.add(card);
        }
    }
    
    public void deselectCard(Card card) {
        if (!_state.equals(PlayHandState.PICKING)) {
            throw new IllegalStateException("Can only deselect cards to remove while in the picking state.");
        }
        
        _cards.remove(card);
    }
    
    public int getSelectedCardsCount() {
        return _cardsToRemove.size();
    }
    
    public List<Card> getSelectedCards() {
        return new ArrayList<Card>(_cardsToRemove);
    }
    
    public int getRemainingCardCount() {
        return _cards.size();
    }
    
    public List<Card> getRemainingCards() {
        return new ArrayList<Card>(_cards);
    }
    
    public void confirmSelections() {
        if (!_state.equals(PlayHandState.PICKING)) {
            throw new IllegalStateException("Can only confirm cards while in the picking state.");
        }
        
        if (_cards.size() - _cardsToRemove.size() != MAX_HAND_SIZE) {
            throw new IllegalStateException("Must have exactly " + MAX_HAND_SIZE + " cards.");
        }
        
        _state = PlayHandState.PLAYING;
        
        for (Card card : _cardsToRemove) {
            _cards.remove(card);
        }
    }
    
    public boolean playCard(Card card) {
        if (!_state.equals(PlayHandState.PLAYING)) {
            throw new IllegalStateException("Can only play cards while in the playing state.");
        }
        
        return _cards.remove(card);
    }
    
    private PlayHandState _state = PlayHandState.DEALING;
    private final TreeSet<Card> _cards = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
    private final TreeSet<Card> _cardsToRemove = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
    
    private static final int MAX_HAND_SIZE = 4;
}