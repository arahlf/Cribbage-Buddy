package com.arahlf.cribbage;

import static org.junit.Assert.assertEquals;

public class TestUtils {
    
    public static void assertScore(Score score, int points, String toString, int cardCount) {
        assertEquals(points, score.getPoints());
        assertEquals(toString, score.toString());
        assertEquals(cardCount, score.getCards().size());
    }
    
}
