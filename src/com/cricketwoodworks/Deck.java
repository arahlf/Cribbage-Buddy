package com.cricketwoodworks;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
    
    private final List<Card> _cards = new ArrayList<Card>();
}
