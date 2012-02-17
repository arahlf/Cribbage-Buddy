package com.arahlf.cribbage.view;

import android.graphics.Canvas;
import android.graphics.Paint;

import com.arahlf.cribbage.model.Game;

public class GameView implements Renderable {
    
    public GameView(Game game) {
        _game = game;
    }
    
    @Override
    public void render(Canvas canvas, Paint paint) {
    }
    
    private final Game _game;
}
