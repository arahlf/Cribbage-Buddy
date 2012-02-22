package com.arahlf.cribbage.model;

public enum Suit {
    
    CLUBS("Clubs"),
    DIAMONDS("Diamonds"),
    HEARTS("Hearts"),
    SPADES("Spades");
    
    public String getDisplayName() {
        return _displayName;
    }
    
    private Suit(String displayName) {
        _displayName = displayName;
    }
    
    private final String _displayName;
}
