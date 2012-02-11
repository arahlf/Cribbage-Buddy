package com.arahlf.cribbage.model;

import static com.arahlf.cribbage.CribbageUtils.CRIBBAGE_CARD_COMPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public class PlayHand {
    
    public PlayHand() {
        _state = PlayHandState.DEALING;
    }
    
    public void addCard(Card card) {
        _cards.add(card);
    }
    
    public void playCard(Card card) {
        
    }
    
    private Card _cardToRemove1;
    private Card _cardToRemove2;
    private PlayHandState _state;
    private final TreeSet<Card> _cards = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
    private final List<Card> _cardsToRemove = new ArrayList<Card>();
}

enum PlayHandState {
    DEALING,
    PICKING,
    PLAYING
}