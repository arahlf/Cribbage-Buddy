package com.arahlf.cribbage.hands;

import java.util.List;

import com.arahlf.Card;

public class Hand extends AbstractHand {
    
    public Hand(Card cut, Card card1, Card card2, Card card3, Card card4) {
        
        addCard(cut);
        addCard(card1);
        addCard(card2);
        addCard(card3);
        addCard(card4);
        
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
