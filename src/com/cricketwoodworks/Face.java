package com.cricketwoodworks;

public enum Face {
    
    ACE(1, "Ace"),
    TWO(2, "Two"),
    THREE(3, "Three"),
    FOUR(4, "Four"),
    FIVE(5, "Five"),
    SIX(6, "Six"),
    SEVEN(7, "Seven"),
    EIGHT(8, "Eight"),
    NINE(9, "Nine"),
    TEN(10, "Ten"),
    JACK(10, "Jack"),
    QUEEN(10, "Queen"),
    KING(10, "King");
    
    public int getPointValue() {
        return _pointValue;
    }
    
    public String getDisplayName() {
        return _displayName;
    }
    
    private Face(int pointValue, String displayName) {
        _pointValue = pointValue;
        _displayName = displayName;
    }
    
    private final int _pointValue;
    private final String _displayName;
}
