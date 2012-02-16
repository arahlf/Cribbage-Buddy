package com.arahlf.cribbage.model;

public class Player {
    
    public Player(String name) {
        _name = name;
    }
    
    public String getName() {
        return _name;
    }
    
    private final String _name;
}
