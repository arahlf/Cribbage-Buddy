package com.cricketwoodworks.cribbage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.cricketwoodworks.Suit;

/**
 * Utility class used to help compare and score cards.
 * 
 * @author arahlf
 */
public class CribbageUtils {
    
    public static int getSuitOrder(Suit suit) {
        switch (suit) {
            case CLUBS:
                return 1;
            case DIAMONDS:
                return 2;
            case HEARTS:
                return 3;
            case SPADES:
                return 4;
            default:
                throw new IllegalArgumentException("Invalid suit: " + suit);
        }
    }
    
    public static final List<Score> EMPTY_SCORE_LIST = Collections.unmodifiableList(new ArrayList<Score>());
    
    private CribbageUtils() {
    }
}
