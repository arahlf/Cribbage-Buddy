package com.arahlf.cribbage.controller;

import android.app.Activity;
import android.content.Context;

import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.view.GameView;

public class GameController {
    
    public GameController(Context context, Game game) {
        _game = game;
        _gameView = new GameView(context, _game);
        
        ((Activity) context).setContentView(_gameView);
    }
    
    private final Game _game;
    private final GameView _gameView;
}
