package com.cricketwoodworks.cribbage.rules.hand;

import java.util.List;

import com.cricketwoodworks.Card;
import com.cricketwoodworks.Hand;

public class Run implements HandScoringRule {
    @Override
    public int scoreHand(Hand hand, Card cut) {
        int currentStreak = 0, longestStreak = 0, lastNumber = 0;
        
        List<Card> cards = hand.getCards();
        
        for (int i = 0; i < cards.size(); i++) {
            int number = cards.get(i).getFace().getNumber();
            
            if (i == 0) {
                lastNumber = number;
                currentStreak = 1;
            }
            else {
                if (number == lastNumber + 1) {
                    currentStreak++;
                    
                    if (i == cards.size() - 1 && currentStreak > longestStreak) {
                        longestStreak = currentStreak;
                    }
                }
                else {
                    if (currentStreak > longestStreak) {
                        longestStreak = currentStreak;
                    }
                    
                    currentStreak = 1;
                }
                
                lastNumber = number;
            }
        }
        
        return longestStreak >= 3 ? longestStreak : 0;
    }
}
