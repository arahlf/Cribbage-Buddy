package com.arahlf.cribbage.view;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Deck;
import com.arahlf.cribbage.model.DeckListener;
import com.arahlf.cribbage.util.Point;

public class ShuffledDeckView implements CardTapListener, Renderable, Tappable, DeckListener {
    
    public ShuffledDeckView(Point location, Deck deck, CardSelectionListener listener) {
        _location = location;
        _deck = deck;
        _listener = listener;
        
        _deck.addListener(this);
        
        deck.shuffle();
        
        for (int i = 0; i < deck.getRemainingCardCount(); i++) {
            CardView cardView = new CardView(_location.getX() + i * CARD_SPACING, _location.getY(), deck.getCard(i));
            cardView.setFaceUp(false);
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
    public void render(View view, Canvas canvas, Paint paint) {
        for (CardView cardView : _cardViews) {
            cardView.render(view, canvas, paint);
        }
    }
    
    @Override
    public void onDeckChanged(Deck deck) {
        
    }
    
    private final Point _location;
    private final Deck _deck;
    private final List<CardView> _cardViews = new ArrayList<CardView>();
    private final ZIndexManager _manager = new ZIndexManager();
    private final CardSelectionListener _listener;
    
    private static final int CARD_SPACING = 7;
}
