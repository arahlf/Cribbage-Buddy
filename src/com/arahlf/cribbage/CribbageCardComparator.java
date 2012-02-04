package com.arahlf.cribbage;

import static com.arahlf.cribbage.CribbageUtils.getSuitOrder;

import java.util.Comparator;

import com.arahlf.cribbage.model.Card;

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
        int difference = lhs.getFace().getOrdinal() - rhs.getFace().getOrdinal();
        
        if (difference != 0) {
            return difference;
        }
        
        return getSuitOrder(lhs.getSuit()) - getSuitOrder(rhs.getSuit());
    }
}
