package com.cricketwoodworks.cribbage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Suit;

/**
 * Utility class used to help compare and score cards.
 * 
 * @author arahlf
 */
public class CribbageUtils {
    
    public static int getCardPoints(Card card) {
        switch (card.getFace()) {
            case ACE:
                return 1;
            case TWO:
                return 2;
            case THREE: 
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
            case JACK:
            case QUEEN:
            case KING:
                return 10;
            default:
                throw new IllegalArgumentException("Invalid card face: " + card);
        }
    }
    
    public static int getCardOrder(Card card) {
        switch (card.getFace()) {
            case ACE:
                return 1;
            case TWO:
                return 2;
            case THREE: 
                return 3;
            case FOUR:
                return 4;
            case FIVE:
                return 5;
            case SIX:
                return 6;
            case SEVEN:
                return 7;
            case EIGHT:
                return 8;
            case NINE:
                return 9;
            case TEN:
                return 10;
            case JACK:
                return 11;
            case QUEEN:
                return 12;
            case KING:
                return 13;
            default:
                throw new IllegalArgumentException("Invalid card face: " + card);
        }
    }
    
    public static int getSuitOrder(Suit suit) {
        switch (suit) {
            case CLUB:
                return 1;
            case DIAMOND:
                return 2;
            case HEART:
                return 3;
            case SPADE:
                return 4;
            default:
                throw new IllegalArgumentException("Invalid suit: " + suit);
        }
    }
    
    public static List<Score> createScoreList(Score... scores) {
        return Arrays.asList(scores);
    }
    
    public static final List<Score> EMPTY_SCORE_LIST = Collections.unmodifiableList(new ArrayList<Score>());
    
    private CribbageUtils() {
    }
}
