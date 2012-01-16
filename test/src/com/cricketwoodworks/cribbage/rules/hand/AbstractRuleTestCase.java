package com.cricketwoodworks.cribbage.rules.hand;

import junit.framework.TestCase;

import com.cricketwoodworks.cribbage.Score;

public class AbstractRuleTestCase extends TestCase {
    
    public static void assertScore(Score score, int points, String toString, int cardCount) {
        assertEquals(points, score.getPoints());
        assertEquals(toString, score.toString());
        assertEquals(cardCount, score.getCards().size());
    }
    
}
