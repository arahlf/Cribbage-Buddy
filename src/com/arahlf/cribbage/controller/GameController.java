package com.arahlf.cribbage.controller;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Deck;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.view.CardSelectionListener;
import com.arahlf.cribbage.view.CardView;
import com.arahlf.cribbage.view.GameView;
import com.arahlf.cribbage.view.ShuffledDeckView;
import com.arahlf.cribbage.view.ZIndexManager;

public class GameController implements CardSelectionListener {
    
    public GameController(Game game) {
        _game = game;
        _gameView = new GameView(game);
        _manager.addTappable(_view);
    }
    
    public void renderViews(Canvas canvas, Paint paint) {
        _gameView.render(canvas, paint);
        _view.render(canvas, paint);
        
        if (_selectedCardView != null) {
            _selectedCardView.render(canvas, paint);
        }
    }
    
    @Override
    public void onCardSelected(Card card) {
        _selectedCardView = new CardView(25, 50 + CardView.HEIGHT, card);
    }
    
    public boolean handleTapEvent(int x, int y) {
        return _manager.notifyTapEvent(x, y);
    }
    
    private CardView _selectedCardView; 
    private final Game _game;
    private final GameView _gameView;
    private final ShuffledDeckView _view = new ShuffledDeckView(25, 25, new Deck(), this);
    private final ZIndexManager _manager = new ZIndexManager();
}
