package com.cricketwoodworks;

public class Card implements Comparable<Card> {
    
    public Card(Face face, Suit suit) {
        _face = face;
        _suit = suit;
    }
    
    public Face getFace() {
        return _face;
    }
    
    public Suit getSuit() {
        return _suit;
    }
    
    @Override
    public int compareTo(Card other) {
        return _face.getNumber() - other.getFace().getNumber();
    }
    
    @Override
    public String toString() {
        return _face.getDisplayName() + " of " + _suit.getDisplayName();
    }
    
    private final Face _face;
    private final Suit _suit;
}
