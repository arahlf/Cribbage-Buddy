package com.arahlf.cribbage;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.arahlf.cribbage.model.Card;

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
    
    public static int addCards(Collection<Card> cards) {
        int sum = 0;
        
        for (Card card : cards) {
            sum += card.getRank().getValue();
        }
        
        return sum;
    }
    
    public static int getTotalPoints(List<Score> scores) {
        int count = 0;
        
        for (Score score : scores) {
            count += score.getPoints();
        }
        
        return count;
    }
    
    public static final Comparator<Card> CRIBBAGE_CARD_COMPARATOR = new CribbageCardComparator();
    
    public static final List<Score> EMPTY_SCORE_LIST = Collections.unmodifiableList(new ArrayList<Score>());
    
    private CribbageUtils() {
    }
}
