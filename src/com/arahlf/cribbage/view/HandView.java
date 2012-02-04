package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;

public class HandView implements Renderable {
    
    public HandView(Hand hand) {
        _hand = hand;
        
        for (Card card : _hand.getCards()) {
            _cardViews.add(new CardView(card));
        }
    }
    
    @Override
    public void render(int x, int y, Canvas canvas, Paint paint) {
        for (int i = 0; i < _cardViews.size(); i++) {
            _cardViews.get(i).render(x + CardView.WIDTH / 2 * i, y, canvas, paint);
        }
    }
    
    private final Hand _hand;
    private final List<CardView> _cardViews = new ArrayList<CardView>();
}
