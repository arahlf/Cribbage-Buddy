package com.cricketwoodworks;

public enum Face {
    
    ACE(1, 1, "Ace"),
    TWO(2, 2, "Two"),
    THREE(3, 3, "Three"),
    FOUR(4, 4, "Four"),
    FIVE(5, 5, "Five"),
    SIX(6, 6, "Six"),
    SEVEN(7, 7, "Seven"),
    EIGHT(8, 8, "Eight"),
    NINE(9, 9, "Nine"),
    TEN(10, 10, "Ten"),
    JACK(11, 10, "Jack"),
    QUEEN(12, 10, "Queen"),
    KING(13, 10, "King");
    
    public int getNumber() {
        return _number;
    }
    
    public int getPointValue() {
        return _pointValue;
    }
    
    public String getDisplayName() {
        return _displayName;
    }
    
    private Face(int number, int pointValue, String displayName) {
        _number = number;
        _pointValue = pointValue;
        _displayName = displayName;
    }
    
    private final int _number;
    private final int _pointValue;
    private final String _displayName;
}
