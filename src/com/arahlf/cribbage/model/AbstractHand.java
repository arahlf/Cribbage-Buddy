package com.arahlf.cribbage.model;

import static com.arahlf.cribbage.CribbageUtils.CRIBBAGE_CARD_COMPARATOR;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

public abstract class AbstractHand {
    
    public List<Card> getCards() {
        return new ArrayList<Card>(_cards);
    }
    
    public int getCardCount() {
        return _cards.size();
    }
    
    protected void _addCard(Card card) {
        if (card == null) {
            throw new NullPointerException("Card cannot be null.");
        }
        
        if (!_cards.add(card)) {
            throw new IllegalArgumentException("Hand already contains: " + card);
        }
    }
    
    private final TreeSet<Card> _cards = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
}
