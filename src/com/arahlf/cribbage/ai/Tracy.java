package com.arahlf.cribbage.ai;

import java.util.List;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.PlayArea;
import com.arahlf.cribbage.model.PlayStack;

public class Tracy implements Difficulty {
    @Override
    public void chooseHand(PlayArea playArea) {
        List<Card> cards = playArea.getCards();
        
        int size = cards.size();
        int card1 = (int) Math.floor(Math.random() * size);
        int card2 = card1;
        
        while (card1 == card2) {
            card2 = (int) Math.floor(Math.random() * size);
        }
        
        playArea.selectCard(cards.get(card1));
        playArea.selectCard(cards.get(card2));
        
        playArea.removeSelectedCards();
    }

    @Override
    public void playCard(PlayArea playArea, PlayStack playStack) {
        playArea.selectCard(playArea.getCards().get(0));
        playStack.playCard(playArea.removeSelectedCards().get(0));
    }
}
