package com.arahlf.cribbage.controller;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.arahlf.cribbage.model.Game;
import com.arahlf.cribbage.view.ZIndexManager;

public class GameController {
    
    public GameController(Game game) {
        _game = game;
    }
    
    public void renderViews(Canvas canvas, Paint paint) {
        
    }
    
    public boolean handleTapEvent(int x, int y) {
        return _manager.notifyTapEvent(x, y);
    }
    
    private final Game _game;
    private final ZIndexManager _manager = new ZIndexManager();
}
