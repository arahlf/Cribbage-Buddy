package com.arahlf.cribbage.model;

import com.arahlf.cribbage.model.Rank;
import com.arahlf.cribbage.model.Suit;

public class Card {
    
    public Card(Rank rank, Suit suit) {
        _rank = rank;
        _suit = suit;
    }
    
    public Rank getRank() {
        return _rank;
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
        
        return _rank.equals(card.getRank()) && _suit.equals(card.getSuit());
    }
    
    @Override
    public int hashCode() {
        int result = 17;
        result = 31 * result + _rank.hashCode();
        result = 31 * result + _suit.hashCode();
        
        return result;
    }
    
    @Override
    public String toString() {
        return _rank.getDisplayName() + " of " + _suit.getDisplayName();
    }
    
    private final Rank _rank;
    private final Suit _suit;
}
