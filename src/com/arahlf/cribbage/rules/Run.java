package com.arahlf.cribbage.rules;

import static com.arahlf.cribbage.CribbageUtils.EMPTY_SCORE_LIST;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.TreeMap;

import com.arahlf.cribbage.Score;
import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.model.PlayStack;

public class Run implements ScoringRule {
    @Override
    public List<Score> scoreHand(Hand hand) {
        List<Card> cards = hand.getCards();
        TreeMap<Integer, List<Card>> groups = new TreeMap<Integer, List<Card>>();
        
        // store into a map of card order to count of cards with that order
        for (Card card : cards) {
            Integer cardOrder = Integer.valueOf(card.getRank().getOrdinal());
            
            if (!groups.containsKey(Integer.valueOf(cardOrder))) {
                groups.put(cardOrder, new ArrayList<Card>());
            }
            
            groups.get(cardOrder).add(card);
        }
        
        
        Integer[] numbers = groups.keySet().toArray(new Integer[0]);
        
        int lastNumber = numbers[0].intValue();
        int currentStreak = 1, longestStreak = 1;
        int currentStreakStart = numbers[0].intValue(), longestStreakStart = 0;
        
        for (int i = 1; i < numbers.length; i++) {
            int number = numbers[i].intValue();
            
            if (number == lastNumber + 1) {
                currentStreak++;
                
                if (i == numbers.length - 1 && currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestStreakStart = currentStreakStart;
                }
            }
            else {
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestStreakStart = currentStreakStart;
                }
                
                currentStreak = 1;
                currentStreakStart = number;
            }
            
            lastNumber = number;
        }
        
        List<Card> runCards = new ArrayList<Card>();
        
        if (longestStreak < 3) {
            return EMPTY_SCORE_LIST;
        }
        
        boolean tripleRun = false;
        int doubleRunCount = 0;
        
        for (int i = longestStreakStart; i < longestStreakStart + longestStreak; i++) {
            List<Card> groupCards = groups.get(Integer.valueOf(i));
            
            if (groupCards.size() == 3) {
                tripleRun = true;
            }
            else if (groupCards.size() == 2) {
                doubleRunCount++;
            }
            
            for (Card card : groupCards) {
                runCards.add(card);
            }
        }
        
        if (longestStreak == 3) {
            if (doubleRunCount == 1) {
                return Arrays.asList(new Score(6, "Double run of three", runCards));
            }
            
            if (doubleRunCount == 2) {
                return Arrays.asList(new Score(12, "Double double run of three", runCards));
            }
            
            if (tripleRun) {
                return Arrays.asList(new Score(9, "Triple run of three", runCards));
            }
            
            return Arrays.asList(new Score(3, "Run of three", runCards));
        }
        else if (longestStreak == 4) {
            if (doubleRunCount == 1) {
                return Arrays.asList(new Score(8, "Double run of four", runCards));
            }
            
            return Arrays.asList(new Score(4, "Run of four", runCards));
        }
        else if (longestStreak == 5) {
            return Arrays.asList(new Score(5, "Run of five", cards));
        }
        
        return EMPTY_SCORE_LIST;
    }

    @Override
    public List<Score> scorePeg(PlayStack playStack) {
        List<Card> cards = playStack.getCards();
        int size = cards.size();
        
        if (size < 3) {
            return EMPTY_SCORE_LIST;
        }
        
        List<Card> longestRun = null;
        
        for (int i = size - 3; i >= 0; i--) {
            List<Card> subList = cards.subList(i, size);
            
            if (_isRun(subList)) {
                longestRun = subList;
            }
        }
        
        if (longestRun != null) {
            List<Score> scores = new ArrayList<Score>();
            scores.add(new Score(longestRun.size(), "Run of " + longestRun.size(), longestRun));
            
            return scores;
        }
        
        return EMPTY_SCORE_LIST;
    }
    
    public boolean _isRun(List<Card> cards) {
        if (cards.size() < 3) {
            return false;
        }
        
        Collections.sort(cards, new Comparator<Card>() {
            @Override
            public int compare(Card lhs, Card rhs) {
                return lhs.getRank().getOrdinal() - rhs.getRank().getOrdinal();
            }
        });
        
        int lastOrdinal = cards.get(0).getRank().getOrdinal();
        
        for (int i = 1; i < cards.size(); i++) {
            int currentOrdinal = cards.get(i).getRank().getOrdinal();
            
            if (currentOrdinal == lastOrdinal + 1) {
                lastOrdinal = currentOrdinal;
            }
            else {
                return false;
            }
        }
        
        return true;
    }
}
