package com.arahlf.cribbage.view;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.view.View;

import com.arahlf.cribbage.model.Cards;
import com.arahlf.cribbage.model.Deck;
import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.model.GameState;
import com.arahlf.cribbage.model.Hand;
import com.arahlf.cribbage.util.Point;
import com.arahlf.cribbage.util.Rectangle;

public class GameView implements Renderable, Tappable {
    
    public GameView(Game game, CardSelectionListener cardSelectionListener) {
        _game = game;
        
        // hard coding coordinates for now until there's a better mechanism
        _shuffledDeckView = new ShuffledDeckView(new Point(52, 309), new Deck(), cardSelectionListener);
    }
    
    @Override
    public void render(View view, Canvas canvas, Paint paint) {
        int panelHeight = 250;
        
        Rectangle panel1 = new Rectangle(0, 0, view.getWidth(), panelHeight);
        Rectangle panel2 = new Rectangle(0, panelHeight, view.getWidth(), panelHeight);
        Rectangle panel3 = new Rectangle(0, panelHeight * 2, view.getWidth(), panelHeight);
        
        // draw the dividing panels
        //paint.setColor(Color.rgb(30, 115, 30));
        //canvas.drawRect(panel2.asRect(), paint);
        
        // draw player labels
        paint.setColor(Color.WHITE);
        canvas.drawText(_game.getPlayer1().getName() + (_game.isDealer(_game.getPlayer1()) ? " (Dealer)" : ""), panel1.getX() + EDGE_OFFSET, panel1.getY() + EDGE_OFFSET + paint.getTextSize(), paint);
        canvas.drawText(_game.getPlayer2().getName() + (_game.isDealer(_game.getPlayer2()) ? " (Dealer)" : ""), panel3.getX() + EDGE_OFFSET, panel3.getY() + EDGE_OFFSET + paint.getTextSize(), paint);
        
        paint.setTextAlign(Align.RIGHT);
        canvas.drawText("Score: " + _game.getPlayer1Score(), view.getWidth() - EDGE_OFFSET, panel1.getY() + EDGE_OFFSET + paint.getTextSize(), paint);
        canvas.drawText("Score: " + _game.getPlayer2Score(), view.getWidth() - EDGE_OFFSET, panel3.getY() + EDGE_OFFSET + paint.getTextSize(), paint);
        
        // draw a random hand
        Hand hand = new Hand(Cards.ACE_OF_CLUBS, Cards.FIVE_OF_CLUBS, Cards.EIGHT_OF_CLUBS, Cards.NINE_OF_CLUBS, Cards.QUEEN_OF_CLUBS);
        
        HandView hview = new HandView(panel1.getX() + EDGE_OFFSET, panel1.getY() + panel1.getHeight() - EDGE_OFFSET - CardView.HEIGHT, hand, new ZIndexManager());
        hview.render(view, canvas, paint);
        
        Hand hand2 = new Hand(Cards.FOUR_OF_CLUBS, Cards.JACK_OF_DIAMONDS, Cards.TWO_OF_SPADES, Cards.THREE_OF_DIAMONDS, Cards.KING_OF_CLUBS);
        
        HandView hview2 = new HandView(panel1.getX() + EDGE_OFFSET, panel3.getY() + panel3.getHeight() - EDGE_OFFSET - CardView.HEIGHT, hand2, new ZIndexManager());
        hview2.render(view, canvas, paint);
        
        // draw the game state
        if (_game.getState().equals(GameState.CUTTING)) {
            _shuffledDeckView.render(view, canvas, paint);
        }
        
        // draw cut cards
        if (_game.player1CutCard != null) {
            new CardView((panel1.getWidth() / 2) - (CardView.WIDTH / 2), panel1.getY() + ((panel1.getHeight() / 2) - (CardView.HEIGHT / 2)), _game.player1CutCard).render(view, canvas, paint);
        }
        
        if (_game.player2CutCard != null) {
            new CardView((panel3.getWidth() / 2) - (CardView.WIDTH / 2), panel3.getY() + ((panel3.getHeight() / 2) - (CardView.HEIGHT / 2)), _game.player2CutCard).render(view, canvas, paint);
        }
    }
    
    @Override
    public boolean handleTap(int x, int y) {
        return _shuffledDeckView.handleTap(x, y);
    }
    
    private final Game _game;
    private final ShuffledDeckView _shuffledDeckView;
    
    private static final int EDGE_OFFSET = 15;

}
