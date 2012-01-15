package com.cricketwoodworks;

public enum Face {
    
    ACE("Ace"),
    TWO("Two"),
    THREE("Three"),
    FOUR("Four"),
    FIVE("Five"),
    SIX("Six"),
    SEVEN("Seven"),
    EIGHT("Eight"),
    NINE("Nine"),
    TEN("Ten"),
    JACK("Jack"),
    QUEEN("Queen"),
    KING("King");
    
    public String getDisplayName() {
        return _displayName;
    }
    
    private Face(String displayName) {
        _displayName = displayName;
    }
    
    private final String _displayName;
}
