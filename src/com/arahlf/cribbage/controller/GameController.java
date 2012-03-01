package com.arahlf.cribbage.controller;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Gravity;
import android.view.View;
import android.widget.Toast;

import com.arahlf.cribbage.model.Card;
import com.arahlf.cribbage.model.Cards;
import com.arahlf.cribbage.model.Deck;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.view.CardSelectionListener;
import com.arahlf.cribbage.view.GameView;
import com.arahlf.cribbage.view.Renderable;
import com.arahlf.cribbage.view.ZIndexManager;

public class GameController implements Renderable, CardSelectionListener {
    
    public GameController(Context context, Game game) {
        _context = context;
        _game = game;
        _gameView = new GameView(game, this);
        
        _manager.addTappable(_gameView);
    }
    
    public void render(View view, Canvas canvas, Paint paint) {
        _gameView.render(view, canvas, paint);
    }
    
    public boolean handleTapEvent(int x, int y) {
        return _manager.notifyTapEvent(x, y);
    }
    
    @Override
    public void onCardSelected(Card card) {
        int index = _game.getDeck().indexOfCard(card);
        
        if (index < 4 || index >= _game.getDeck().getRemainingCardCount() - 4) {
            Toast toast = Toast.makeText(_context, "Must select a card more than 4 cards from the top/bottom of the deck.", Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 110);
            toast.show();
        }
        else {
            Deck deck = _game.getDeck();
            
            card = Cards.JACK_OF_DIAMONDS;
            _game.player1CutCard = card;
            _game.player2CutCard = Cards.JACK_OF_CLUBS;
            
            int count = deck.getRemainingCardCount();
            
//            _game.player1CutCard = card;
//            _game.player2CutCard = deck.cutCard((int) Math.floor(Math.random() * deck.getRemainingCardCount()));
            
            int card1Value = _game.player1CutCard.getRank().getOrdinal();
            int card2Value = _game.player2CutCard.getRank().getOrdinal();
            String text;
            
            // TODO handle case when ranks match
            if (card1Value == card2Value) {
                text = "Tie... try again.";
                _game.player1CutCard = null;
                _game.player2CutCard = null;
            }
            else if (card.getRank().getOrdinal() < _game.player2CutCard.getRank().getOrdinal()) {
                text = "You have won the deal.";
                _game.setDealer(_game.getPlayer1());
                _game.lockCards();
            }
            else {
                text = "You have lost the deal.";
                _game.setDealer(_game.getPlayer2());
                _game.lockCards();
            }
            
            Toast toast = Toast.makeText(_context, text, Toast.LENGTH_SHORT);
            toast.setGravity(Gravity.CENTER, 0, 110);
            toast.show();
        }
    }
    
    private final Context _context;
    private final Game _game;
    private final GameView _gameView;
    private final ZIndexManager _manager = new ZIndexManager();
}
