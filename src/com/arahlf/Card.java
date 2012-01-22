package com.arahlf;

public class Card {
    
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
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Card)) {
            return false;
        }
        
        Card card = (Card) other;
        
        return _face.equals(card.getFace()) && _suit.equals(card.getSuit());
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + _face.hashCode();
        result = 31 * result + _suit.hashCode();
        
        return result;
    }
    
    @Override
    public String toString() {
        return _face.getDisplayName() + " of " + _suit.getDisplayName();
    }
    
    private final Face _face;
    private final Suit _suit;
}
