package com.arahlf;

import java.util.Collections;
import java.util.Stack;

public class Deck {
    
    public Deck() {
        for (Face face : Face.values()) {
            for (Suit suit : Suit.values()) {
                _cards.add(new Card(face, suit));
            }
        }
    }
    
    public void shuffle() {
        Collections.shuffle(_cards);
    }
    
    public Card getNextCard() {
        return _cards.pop();
    }
    
    private final Stack<Card> _cards = new Stack<Card>();
}
