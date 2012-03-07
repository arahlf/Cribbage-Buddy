package com.arahlf.cribbage.model;

public class CommonArea {
    
    public CommonArea(Card cut) {
        _cut = cut;
    }
    
    public Card getCutCard() {
        return _cut;
    }
    
    private Card _cut;
}
