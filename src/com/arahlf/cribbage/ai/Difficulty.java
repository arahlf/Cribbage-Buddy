package com.arahlf.cribbage.ai;

import com.arahlf.cribbage.model.PlayArea;
import com.arahlf.cribbage.model.PlayStack;

public interface Difficulty {
    
    void chooseHand(PlayArea playArea);
    
    void playCard(PlayArea playArea, PlayStack playStack);
    
}
