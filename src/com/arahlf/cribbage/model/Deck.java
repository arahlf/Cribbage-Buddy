package com.arahlf.cribbage.model;

import java.util.Collections;
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
    }
    
    public Card cutCard(int index) {
        return  _cards.remove(index);
    }
    
    public Card dealCard() {
        return _cards.pop();
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
    
    private final Stack<Card> _cards = new Stack<Card>();
}
