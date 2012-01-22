package com.cricketwoodworks.cribbage.hands;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.cribbage.CribbageCardComparator;

public abstract class AbstractHand {
    
    public List<Card> getCards() {
        return new ArrayList<Card>(_cards);
    }
    
    protected void addCard(Card card) {
        if (card == null) {
            throw new NullPointerException("Card cannot be null");
        }
        
        _cards.add(card);
    }
    
    protected void addCards(Card... cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }
    
    private static final Comparator<Card> CRIBBAGE_CARD_COMPARATOR = new CribbageCardComparator();
    
    private final TreeSet<Card> _cards = new TreeSet<Card>(CRIBBAGE_CARD_COMPARATOR);
}
