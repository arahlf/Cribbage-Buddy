package com.cricketwoodworks.cribbage;

import static com.cricketwoodworks.cribbage.CribbageUtils.getCardOrder;
import static com.cricketwoodworks.cribbage.CribbageUtils.getSuitOrder;

import java.util.Comparator;

import com.cricketwoodworks.Card;

/**
 * A Comparator implementation used to sort Cards in Cribbage.  The primary
 * comparison is done on the Card's order (derived from its face), and in the
 * case of two Cards with the same face, the Suit is used to break the tie.
 * 
 * @author arahlf
 */
public class CribbageCardComparator implements Comparator<Card> {
    @Override
    public int compare(Card lhs, Card rhs) {
        int difference = getCardOrder(lhs) - getCardOrder(rhs);
        
        if (difference != 0) {
            return difference;
        }
        
        return getSuitOrder(lhs.getSuit()) - getSuitOrder(rhs.getSuit());
    }
}