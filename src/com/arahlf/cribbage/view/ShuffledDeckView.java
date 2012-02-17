package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Deck;

public class ShuffledDeckView implements CardTapListener, Renderable, Tappable {
    
    public ShuffledDeckView(int x, int y, Deck deck, CardSelectionListener listener) {
        _x = x;
        _y = y;
        _deck = deck;
        _listener = listener;
        
        for (int i = 0; i < deck.getRemainingCardCount(); i++) {
            CardView cardView = new CardView(_x + i * 5, _y, null);
            
            cardView.setTapListener(this);
            _cardViews.add(cardView);
            _manager.addTappable(cardView);
        }
    }
    
    @Override
    public boolean handleTap(int x, int y) {
        return _manager.notifyTapEvent(x, y);
    }
    
    @Override
    public void onCardTapped(CardView cardView) {
        Card card = _deck.getCard(_cardViews.indexOf(cardView));
        
        _listener.onCardSelected(card);
    }
    
    @Override
    public void render(Canvas canvas, Paint paint) {
        for (CardView cardView : _cardViews) {
            cardView.render(canvas, paint);
        }
    }
    
    private final int _x;
    private final int _y;
    private final Deck _deck;
    private final List<CardView> _cardViews = new ArrayList<CardView>();
    private final ZIndexManager _manager = new ZIndexManager();
    private final CardSelectionListener _listener;
}
