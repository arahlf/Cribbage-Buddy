package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Hand;

public class HandView implements CardTapListener, Renderable {
    
    public HandView(int x, int y, Hand hand, ZIndexManager manager) {
        List<Card> cards = hand.getCards();
        
        for (int i = 0; i < cards.size(); i++) {
            CardView cardView = new CardView(x + CardView.WIDTH / 2 * i, y, cards.get(i));
            
            manager.addTappable(cardView);
            cardView.setTapListener(this);
            _cardViews.add(cardView);
        }
    }
    
    @Override
    public void notify(CardView cardView) {
        cardView.setY(cardView.getY() - 25);
    }
    
    @Override
    public void render(Canvas canvas, Paint paint) {
        for (CardView cardView : _cardViews) {
            cardView.render(canvas, paint);
        }
    }
    
    private final List<CardView> _cardViews = new ArrayList<CardView>();
}
