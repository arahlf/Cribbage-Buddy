package com.arahlf.cribbage.view;

import android.graphics.Canvas;
import android.graphics.Paint;

public interface Renderable {
    
    public void render(int x, int y, Canvas canvas, Paint paint);
    
}
