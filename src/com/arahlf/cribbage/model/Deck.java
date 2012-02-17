package com.arahlf.cribbage.model;

import java.util.Collections;
import java.util.Stack;

import com.arahlf.cribbage.Rank;
import com.arahlf.cribbage.Suit;

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
    
    public Card deal() {
        return _cards.pop();
    }
    
    public Card getCard(int index) {
        return _cards.get(index);
    }
    
    public int getRemainingCardCount() {
        return _cards.size();
    }
    
    private final Stack<Card> _cards = new Stack<Card>();
}
