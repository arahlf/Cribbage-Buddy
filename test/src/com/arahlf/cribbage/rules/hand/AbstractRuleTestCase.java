package com.arahlf.cribbage.rules.hand;

import junit.framework.TestCase;

import com.arahlf.cribbage.Score;

public class AbstractRuleTestCase extends TestCase {
    
    public static void assertScore(Score score, int points, String toString, int cardCount) {
        assertEquals(points, score.getPoints());
        assertEquals(toString, score.toString());
        assertEquals(cardCount, score.getCards().size());
    }
    
    public void testNothing() { // until JUnit 4 conversion...
    }
    
}
