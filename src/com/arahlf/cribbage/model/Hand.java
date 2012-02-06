package com.arahlf.cribbage.model;

import java.util.List;

public class Hand extends AbstractHand {
    
    public Hand(Card cut, Card card1, Card card2, Card card3, Card card4) {
        this(false, cut, card1, card2, card3, card4);
    }
    
    public Hand(boolean crib, Card cut, Card card1, Card card2, Card card3, Card card4) {
        _addCard(cut);
        _addCard(card1);
        _addCard(card2);
        _addCard(card3);
        _addCard(card4);
        
        _crib = crib;
        _cut = cut;
    }
    
    public List<Card> getCardsWithoutCut() {
        List<Card> cards = getCards();
        cards.remove(_cut);
        
        return cards;
    }
    
    public boolean isCrib() {
        return _crib;
    }
    
    public Card getCut() {
        return _cut;
    }
    
    private final boolean _crib;
    private final Card _cut;
}
