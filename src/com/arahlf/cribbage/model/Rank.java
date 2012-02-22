package com.arahlf.cribbage.model;

public enum Rank {
    
    ACE("Ace", 1, 1),
    TWO("Two", 2, 2),
    THREE("Three", 3, 3),
    FOUR("Four", 4, 4),
    FIVE("Five", 5, 5),
    SIX("Six", 6, 6),
    SEVEN("Seven", 7, 7),
    EIGHT("Eight", 8, 8),
    NINE("Nine", 9, 9),
    TEN("Ten", 10 , 10),
    JACK("Jack", 11, 10),
    QUEEN("Queen", 12, 10),
    KING("King", 13, 10);
    
    public String getDisplayName() {
        return _displayName;
    }
    
    public int getOrdinal() {
        return _ordinal;
    }
    
    public int getPipValue() {
        return _pipValue;
    }
    
    private Rank(String displayName, int ordinal, int pipValue) {
        _displayName = displayName;
        _ordinal = ordinal;
        _pipValue = pipValue;
    }
    
    private final int _ordinal;
    private final int _pipValue;
    private final String _displayName;
}
