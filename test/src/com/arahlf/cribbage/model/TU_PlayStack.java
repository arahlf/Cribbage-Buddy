package com.arahlf.cribbage.model;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class TU_PlayStack {
    @Test
    public void testCannotExceedThirtyOne() {
        assertTrue(_playStack.playCard(Cards.TEN_OF_CLUBS));
        assertTrue(_playStack.playCard(Cards.JACK_OF_CLUBS));
        assertTrue(_playStack.playCard(Cards.QUEEN_OF_CLUBS));
        assertFalse(_playStack.playCard(Cards.KING_OF_CLUBS));
        
        assertEquals(30, _playStack.getPipCount());
    }
    
    
    private final PlayStack _playStack = new PlayStack();
}
