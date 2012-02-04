package com.arahlf.cribbage.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.arahlf.cribbage.CribbageCardComparator;

public abstract class AbstractHand {
    
    public List<Card> getCards() {
        return new ArrayList<Card>(_cards);
    }
    
    protected void addCard(Card card) {
        if (card == null) {
            throw new NullPointerException("Card cannot be null.");
        }
        
        if (!_cards.add(card)) {
            throw new IllegalArgumentException("Hand already contains: " + card);
        }
    }
    
    private final TreeSet<Card> _cards = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
    
    private static final Comparator<Card> CRIBBAGE_CARD_COMPARATOR = new CribbageCardComparator();
}
