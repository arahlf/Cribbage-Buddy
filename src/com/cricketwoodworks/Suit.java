package com.cricketwoodworks;

public enum Suit {
    
    CLUB("Clubs"),
    DIAMOND("Diamonds"),
    HEART("Hearts"),
    SPADE("Spades");
    
    public String getDisplayName() {
        return _displayName;
    }
    
    private Suit(String displayName) {
        _displayName = displayName;
    }
    
    private final String _displayName;
}
