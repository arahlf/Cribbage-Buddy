package com.arahlf.cribbage.model;

public class CommonArea {
    
    public CommonArea(Card cut) {
        _cut = cut;
    }
    
    public Card getCutCard() {
        return _cut;
    }
    
    public PlayStack getPlayStack() {
        return _playStack;
    }
    
    private final Card _cut;
    private final PlayStack _playStack = new PlayStack();
}
