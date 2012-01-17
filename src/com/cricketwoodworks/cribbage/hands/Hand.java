package com.cricketwoodworks.cribbage.hands;

import java.util.List;

import com.cricketwoodworks.Card;

public class Hand extends AbstractHand {
    
    public Hand(Card cut, Card... cards) {
        if (cards.length != 4) {
            throw new IllegalArgumentException("Hand must have exactly 4 cards.");
        }
        
        addCard(cut);
        addCards(cards);
        
        _cut = cut;
    }
    
    public List<Card> getCardsWithoutCut() {
        List<Card> cards = getCards();
        cards.remove(_cut);
        
        return cards;
    }
    
    public Card getCut() {
        return _cut;
    }
    
    private final Card _cut;
}
