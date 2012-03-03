package com.arahlf.cribbage.view;

import android.content.Context;
import android.widget.LinearLayout;

import com.arahlf.cribbage.model.Game;

public class GameView extends LinearLayout {
    
    public GameView(Context context, Game game) {
        super(context);
        
        _game = game;
        _playArea = new PlayArea(context, _game, _game.getPlayer1());
        
        addView(_playArea);
    }
    
    private final Game _game;
    private final PlayArea _playArea;
}
