package com.cricketwoodworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Hand {
    
    public Hand() {
    }
    
    public void addCard(Card card) {
        _cards.add(card);
    }
    
    public void addCards(Card... cards) {
        for (Card card : cards) {
            addCard(card);
        }
    }
    
    public void removeCard(Card card) {
        _cards.remove(card);
    }
    
    public List<Card> getCards() {
        Collections.sort(_cards);
        return _cards;
    }
    
    private final List<Card> _cards = new ArrayList<Card>(); // TODO TreeSet instead
}
